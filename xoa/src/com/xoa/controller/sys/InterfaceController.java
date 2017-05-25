package com.xoa.controller.sys;

import com.xoa.model.sys.InterfaceModel;
import com.xoa.service.sys.InterFaceService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @创建作者: 韩成冰
 * @创建日期: 2017/5/25 9:53
 * @类介绍: 系统配置信息，对应interface表
 * @构造参数: 无
 **/

@Controller
@RequestMapping("/sys")
public class InterfaceController {

    @Resource
    private InterFaceService interfaceService;


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/25 12:21
     * @函数介绍: 查询interface表的STATUS_TEXT字段
     * @参数说明: @param paramname paramintroduce
     * @return: json
     **/
    @ResponseBody
    @RequestMapping(value = "/getStatusText")
    public ToJson<InterfaceModel> getStatusText(HttpServletRequest request) {
        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
                "loginDateSouse"));


        ToJson<InterfaceModel> tojson = new ToJson<>(0, "");
        try {

            List<InterfaceModel> interfaceModelList = interfaceService.getStaTusText();
            System.out.println(interfaceModelList);
            //list=sysParaService.getIeTitle1();
            tojson.setObject(interfaceModelList);
            tojson.setMsg("ok");
            tojson.setFlag(0);
        } catch (Exception e) {
            tojson.setMsg(e.getMessage());
        }
        return tojson;

    }


    /**
     * @创建作者: 韩成冰
     * @创建日期: 2017/5/25 12:23
     * @函数介绍: 修改
     * @参数说明: @param interfaceModel paramintroduce
     * @return: String 转发到查询
     **/
    @RequestMapping(value = "editStatusText", produces = {"application/json;charset=UTF-8"})
    public String editStatusText(InterfaceModel interfaceModel) {

        if (interfaceModel != null && interfaceModel.getStatusText() != null) {
            interfaceService.editStatusText(interfaceModel);
            return "redirect:getStatusText";
        }
        return null;

    }


}
