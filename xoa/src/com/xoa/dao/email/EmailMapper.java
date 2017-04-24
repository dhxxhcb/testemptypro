package com.xoa.dao.email;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.EmailModel;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:44:25
 * 类介绍  :   发件箱数据层
 * 构造参数:   
 *
 */
public interface EmailMapper extends BaseMapper<EmailModel>{
   
//   public int insert(Email email);

//   public int insertSelective(EmailModel record);
   /**
    * 
    * 创建作者:   张勇
    * 创建日期:   2017-4-20 上午10:45:18
    * 方法介绍:   未读点击转换为已读
    * 参数说明:   @param email
    * @return     void
    */
   public void updateIsRead(EmailModel email);
}