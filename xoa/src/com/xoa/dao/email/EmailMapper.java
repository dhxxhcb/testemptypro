package com.xoa.dao.email;

import com.xoa.model.email.Email;

public interface EmailMapper {
   
   public int insert(Email email);

   public int insertSelective(Email record);
}