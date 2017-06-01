package com.xoa.controller.sys;

import com.xoa.service.sys.SystemInfoService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.Map;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/5/31 18:01
 * @类介绍: 系统参数类
 * @构造参数: 无
 **/
@Controller
@RequestMapping("sys")
public class SystemInfoController {

    @Resource
    private SystemInfoService systemInfoService;


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/31 19:54
     * @函数介绍: 获取系统信息
     * @参数说明: @param request
     * @return: json
     **/
    @ResponseBody
    @RequestMapping("/getSysMessage")
    public ToJson<Object> getSysMessage(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));


        ToJson<Object> toJson = new ToJson<Object>(0, "");
        try {


            Map<String, String> map = systemInfoService.getSystemInfo();
            String contextPath = request.getContextPath();
            String serverPath = System.getProperty("user.dir");
            //获取服务器绝对路径
            URL resource = Thread.currentThread().getContextClassLoader().getResource("");
            map.put("serverPath", serverPath);

            toJson.setMsg("OK");
            toJson.setFlag(0);
            toJson.setObject(map);
        } catch (Exception e) {
            toJson.setMsg(e.getMessage());
        }

        return toJson;
    }


}