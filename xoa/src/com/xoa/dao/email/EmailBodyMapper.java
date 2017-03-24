package com.xoa.dao.email;

import com.xoa.model.email.EmailBody;
import com.xoa.model.email.EmailBodyWithBLOBs;

public interface EmailBodyMapper {
    int deleteByPrimaryKey(Integer bodyId);

    int insert(EmailBodyWithBLOBs record);

    int insertSelective(EmailBodyWithBLOBs record);

    EmailBodyWithBLOBs selectByPrimaryKey(Integer bodyId);

    int updateByPrimaryKeySelective(EmailBodyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EmailBodyWithBLOBs record);

    int updateByPrimaryKey(EmailBody record);
}