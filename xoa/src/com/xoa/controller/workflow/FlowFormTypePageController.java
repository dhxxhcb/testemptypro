package com.xoa.controller.workflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 韩东堂 on 2017/5/11.
 */

@Controller
@RequestMapping("/workflow/formtype")
public class FlowFormTypePageController {

    @RequestMapping("/index")
    public String showPage(Model model){
        return "app/workflow/formtype/index";
    }
}
