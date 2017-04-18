package com.xoa.dao.email;

import java.util.List;
import java.util.Map;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.util.page.PageParams;

public interface EmailBodyMapper extends BaseMapper<EmailBodyModel>{

	public int updateByPrimaryKey(EmailBodyModel record);

	/**
	 * 根据ID删除一条
	 * @param maps
	 */
	public void deleteByPrimaryKey(Integer bodyId);

	/**
	 * 根据ID查询一条邮件
	 * @param maps
	 */
	public EmailBodyModel queryById(Map<String,Object> maps);

	/**
	 * 收件箱查询
	 * @param maps
	 */ 
	List<EmailBodyModel> selectInbox(Map<String, Object> maps);	
	/**
	 *草稿箱查询
	 * @param maps
	 */
	List<EmailBodyModel> listDrafts(Map<String, Object> maps);

	/**
	 * 已发送查询
	 *  @param maps
	 */
	List<EmailBodyModel> listSendEmail(Map<String, Object> maps);

	/**
	 * 未读
	 * @param maps
	 * @return
	 */
	List<EmailBodyModel> selectIsRead(Map<String,Object> maps);
	
	
	/**
	 * 废纸篓查询
	 * @param maps
	 */
	List<EmailBodyModel> listWastePaperbasket(Map<String, Object> maps);

	/**
	 * 多条件分页查询邮箱
	 * @param maps
	 */
	List<EmailBodyModel> listqueryEmailBody(Map<String, Object> maps);

}