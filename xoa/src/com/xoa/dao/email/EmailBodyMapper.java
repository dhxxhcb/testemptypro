package com.xoa.dao.email;

import java.util.List;
import java.util.Map;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.util.page.PageParams;

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
	 * 方法介绍:   根据ID删除一条
	 * 参数说明:   @param bodyId
	 * @return     void
	 */
	public void deleteByPrimaryKey(Integer bodyId);

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
	 * @return     List<EmailBodyModel>
	 */
	List<EmailBodyModel> listqueryEmailBody(Map<String, Object> maps);

}