package com.xoa.dao.email;

import com.xoa.model.email.EmailBoxModel;

public interface EmailBoxMapper {
    int deleteByPrimaryKey(Integer boxId);

    int insert(EmailBoxModel record);

    int insertSelective(EmailBoxModel record);

    EmailBoxModel selectByPrimaryKey(Integer boxId);

    int updateByPrimaryKeySelective(EmailBoxModel record);

    int updateByPrimaryKey(EmailBoxModel record);
}