package com.xoa.dao.email;

import com.xoa.model.email.Email;

public interface EmailMapper {
    int insert(Email record);

    int insertSelective(Email record);
}