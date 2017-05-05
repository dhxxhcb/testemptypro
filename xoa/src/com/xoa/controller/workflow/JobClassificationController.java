package com.xoa.controller.workflow;

import com.xoa.service.workflow.JobClassificationService;
import com.xoa.service.workflow.wrapper.JobSelectorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 王曰岐 on 2017/5/4.
 */
@RestController
@RequestMapping("/workfolw")
public class JobClassificationController {

    @Autowired
    JobClassificationService service;

    @RequestMapping("/jobselector")
    public JobSelectorWrapper getSeletorInfo(){
        return   service.getJobSelector();
    }

}
