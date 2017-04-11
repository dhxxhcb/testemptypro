package com.xoa.dao.email;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.Email;

public interface EmailMapper extends BaseMapper<Email>{
   
//   public int insert(Email email);

   public int insertSelective(Email record);
}