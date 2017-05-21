package com.xoa.dao.email;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.EmailBodyModel;

import java.util.List;
import java.util.Map;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:42:25
 * 类介绍  :   邮件数据源层
 * 构造参数:   
 *
 */
public interface EmailBodyMapper extends BaseMapper<EmailBodyModel>{

	public int updateByPrimaryKey(EmailBodyModel record);

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:42:43
	 * 方法介绍:   根据ID删除草稿箱邮件
	 * 参数说明:   @param bodyId
	 * @return     void
	 */
	public void deleteDrafts(Integer bodyId);

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:42:54
	 * 方法介绍:   根据ID查询一条邮件
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     EmailBodyModel
	 */
	public EmailBodyModel queryById(Map<String,Object> maps);

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:43:03
	 * 方法介绍:   收件箱查询
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<EmailBodyModel>
	 */
	List<EmailBodyModel> selectInbox(Map<String, Object> maps);	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:43:12
	 * 方法介绍:   草稿箱查询
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<EmailBodyModel>
	 */
	List<EmailBodyModel> listDrafts(Map<String, Object> maps);

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:43:23
	 * 方法介绍:   已发送查询
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<EmailBodyModel>
	 */
	List<EmailBodyModel> listSendEmail(Map<String, Object> maps);

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:43:31
	 * 方法介绍:   未读
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<EmailBodyModel>
	 */
	List<EmailBodyModel> selectIsRead(Map<String,Object> maps);
	
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:43:42
	 * 方法介绍:   废纸篓查询
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 * @return     List<EmailBodyModel>
	 */
	List<EmailBodyModel> listWastePaperbasket(Map<String, Object> maps);

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:43:51
	 * 方法介绍:   多条件分页查询邮箱
	 * 参数说明:   @param maps
	 * 参数说明:   @return
	 *  作废
	 * @return     List<EmailBodyModel>
	 */
	List<EmailBodyModel> listqueryEmailBody(Map<String, Object> maps);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午10:07:01
	 * 方法介绍:   发件箱删除 变为2
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	public void updateOutbox(Integer emailId);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午10:07:39
	 * 方法介绍:   发件箱删除 变为4
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	public void updateOutboxs(Integer emailId);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午10:39:20
	 * 方法介绍:   发件箱为1时删除 
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	public void deleteOutbox(Integer emailId);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午10:41:01
	 * 方法介绍:   收件箱删除 ，变为3
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	public void updateInbox(Integer emailId);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午10:41:35
	 * 方法介绍:   收件箱删除 ，变为4
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	public void updateInboxs(Integer emailId);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午10:42:44
	 * 方法介绍:   废纸篓删除，变为1 
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	public void updateRecycle(Integer emailId);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午10:43:38
	 * 方法介绍:   废纸篓删除
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	public void deleteRecycle(Integer emailId);


	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/15 16:24
	 * 方法介绍:   其他邮件查询
	 * 参数说明:
	 * @return
	 */
	List<EmailBodyModel> selectBoxEmail(Map<String, Object> maps);

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/15 16:25
	 * 方法介绍:   查询其他邮件文件夹中是否存在邮件
	 * 参数说明:
	 * @return
	 */
	List<EmailBodyModel> selectIsBoxEmail(Map<String, Object> maps);

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/19 17:43
	 * 方法介绍:   收件箱未读查询
	 * 参数说明:   
	 * @return     
	 */
	List<EmailBodyModel> selectInboxIsRead(Map<String,Object> maps);

}