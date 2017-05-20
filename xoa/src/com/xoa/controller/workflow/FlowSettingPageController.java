package com.xoa.controller.workflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 韩东堂 on 2017/5/20.
 */
@Controller
@RequestMapping("/flowSetting")
public class FlowSettingPageController {


    @RequestMapping("/index")
    public String indexPage(Model model,Integer flowId){
        model.addAttribute("flowId",flowId);
        return "app/workflow/flowsettting/index";
    }

}
