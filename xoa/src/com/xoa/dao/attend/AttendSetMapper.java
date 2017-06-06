package com.xoa.dao.attend;


import com.xoa.model.attend.AttendSet;

public interface AttendSetMapper {
     /**
      * 添加考勤信息
      * @param attendSet
      * @return
      */
     int addAttendSet(AttendSet  attendSet);
     /**
      * 修改考勤信息
      */
     int updateAttendSet(AttendSet  attendSet);

}