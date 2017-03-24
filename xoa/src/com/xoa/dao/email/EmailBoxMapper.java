package com.xoa.dao.email;

import com.xoa.model.email.EmailBox;

public interface EmailBoxMapper {
    int deleteByPrimaryKey(Integer boxId);

    int insert(EmailBox record);

    int insertSelective(EmailBox record);

    EmailBox selectByPrimaryKey(Integer boxId);

    int updateByPrimaryKeySelective(EmailBox record);

    int updateByPrimaryKey(EmailBox record);
}