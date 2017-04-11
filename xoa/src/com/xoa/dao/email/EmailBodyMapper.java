package com.xoa.dao.email;

import java.util.List;
import java.util.Map;

import com.xoa.dao.base.BaseMapper;
import com.xoa.model.email.EmailBody;
import com.xoa.util.page.PageParams;

public interface EmailBodyMapper extends BaseMapper<EmailBody>{

	public int updateByPrimaryKey(EmailBody record);

//	/**
//	 * 保存邮件
//	 * 
//	 * @param emailBody
//	 *            保存实体类参数
//	 */
//	public void save(EmailBody emailBody);
//	
	
	

	/**
	 * 根据ID删除一条
	 * @param maps
	 */
	public void deleteByPrimaryKey(Integer bodyId);

	/**
	 * 根据ID查询一条邮件
	 * @param maps
	 */
	public EmailBody queryById(Integer bodyId);

	/**
	 * 收件箱查询
	 * @param maps
	 */ 
	List<EmailBody> selectInbox(Map<String, Object> maps);	
	/**
	 *草稿箱查询
	 * @param maps
	 */
	List<EmailBody> listDrafts(Map<String, Object> maps);

	/**
	 * 已发送查询
	 *  @param maps
	 */
	List<EmailBody> listSendEmail(Map<String, Object> maps);

	/**
	 * 废纸篓查询
	 * @param maps
	 */
	List<EmailBody> listWastePaperbasket(Map<String, Object> maps);

	/**
	 * 多条件分页查询邮箱
	 * @param maps
	 */
	List<EmailBody> listqueryEmailBody(Map<String, Object> maps);

}