package com.xoa.service.attend;

import com.xoa.dao.attend.AttendSetMapper;
import com.xoa.model.attend.AttendSet;
import com.xoa.service.attend.wrapper.AttendSetWrappers;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gsb on 2017/6/6.
 */
@Service
public class AttendSetService {
    @Autowired
    private AttendSetMapper  attendSetMapper;

     public BaseWrapper newAttendSet(AttendSet attendSet){
         AttendSetWrappers  wrappers=new AttendSetWrappers();

         if (StringUtils.checkNull(attendSet.getTitle())){
             wrappers.setFlag(false);
             wrappers.setStatus(true);
             wrappers.setMsg("考勤签到类型名称不能为空");
             return wrappers;
         }
         int res=attendSetMapper.addAttendSet(attendSet);
         if(res>0){
             wrappers.setFlag(true);
             wrappers.setStatus(true);
             wrappers.setMsg("更新成功");
         }else{
             wrappers.setFlag(false);
             wrappers.setStatus(true);
             wrappers.setMsg("更新失败");
         }

         return  wrappers;
     }

}
