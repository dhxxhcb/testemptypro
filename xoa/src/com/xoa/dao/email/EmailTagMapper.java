package com.xoa.dao.email;

import com.xoa.model.email.EmailTag;

public interface EmailTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(EmailTag record);

    int insertSelective(EmailTag record);

    EmailTag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(EmailTag record);

    int updateByPrimaryKey(EmailTag record);
}