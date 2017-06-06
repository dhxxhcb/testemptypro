package com.xoa.controller.attend;

import com.xoa.model.attend.AttendSet;
import com.xoa.service.attend.AttendSetService;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gsb on 2017/6/6.
 */
public class AttendSetController {
    @Autowired
    private AttendSetService  attendSetService;

    @RequestMapping("/newAttendSet")
    @ResponseBody
    public BaseWrapper newAttendSet(AttendSet attendSet){

        return  attendSetService.newAttendSet(attendSet);
    }

}
