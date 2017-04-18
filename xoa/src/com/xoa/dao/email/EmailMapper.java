package com.xoa.dao.email;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.EmailModel;

public interface EmailMapper extends BaseMapper<EmailModel>{
   
//   public int insert(Email email);

   public int insertSelective(EmailModel record);
}