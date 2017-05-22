package com.xoa.service.email.impl;

import com.xoa.dao.email.EmailBodyMapper;
import com.xoa.dao.email.EmailBoxMapper;
import com.xoa.dao.email.EmailMapper;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.email.EmailBoxModel;
import com.xoa.model.email.EmailModel;
import com.xoa.model.enclosure.Attachment;
import com.xoa.service.email.EmailService;
import com.xoa.service.enclosure.EnclosureService;
import com.xoa.service.users.UsersService;
import com.xoa.util.DateFormat;
import com.xoa.util.GetAttachmentListUtil;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.page.PageParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:54:20
 * 类介绍  :   邮件业务层实现类
 * 构造参数:
 */
@Service
public class EmailServiceImpl implements EmailService {
    private Logger logger = Logger.getLogger(EmailServiceImpl.class);

    @Resource
    private EmailBodyMapper emailBodyMapper;

    @Resource
    private EmailMapper emailMapper;

    @Resource
    private EmailBoxMapper emailBoxMapper;

    @Resource
    private UsersService usersService;

    @Resource
    private EnclosureService enclosureService;

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:47:08
     * 方法介绍:   创建邮件并发送
     * 参数说明:   @param emailBody  邮件内容实体类
     * 参数说明:   @param email 邮件状态实体类
     * @return
     */
    @Override
    @Transactional
    public ToJson<EmailBodyModel> sendEmail(EmailBodyModel emailBody, EmailModel email) {
        ToJson<EmailBodyModel> toJson = new ToJson<EmailBodyModel>();
        try {
            emailBody.setSendTime(DateFormat.getTime(DateFormat.getStrDate(new Date())));
            emailBody.setSendFlag("1");
            emailBodyMapper.save(emailBody);
            String toID = emailBody.getToId2().trim()
                    + emailBody.getCopyToId().trim()
                    + emailBody.getSecretToId().trim();
            if (toID != null && toID != "") {
                String[] toID2 = toID.split(",");
                for (int i = 0; i < toID2.length; i++) {
                    email.setToId(toID2[i]);
                    email.setBoxId(0);
                    email.setBodyId(emailBody.getBodyId());
                    emailMapper.save(email);
                }
                toJson.setFlag(0);
                toJson.setMsg("ok");
            }
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("errorSendEmail");
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:47:26
     * 方法介绍:   草稿箱
     * 参数说明:   @param emailBody 邮件内容实体类
     *
     * @return
     */
    @Override
    @Transactional
    public ToJson<EmailBodyModel> saveEmail(EmailBodyModel emailBody) {
        ToJson<EmailBodyModel> toJson = new ToJson<EmailBodyModel>();
        try {
            emailBody.setSendTime(DateFormat.getTime(DateFormat.getStrDate(new Date())));
            emailBody.setSendFlag("0");
            emailBodyMapper.save(emailBody);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        }catch (Exception e){
            toJson.setFlag(1);
            toJson.setMsg("errorSendEmail");
        }
        return  toJson;
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:48:04
     * 方法介绍:   全部查询邮件
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     * 参数说明:   @throws Exception
     *
     * @return List<EmailBodyModel>
     */
    @SuppressWarnings("all")
    @Override
    public ToJson<EmailBodyModel> selectEmail(Map<String, Object> maps, Integer page,
                                              Integer pageSize, boolean useFlag, String sqlType) throws Exception {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        pageParams.setUseFlag(useFlag);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.selectObjcet(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }
            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }
            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:48:31
     * 方法介绍:   根据ID删除草稿箱邮件
     * 参数说明:   @param bodyId 邮件Id
     *
     * @return void
     */
    @Override
    public void deleteByID(Integer bodyId) {
        emailBodyMapper.deleteDrafts(bodyId);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:51:42
     * 方法介绍:   草稿箱查询
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     * 参数说明:   @throws Exception
     *
     * @return List<EmailBodyModel>
     */
    @Override
    public ToJson<EmailBodyModel> listDrafts(Map<String, Object> maps, Integer page,
                                             Integer pageSize, boolean useFlag, String sqlType) {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.listDrafts(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }
            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }

            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:52:01
     * 方法介绍:   已发送查询
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     * 参数说明:   @throws Exception
     *
     * @return List<EmailBodyModel>
     */
    @Override
    public ToJson<EmailBodyModel> listSendEmail(Map<String, Object> maps,
                                                Integer page, Integer pageSize, boolean useFlag, String sqlType) throws Exception {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.listSendEmail(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }
            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }
            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:52:30
     * 方法介绍:   废纸篓查询
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     * 参数说明:   @throws Exception
     *
     * @return List<EmailBodyModel>
     */
    @Override
    public ToJson<EmailBodyModel> listWastePaperbasket(Map<String, Object> maps,
                                                       Integer page, Integer pageSize, boolean useFlag, String sqlType) throws Exception {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.listWastePaperbasket(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }
            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }
            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:52:59
     * 方法介绍:   已发送查询
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     * 参数说明:   @throws Exception
     * 作废
     * @return List<EmailBodyModel>
     */
    @Override
    public ToJson<EmailBodyModel> selectEmailBody(Map<String, Object> maps,
                                                  Integer page, Integer pageSize, boolean useFlag, String sqlType) throws Exception {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.listqueryEmailBody(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }
            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }
            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:48:55
     * 方法介绍:   根据ID查询一条邮件
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     *
     * @return EmailBodyModel
     */
    @Override
    public EmailBodyModel queryById(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag, String sqlType) {
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        EmailBodyModel emailBody = emailBodyMapper.queryById(maps);
        emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
        if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
            emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
        } else {
            emailBody.setSecretToName("");
        }
        emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
        emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
        if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
            emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
        } else {
            emailBody.setCopyName("");
        }
        if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
            emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
        } else {
            emailBody.setAttachmentName("");
            emailBody.setAttachmentId("");
        }
        return emailBody;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:49:30
     * 方法介绍:   收件箱查询
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     * 参数说明:   @throws Exception
     *
     * @return List<EmailBodyModel>
     */
    @SuppressWarnings("all")
    @Override
    public ToJson<EmailBodyModel> selectInbox(Map<String, Object> maps, Integer page,
                                              Integer pageSize, boolean useFlag, String sqlType) throws Exception {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.selectInbox(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }

            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }
            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:53:42
     * 方法介绍:   未读
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 结果集合
     * 参数说明:   @throws Exception
     *
     * @return List<EmailBodyModel>
     */
    @Override
    public ToJson<EmailBodyModel> selectIsRead(Map<String, Object> maps, Integer page,
                                               Integer pageSize, boolean useFlag, String sqlType) throws Exception {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.selectIsRead(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }
            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-20 上午10:47:44
     * 方法介绍:    未读转为已读
     * 参数说明:   @param email  收件箱参数
     *
     * @return void
     */
    @Override
    public void updateIsRead(EmailModel email) {
        emailMapper.updateIsRead(email);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-21 上午11:16:38
     * 方法介绍:   发件箱删除
     * 参数说明:   @param emailBodyModel
     *
     * @return void
     */
    @Override
    public String deleteOutEmail(Integer emailId, String flag) {
        String returnRes = "0";
        try {
            if (flag.trim().equals("0") || flag.trim().equals("")) {
                emailBodyMapper.updateOutbox(emailId);
            } else if (flag.trim().equals("3")) {
                emailBodyMapper.updateOutboxs(emailId);
            } else {
                emailBodyMapper.deleteOutbox(emailId);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            returnRes = "1";
        }
        return returnRes;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-21 上午11:16:38
     * 方法介绍:   发件箱删除邮件
     * 参数说明:   @param emailBodyModel
     *
     * @return void
     */
    @Override
    public String deleteInEmail(Integer emailId, String flag) {
        String returnRes = "0";
        try {
            if (flag.trim().equals("0") || flag.trim().equals("")) {
                emailBodyMapper.updateInbox(emailId);
            } else {
                emailBodyMapper.updateInboxs(emailId);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            returnRes = "1";
        }
        return returnRes;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-21 上午11:16:38
     * 方法介绍:   废纸篓删除邮件
     * 参数说明:   @param emailBodyModel
     *
     * @return void
     */
    @Override
    public String deleteRecycleEmail(Integer emailId, String flag) {
        String returnRes = "0";
        try {
            if (flag.trim().equals("3")) {
                emailBodyMapper.updateRecycle(emailId);
            } else {
                emailBodyMapper.deleteRecycle(emailId);
            }
        } catch (Exception e) {
            returnRes = "1";
        }
        return returnRes;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-5-9 下午14:20:42
     * 方法介绍:   回复或转发返回信息处理
     * 参数说明:   @param maps 相关条件参数传值
     * 参数说明:   @param page 当前页
     * 参数说明:   @param pageSize 每页显示条数
     * 参数说明:   @param useFlag 是否开启分页插件
     * 参数说明:   @return 字符串
     */
    @Override
    public String queryByIdCss(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag, String sqlType) {
        EmailBodyModel emailBodyModel = this.queryById(maps, page, pageSize, useFlag, sqlType);
        StringBuffer fwReEmail = new StringBuffer();
        fwReEmail.append("&nbsp;");
        fwReEmail.append("<div style=\"margin: 5px auto; height: 0px; border-bottom-color: rgb(192, 194, 207); border-bottom-width: 1px; border-bottom-style: solid;\">&nbsp;</div>\n");
        fwReEmail.append("<div style=\"background: rgb(237, 246, 219); padding: 5px 15px; font-size: 12px; border-bottom-color: rgb(204, 204, 204); border-bottom-width: 1px; border-bottom-style: solid;\"><span style=\"line-height: 16px;\"><b>发件人：</b>&nbsp;");
        fwReEmail.append(emailBodyModel.getUsers().getUserName());
        fwReEmail.append("</span><br />");
        fwReEmail.append("<span style=\"line-height: 16px;\"><b>收件人：</b>&nbsp;");
        fwReEmail.append(emailBodyModel.getToName());
        fwReEmail.append("</span><br />");
        if (emailBodyModel.getCopyName() != "") {
            fwReEmail.append("<span style=\"line-height: 16px;\"><b>抄送人：</b>&nbsp;");
            fwReEmail.append(emailBodyModel.getCopyName());
            fwReEmail.append("</span><br />");
        }
        if (emailBodyModel.getSecretToName() != "") {
            fwReEmail.append("<span style=\"line-height: 16px;\"><b>密送人：</b>&nbsp;");
            fwReEmail.append(emailBodyModel.getSecretToName());
            fwReEmail.append("</span><br />");
        }
        fwReEmail.append("<span style=\"line-height: 16px;\"><b>发送时间：</b>&nbsp;");
        fwReEmail.append(DateFormat.getStrTime(emailBodyModel.getSendTime()));
        fwReEmail.append("</span><br />");
        fwReEmail.append("<span style=\"line-height: 16px;\"><b>主题：</b>&nbsp;");
        fwReEmail.append(emailBodyModel.getSubject());
        fwReEmail.append("</span></div>");
        fwReEmail.append(emailBodyModel.getContent());
        return fwReEmail.toString();
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/15 15:35
     * 方法介绍:
     * 参数说明:   发件箱、收件箱内容信息保存
     * 参数说明:   收件人实体类
     *
     * @return
     */
    @Override
    @Transactional
    public ToJson<EmailBodyModel>  draftsSendEmail(EmailBodyModel emailBody, EmailModel email) {
//        boolean isFlag = true;
        ToJson<EmailBodyModel> toJson = new ToJson<EmailBodyModel>();
        try {
            emailBody.setSendTime(DateFormat.getTime(DateFormat.getStrDate(new Date())));
            emailBodyMapper.update(emailBody);
            if ("1".equals(emailBody.getSendFlag())) {
                String toID = emailBody.getToId2().trim()
                        + emailBody.getCopyToId().trim()
                        + emailBody.getSecretToId().trim();
                if (toID != null && toID != "") {
                    String[] toID2 = toID.split(",");
                    for (int i = 0; i < toID2.length; i++) {
                        email.setToId(toID2[i]);
                        email.setBoxId(0);
                        email.setBodyId(emailBody.getBodyId());
                        emailMapper.save(email);
                    }
                    toJson.setFlag(0);
                    toJson.setMsg("ok");
                }
            }else{
                toJson.setFlag(0);
                toJson.setMsg("ok");
            }
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("errorSendEmail");
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017-4-27 下午1:54:02
     * 方法介绍:   收件人user_id转换为姓名
     * 参数说明:   @param listEmail
     * 参数说明:   @return
     *
     * @return List<EmailModel>
     */
    public List<EmailModel> returnEmail(List<EmailModel> listEmail) {
        List<EmailModel> list = new ArrayList<EmailModel>();
        for (EmailModel emailModel : listEmail) {
            emailModel.setToName(usersService.getUserNameById(emailModel.getToId()));
            list.add(emailModel);
        }
        return list;
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/15 16:37
     * 方法介绍:   新建其他邮件文件夹
     * 参数说明:
     *
     * @return
     */
    @Override
    @Transactional
    public ToJson<EmailBoxModel> saveEmailBox(EmailBoxModel emailBoxModel) {
        ToJson<EmailBoxModel> toJson = new ToJson<EmailBoxModel>();
        try {
            emailBoxMapper.save(this.returnBoxModel(emailBoxModel));
            toJson.setFlag(0);
            toJson.setMsg("ok");
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/15 16:39
     * 方法介绍:   把收件箱邮件转移到其他邮件文件夹中
     * 参数说明:
     *
     * @return
     */
    @Override
    @Transactional
    public ToJson<EmailModel> updateEmailBox(EmailModel emailModel) {
        ToJson<EmailModel> toJson = new ToJson<EmailModel>();
        try {
            emailMapper.updateEmailBox(emailModel);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }


    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/15 16:38
     * 方法介绍:   查询所有其他邮件文件夹
     * 参数说明:
     *
     * @return
     */
    @SuppressWarnings("all")
    @Override
    public ToJson<EmailBoxModel> showEmailBox(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag) {
        ToJson<EmailBoxModel> toJson = new ToJson<EmailBoxModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBoxModel> list = emailBoxMapper.selectObjcet(maps);
        int len = list.size();
        if (len < 0) {
            toJson.setFlag(1);
            toJson.setMsg("error");
        } else {
            toJson.setFlag(0);
            toJson.setMsg("ok");
            toJson.setObj(list);
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/15 16:48
     * 方法介绍:   其他邮箱中的邮件列表
     * 参数说明:
     *
     * @return
     */
    @SuppressWarnings("all")
    @Override
    public ToJson<EmailBodyModel> selectBoxEmail(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag, String sqlType) {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.selectBoxEmail(maps);
        Integer len = listEmai.size();
        if (len > 0) {
            for (EmailBodyModel emailBody : listEmai) {
                emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
                if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                    emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
                } else {
                    emailBody.setCopyName("");
                }
                if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                    emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
                } else {
                    emailBody.setSecretToName("");
                }
                emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
                emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
                if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                    emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
                } else {
                    emailBody.setAttachmentName("");
                    emailBody.setAttachmentId("");
                }
                list.add(emailBody);
            }
            tojson.setFlag(0);
            tojson.setMsg("ok");
            tojson.setObj(list);
            tojson.setTotleNum(pageParams.getTotal());
        } else {
            tojson.setFlag(1);
            tojson.setMsg("error");
        }
        return tojson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/15 17:00
     * 方法介绍:   删除其他邮件文件夹，并判断该文件夹是否存在邮件
     * 参数说明:
     *
     * @return
     */
    @Override
//	@Transactional
    public ToJson<EmailBodyModel> deleteBoxEmail(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag) {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
//		fromId  收件人用户
//		boxId
        boolean flags = true;
        List<EmailBodyModel> list = emailBodyMapper.selectIsBoxEmail(maps);
        int len = list.size();
        System.out.println(len);
        if (len > 0) {
            flags = false;
        } else {
//			删除其他邮件文件
            try {
                emailBoxMapper.deleteBox((Integer) maps.get("boxId"));
            } catch (Exception e) {
                flags = false;
            }
        }
        if (flags) {
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
     * 创建日期:   2017/5/19 10:20
     * 方法介绍:   其他邮件文件名和序号修改
     * 参数说明:
     *
     * @return
     */
    @Override
    @Transactional
    public ToJson<EmailBoxModel> updeateEmailBoxName(EmailBoxModel emailBoxModel) {
        ToJson<EmailBoxModel> toJson = new ToJson<EmailBoxModel>();
        try {
            emailBoxMapper.update(emailBoxModel);
            toJson.setFlag(0);
            toJson.setMsg("ok");
        } catch (Exception e) {
            toJson.setFlag(1);
            toJson.setMsg("error");
        }
        return toJson;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/19 18:20
     * 方法介绍:   收件箱未读查询
     * 参数说明:
     * @return
     */
    @Override
    public ToJson<EmailBodyModel> selectInboxIsRead(Map<String,Object> maps, Integer page, Integer pageSize, boolean useFlag,String sqlType) {
        ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
        PageParams pageParams = new PageParams();
        pageParams.setUseFlag(useFlag);
        pageParams.setPage(page);
        pageParams.setPageSize(pageSize);
        maps.put("page", pageParams);
        List<EmailBodyModel> list = new ArrayList<EmailBodyModel>();
        List<EmailBodyModel> listEmai = emailBodyMapper.selectInboxIsRead(maps);
        for (EmailBodyModel emailBody : listEmai) {
            emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
            if (usersService.getUserNameById(emailBody.getCopyToId()) != null) {
                emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyToId()));
            } else {
                emailBody.setCopyName("");
            }
            if (usersService.getUserNameById(emailBody.getSecretToId()) != null) {
                emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToId()));
            } else {
                emailBody.setSecretToName("");
            }
            emailBody.setEmailList(this.returnEmail(emailBody.getEmailList()));
            if (emailBody.getAttachmentName() != null && emailBody.getAttachmentId() != null) {
                emailBody.setAttachment(GetAttachmentListUtil.returnAttachment(emailBody.getAttachmentName(), emailBody.getAttachmentId(), sqlType, GetAttachmentListUtil.MODULE_EMAIL));
            } else {
                emailBody.setAttachmentName("");
                emailBody.setAttachmentId("");
            }
            emailBody.setProbablyDate(DateFormat.getProbablyDate(emailBody.getSendTime()));
            list.add(emailBody);
        }
        tojson.setObj(list);
        tojson.setTotleNum(pageParams.getTotal());
        return tojson;
    }


    public EmailBoxModel returnBoxModel(EmailBoxModel emailBoxModel) {
        if (StringUtils.checkNull(emailBoxModel.getDefaultCount())) {
            emailBoxModel.setDefaultCount("");
        }
        return emailBoxModel;
    }


}
