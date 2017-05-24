package com.xoa.controller.workflow;

import com.xoa.model.users.Users;
import com.xoa.model.workflow.FlowRunPrcs;
import com.xoa.service.workflow.flowtype.FlowRunPrcsService;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.session.SessionUtils;
import com.xoa.util.dataSource.ContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建作者:   张勇
 * 创建日期:   2017/5/24 20:38
 * 类介绍  :
 * 构造参数:
 */
@Controller
public class FlowRunController {

    @Resource
    private FlowRunPrcsService flowRunPrcsService;

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:29
     * 方法介绍:   查询代办工作
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "selectWork", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<FlowRunPrcs> selectObject(FlowRunPrcs flowRunPrcs, HttpServletRequest request,
                                 @RequestParam(value = "flag", required = false) boolean flag,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                 @RequestParam(value = "useFlag", required = false) boolean useFlag
    ) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(flowRunPrcs.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("userId", userId);
        }else {
            maps.put("userId", flowRunPrcs.getUserId());
        }
        return flowRunPrcsService.selectObject(maps, page, pageSize, useFlag);
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/24 20:29
     * 方法介绍:   查询代办工作
     * 参数说明:
     *
     * @return
     */
    @RequestMapping(value = "selectEndWord", produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    ToJson<FlowRunPrcs> selectEnd(FlowRunPrcs flowRunPrcs, HttpServletRequest request,
                                 @RequestParam(value = "flag", required = false) boolean flag,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                 @RequestParam(value = "useFlag", required = false) boolean useFlag
    ) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));
        Map<String, Object> maps = new HashMap<String, Object>();
        if (StringUtils.checkNull(flowRunPrcs.getUserId())) {
            String userId = SessionUtils.getSessionInfo(request.getSession(), Users.class, new Users()).getUserId();
            maps.put("userId", userId);
        }else {
            maps.put("userId", flowRunPrcs.getUserId());
        }
        return flowRunPrcsService.selectEnd(maps, page, pageSize, useFlag);
    }

}