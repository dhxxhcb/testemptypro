package com.xoa.controller.workflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王曰岐 on 2017/5/5.
 */
@Controller
@RequestMapping("/workflow/flowclassify")
public class JobClassifyPageController {

    @RequestMapping("/index")
    public String showPage(Model model){
        return "app/workflow/flowclassify/index";
    }
}
