package com.xoa.dao;

import com.xoa.model.EmailBox;

public interface EmailBoxMapper {
    int deleteByPrimaryKey(Integer boxId);

    int insert(EmailBox record);

    int insertSelective(EmailBox record);

    EmailBox selectByPrimaryKey(Integer boxId);

    int updateByPrimaryKeySelective(EmailBox record);

    int updateByPrimaryKey(EmailBox record);
}