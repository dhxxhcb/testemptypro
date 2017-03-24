package com.xoa.dao;

import com.xoa.model.Email;

public interface EmailMapper {
    int insert(Email record);

    int insertSelective(Email record);
}