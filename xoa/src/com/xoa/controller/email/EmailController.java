package com.xoa.controller.email;

import com.alibaba.fastjson.JSON;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.email.EmailBoxModel;
import com.xoa.model.email.EmailModel;
import com.xoa.model.users.Users;
import com.xoa.service.email.EmailService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;
import com.xoa.util.common.L;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:32:14
 * 类介绍  :   邮件
 * 构造参数:
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/email")
public class EmailController {
    private Logger loger = Logger.getLogger(EmailController.class);

    @Resource
    private EmailService emailService;

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:33:59
     * 方法介绍:   发送邮件并保存
     * 参数说明:	   @param emailBodyModel 邮件参数对象
     * 参数说明:	   @param sendFlag 是否为草稿箱发送 （0：是）
     * 参数说明:   @return
     * method = RequestMethod.POST,
     * @return String
     */
    @RequestMapping(value = "/sendEmail",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public @ResponseBody
    ToJson<EmailBodyModel> insertEmailBody(
            EmailBodyModel emailBodyModel,
            @RequestParam(value = "sendFlag", required = false) String sendFlag,
            HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        if (StringUtils.checkNull(emailBodyModel.getFromId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            emailBodyModel.setFromId(userId);
        }
        if ("0".equals(sendFlag)) {
            emailBodyModel.setSendFlag("1");
            return emailService.draftsSendEmail(emailBodyModel, new EmailModel());
        } else {
            return emailService.sendEmail(emailBodyModel, new EmailModel());
        }
    }

    /**
     * 创建作者:      张勇
     * 创建日期:      2017-4-18 下午2:11:13
     * 类介绍:       保存或修改草稿箱
     * 方法介绍:   发送邮件并保存
     * 参数说明:	   @param emailBodyModel 邮件参数对象
     *  method = RequestMethod.POST,
     * 参数说明:      @return
     */
    @RequestMapping(value = "/saveEmail",produces = {"application/json;charset=UTF-8"},method = RequestMethod.POST)
    public @ResponseBody
    ToJson<EmailBodyModel> saveEmailBody(
            EmailBodyModel emailBodyModel,
            HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        if (StringUtils.checkNull(emailBodyModel.getFromId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            emailBodyModel.setFromId(userId);
        }
        if(emailBodyModel.getBodyId() == null) {
            return emailService.saveEmail(emailBodyModel);
        }else{
            emailBodyModel.setSendFlag("0");
            return emailService.draftsSendEmail(emailBodyModel,new EmailModel());
        }
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:35:16
     * 方法介绍:   查询列表
     * 参数说明:   @param  request inbox 收件箱 drafts 草稿箱 outbox 发件箱 recycle 废纸篓 noRead 未读
     * 参数说明:   @return json
     * 参数说明:   @throws Exception
     *
     * @return String
     */
    @RequestMapping(value = "/showEmail", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> queryEmail(HttpServletRequest request) throws Exception {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        String flag = ServletRequestUtils.getStringParameter(request, "flag");
        Integer page = ServletRequestUtils.getIntParameter(request, "page");
        Integer pageSize = ServletRequestUtils.getIntParameter(request,
                "pageSize");

        boolean useFlag = ServletRequestUtils.getBooleanParameter(request,
                "useFlag");
        String startDate = ServletRequestUtils.getStringParameter(request, "startDate");
        String endDate = ServletRequestUtils.getStringParameter(request, "endDate");
        String subject = ServletRequestUtils.getStringParameter(request, "subject");
        String content = ServletRequestUtils.getStringParameter(request, "content");
        String attachmentName = ServletRequestUtils.getStringParameter(request, "attachmentName");
        String userId = "";
        String userFrom = ServletRequestUtils.getStringParameter(request,
                "userID");
        if (StringUtils.checkNull(userFrom)) {
            userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
        } else {
            userId = userFrom.trim();
        }
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("fromId", userId);
        maps.put("subject", subject);
        if (!StringUtils.checkNull(content)) {
            maps.put("content", content);
        }
        if (!StringUtils.checkNull(attachmentName)) {
            maps.put("attachmentName", attachmentName);
        } else {
            maps.put("attachmentName", "");
        }
        if (!StringUtils.checkNull(startDate)) {
            maps.put("startTime", DateFormat.getTime(startDate));
        }
        if (!StringUtils.checkNull(endDate)) {
            maps.put("endTime", DateFormat.getTime(endDate));
        }

        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        if (flag.trim().equals("inbox")) {
            tojson = emailService.selectInbox(maps, page, pageSize, useFlag, sqlType);
        } else if (flag.trim().equals("drafts")) {
            tojson = emailService.listDrafts(maps, page, pageSize, useFlag, sqlType);
        } else if (flag.trim().equals("outbox")) {
            tojson = emailService.listSendEmail(maps, page, pageSize, useFlag, sqlType);
        } else if (flag.trim().equals("recycle")) {
            tojson = emailService.listWastePaperbasket(maps, page, pageSize,
                    useFlag, sqlType);
        } else if (flag.trim().equals("noRead")) {
            tojson = emailService.selectIsRead(maps, page, pageSize, useFlag, sqlType);
        } else {
            tojson = emailService.selectEmail(maps, page, pageSize, useFlag, sqlType);
        }
        if (tojson.getObj().size() > 0) {
            tojson.setFlag(0);
            tojson.setMsg("ok");
        } else {
            tojson.setFlag(1);
            tojson.setMsg("error");
        }
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:35:48
     * 方法介绍:   根据ID查询内容
     * 参数说明:   @param request HTTP请求
     * 参数说明:   @return Json
     * 参数说明:   @throws Exception
     *
     * @return String
     */
    @RequestMapping(value = "/queryByID", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> queryByID(HttpServletRequest request, @RequestParam(value = "emailId", required = false) Integer emailId, @RequestParam("flag") String flag, @RequestParam(value = "bodyId", required = false) Integer bodyId) throws Exception {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("emailId", emailId);
        maps.put("bodyId", bodyId);
        EmailBodyModel emailBody = emailService.queryById(maps, 1, 5, false, sqlType);
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        if (!flag.trim().equals("isRead")) {
            if (emailBody.getBodyId() != null) {
                tojson.setFlag(0);
                tojson.setMsg("ok");
                tojson.setObject(emailBody);
            } else {
                tojson.setFlag(1);
                tojson.setMsg("errorQueryByID");
            }
        } else {
            EmailModel email = new EmailModel();
            email.setEmailId(emailId);
            email.setReadFlag("1");
            emailService.updateIsRead(email);
            tojson.setFlag(0);
            tojson.setMsg("ok");
            tojson.setObject(emailBody);
        }
        return tojson;
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:35:16
     * 方法介绍:   删除列表
     * 参数说明:   @param  request inbox 收件箱  outbox 发件箱 recycle 废纸篓
     * 参数说明:   @return json
     * 参数说明:   @throws Exception
     *
     * @return String
     */
    @RequestMapping(value = "/deleteEmail", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> deleteEmail(@RequestParam("flag") String flag, @RequestParam("deleteFlag") String deleteFlag,
                                       @RequestParam("emailID") Integer emailId, HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        String returnRes = "";
        if (flag.trim().equals("inbox")) {
            returnRes = emailService.deleteInEmail(emailId, deleteFlag);
        } else if (flag.trim().equals("outbox")) {
            returnRes = emailService.deleteOutEmail(emailId, deleteFlag);
        } else if (flag.trim().equals("recycle")) {
            returnRes = emailService.deleteRecycleEmail(emailId, deleteFlag);
        }

//		else if (flag.trim().equals("drafts")) {
//			emailService.deleteRecycleEmail(emailBodyModel, deleteFlag);
//		}
        if (returnRes.equals("0")) {
            tojson.setFlag(0);
            tojson.setMsg("ok");
        } else {
            tojson.setFlag(1);
            tojson.setMsg("error");
        }
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:35:16
     * 方法介绍:   草稿箱删除
     * 参数说明:   @param  bodyId 邮箱内容ID
     * 参数说明:   @return json
     *
     * @return String
     */
    @RequestMapping(value = "/deleteDraftsEmail", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> deleteDraftsEmail(@RequestParam("bodyId") Integer bodyId,
                                             HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        try {
            ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(0, "ok");
            emailService.deleteByID(bodyId);
            return tojson;
        } catch (Exception e) {
            ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>(1, "error");
            return tojson;
        }
    }

    @RequestMapping(value = "/messageEmail", produces = {"application/json;charset=UTF-8"})
    public String queryByIdFwRw(HttpServletRequest request,
                                @RequestParam(value = "emailId") Integer emailId) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
//		String sqlType = "xoa1001";
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("emailId", emailId);
        request.setAttribute("fwRwEmail", emailService.queryByIdCss(maps, 1, 5, false, sqlType));
        return "app/email/messageEmail";
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:33:59
     * 方法介绍:   回复或转发简历
     * 参数说明:	   @param emailBodyModel 邮件参数对象
     * 参数说明:	   @param emailId  获取收件箱ID参数
     * 参数说明:	   @param sendFlag 是否为草稿箱发送 （0：是）
     * 参数说明:   @return
     *
     * @return String
     */
    @RequestMapping(value = "/sendMessageEmail", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> fwRwEmailBody(
            @RequestParam(value = "emailId") Integer emailId,
            @RequestParam(value = "sendFlag", required = false) String sendFlag,
           EmailBodyModel emailBodyModel,
            HttpServletRequest request) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("emailId", emailId);
        String fwRwEmail = emailService.queryByIdCss(maps, 1, 5, false, sqlType);
        if ("0".equals(sendFlag)) {
            emailBodyModel.setSendFlag("1");
            emailBodyModel.setContent(emailBodyModel.getContent()+fwRwEmail);
            return emailService.draftsSendEmail(emailBodyModel, new EmailModel());
        } else {
            emailBodyModel.setContent(emailBodyModel.getContent()+fwRwEmail);
            return emailService.sendEmail(emailBodyModel , new EmailModel());
        }
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:33:59
     * 方法介绍:   回复、转发保存或修改到草稿
     * 参数说明:	   @param emailId 原邮件id
     * 参数说明:	   @param emailBodyModel 新邮件参数
     * 参数说明:   @return
     *
     * @return String
     */
    @RequestMapping(value = "/saveMessageEmail", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> fwRwSaveEmailBody(
            @RequestParam(value = "emailId") Integer emailId,
           EmailBodyModel emailBodyModel,
            HttpServletRequest request) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
            Map<String, Object> maps = new HashMap<String, Object>();
            maps.put("emailId", emailId);
            String fwRwEmail = emailService.queryByIdCss(maps, 1, 5, false, sqlType);
            if (StringUtils.checkNull(emailBodyModel.getFromId())) {
                String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
                emailBodyModel.setFromId(userId);
            }
            emailBodyModel.setContent(emailBodyModel.getContent()+fwRwEmail);
            if(StringUtils.checkNull(emailBodyModel.getBodyId().toString())) {
                return emailService.saveEmail(emailBodyModel);
            }else{
                emailBodyModel.setSendFlag("0");
                return emailService.draftsSendEmail(emailBodyModel,new EmailModel());
            }

    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/17 12:31
     * 方法介绍:   新建其他邮件文件夹
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "/saveEmailBox", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBoxModel> saveEmailBox(HttpServletRequest request, EmailBoxModel emailBoxModel) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        if (StringUtils.checkNull(emailBoxModel.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            emailBoxModel.setUserId(userId);
        }
        return emailService.saveEmailBox(emailBoxModel);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/17 12:35
     * 方法介绍:   把收件箱邮件转移到其他邮件文件夹中
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "/updateEmailBox", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailModel> updateEmailBox(HttpServletRequest request, EmailModel emailModel) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        if (StringUtils.checkNull(emailModel.getToId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            emailModel.setToId(userId);
        }
        return emailService.updateEmailBox(emailModel);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/17 12:36
     * 方法介绍:   查询所有其他邮件文件夹
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "/showEmailBox", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBoxModel> showEmailBox(HttpServletRequest request,
                                       @RequestParam(value = "page") Integer page, @RequestParam(value = "pageSize") Integer pageSize,
                                       @RequestParam(value = "useFlag") boolean useFlag,
                                       @RequestParam(value = "userId", required = false) String userId) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(userId)) {
//			userId = (String)request.getSession().getAttribute("userId");
            userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("userId", userId);
        } else {
            userId = userId.trim();
            maps.put("userId", userId);
        }
        return emailService.showEmailBox(maps, page, pageSize, useFlag);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/19 11:09
     * 方法介绍:   其他邮箱中的邮件列表
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "/selectBoxEmail", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> selectBoxEmail(HttpServletRequest request,
                                          @RequestParam(value = "page") Integer page, @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(value = "useFlag") boolean useFlag,
                                          @RequestParam(value = "toId", required = false) String toId, @RequestParam(value = "boxId") Integer boxId) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(toId)) {
            toId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("fromId", toId);
        } else {
            toId = toId.trim();
            maps.put("fromId", toId);
        }
        maps.put("boxId", boxId);
        return emailService.selectBoxEmail(maps, page, pageSize, useFlag, sqlType);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/19 11:25
     * 方法介绍:   其他邮件删除
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "/deleteBoxEmail", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> deleteBoxEmail(HttpServletRequest request,
                                          @RequestParam(value = "page") Integer page, @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(value = "useFlag") boolean useFlag,
                                          @RequestParam(value = "fromId", required = false) String fromId, @RequestParam(value = "boxId") Integer boxId) {
//		fromId  收件人用户
//		boxId
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(fromId)) {
            String toId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("fromId", toId);
        } else {
            maps.put("fromId", fromId.trim());
        }
        maps.put("boxId", boxId);
        return emailService.deleteBoxEmail(maps, page, pageSize, useFlag);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/19 11:28
     * 方法介绍:   其他邮件文件夹名字和序号修改
     * 参数说明:
     * @return
     */
    @RequestMapping(value = "/updateEmailBoxName", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBoxModel> updeateEmailBoxName(HttpServletRequest request, EmailBoxModel emailBoxModel) {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        if (StringUtils.checkNull(emailBoxModel.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            emailBoxModel.setUserId(userId);
        }
        return emailService.updeateEmailBoxName(emailBoxModel);
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:39:24
     * 方法介绍:   为null时转换为""
     * 参数说明:   @param value 需转换字符串
     * 参数说明:   @return Json
     *
     * @return String
     */
    public static String returnValue(String value) {
        if (value != null) {
            return value;
        } else {
            return "";
        }
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:38:04
     * 方法介绍:   多条件查询邮件
     * 参数说明:   @return Json
     * 参数说明:   @throws Exception
     * 作废
     * @return String
     */
    @RequestMapping(value = "/querylistEmailBody", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<EmailBodyModel> querylistEmailBody(HttpServletRequest request) throws Exception {
        String sqlType = "xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse");
        ContextHolder.setConsumerType(sqlType);
        Map<String, Object> maps = new HashMap<String, Object>();
        // maps.put("startTime",starttime);
        // maps.put("endTime", endtime);
        maps.put("readFlag", 1);
        maps.put("boxId", 0);
        maps.put("userName", "李佳");
        maps.put("sign", "");
        maps.put("keyword", "通知");
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        tojson = emailService.selectEmailBody(maps, 1, 10, true, sqlType);
        if (tojson.getObj().size() > 0) {
            tojson.setFlag(0);
            tojson.setMsg("ok");
            Map<String, String> map = new HashMap<String, String>();
        } else {
            tojson.setFlag(1);
            tojson.setMsg("error");
        }
        return tojson;
    }




    @RequestMapping("/inboxup")
    public String inboxUp(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/inboxup";
    }

    @RequestMapping("/addbox")
    public String writeMail(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/addbox";
    }

    @RequestMapping("/index")
    public String emailIndex(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/index";
    }

    @RequestMapping("/mailQuery")
    public String mailQuery(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/mailQuery";
    }

    @RequestMapping("/development")
    public String develOpment(HttpServletRequest request)
            throws Exception {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/common/development";
    }

    @RequestMapping("/writeEmail")
    public String writeEmail(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/writeMail";
    }

    @RequestMapping("/details")
    public String details(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/details";
    }

    @RequestMapping("/manageMail")
    public String manageMail(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/manageMail";
    }

    @RequestMapping("/emptyFolder")
    public String emptyFolder(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        return "app/email/emptyFolder";
    }

}
