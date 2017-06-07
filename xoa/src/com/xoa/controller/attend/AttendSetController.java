package com.xoa.controller.attend;

import com.xoa.model.attend.AttendSet;
import com.xoa.service.attend.AttendSetService;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gsb on 2017/6/6.
 */
@Controller
@RequestMapping("/attendSet")
public class AttendSetController {
    @Autowired
    private AttendSetService  attendSetService;

    @RequestMapping(value = "/newAttendSet", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public BaseWrapper newAttendSet(AttendSet attendSet){

        return  attendSetService.newAttendSet(attendSet);
    }
    @RequestMapping(value = "/updateAttendSet", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public BaseWrapper updateAttendSet(AttendSet attendSet){

        return  attendSetService.updateAttendSet(attendSet);
    }

}
