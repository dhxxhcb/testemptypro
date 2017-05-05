package com.xoa.controller.workflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-5-5 下午6:00:02 
 * @类介绍 流程分类界面映射类
 * @构造参数 无
 *
 */
@Controller
@RequestMapping("/workflow/flowclassify")
public class JobClassifyPageController {
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-5-5 下午6:00:36 
     * @方法介绍 分类设置界面
     * @参数说明 @param model
     * @参数说明 @return
     * @return
     */
    @RequestMapping("/index")
    public String showPage(Model model){
        return "app/workflow/flowclassify/index";
    }
}
