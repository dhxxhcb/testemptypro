package com.xoa.dao.email;

import java.util.List;
import java.util.Map;

import com.xoa.model.email.EmailBody;
import com.xoa.util.page.PageParams;

public interface EmailBodyMapper {

	public int updateByPrimaryKey(EmailBody record);

	/**
	 * 保存邮件
	 * 
	 * @param emailBody
	 *            保存实体类参数
	 */
	public void insert(EmailBody emailBody);

	/**
	 * 根据ID删除一条
	 */
	public void deleteByPrimaryKey(Integer bodyId);

	/**
	 * 根据ID查询一条邮件
	 */
	public EmailBody queryById(Integer bodyId);

	/**
	 * 草稿箱查询
	 */
	List<EmailBody> listDrafts(Map<String, Object> maps);

	/**
	 * 已发送查询
	 */
	List<EmailBody> listSendEmail(Map<String, Object> maps);

	/**
	 * 废纸篓查询
	 */
	List<EmailBody> listWastePaperbasket(Map<String, Object> maps);

	/**
	 * 多条件分页查询邮箱
	 */
	List<EmailBody> listqueryEmailBody(Map<String, Object> maps);

}