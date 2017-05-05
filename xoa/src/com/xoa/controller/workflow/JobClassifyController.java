package com.xoa.controller.workflow;

import com.xoa.service.workflow.JobClassifyService;
import com.xoa.service.workflow.wrapper.JobSelectorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 王曰岐 on 2017/5/4.
 */
@RestController
@RequestMapping("/workfolw")
public class JobClassifyController {

    @Autowired
    JobClassifyService service;

    @RequestMapping("/flowclassify/datas")
    public JobSelectorWrapper getSeletorInfo(){
        return   service.getJobSelector();
    }

}
