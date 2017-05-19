package com.xoa.dao.email;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.EmailBoxModel;


/**
 *  (勿删)
 * 创建作者:   张勇
 * 创建日期:   2017/5/15 16:25
 * 类介绍  :   邮件数据源层
 * 构造参数:
 *
 */
public interface EmailBoxMapper extends BaseMapper<EmailBoxModel>{

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/19 10:58
     * 方法介绍:   其他邮件删除文件夹
     * 参数说明:
     * @return
     */
    public void deleteBox(Integer boxId);

}