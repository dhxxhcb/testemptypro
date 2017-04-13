package com.xoa.service.email;

import java.util.List;
import java.util.Map;

import com.xoa.model.email.Email;
import com.xoa.model.email.EmailBody;
import com.xoa.util.dataSource.DynDatasource;

public interface EmailUtilService {

	/**
	 * 创建邮件并发送
	 * 
	 * @param emailBody
	 *            邮件内容实体类
	 * @param email
	 *            邮件状态实体类
	 */
	@DynDatasource
	public void sendEmail(EmailBody emailBody, Email email);

	/**
	 * 邮件查询
	 * 
	 * @param maps
	 *            相关条件参数传值
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return 结果集合
	 * @throws Exception
	 */
	@DynDatasource
	public List<EmailBody> selectEmail(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception;

	/**
	 * 根据ID删除一条
	 * 
	 * @param bodyId
	 *            邮件Id
	 */
	@DynDatasource
	public void deleteByPrimaryKey(Integer bodyId);

	/**
	 * 根据ID查询一条邮件
	 * 
	 * @param bodyId
	 *            邮件Id
	 */
	@DynDatasource
	public EmailBody queryById(Integer bodyId);

	/**
	 * 收件箱查询
	 * 
	 * @param maps
	 *            map条件参数
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	List<EmailBody> selectInbox(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception;

	/**
	 * 草稿箱查询
	 * 
	 * @param maps
	 *            map条件参数
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	List<EmailBody> listDrafts(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception;

	/**
	 * 已发送查询
	 * 
	 * @param maps
	 *            map条件参数
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	List<EmailBody> listSendEmail(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception;

	/**
	 * 废纸篓查询
	 * 
	 * @param maps
	 *            map条件参数
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	List<EmailBody> listWastePaperbasket(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception;

	/**
	 * 已发送查询
	 * 
	 * @param maps
	 *            map条件参数
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	public List<EmailBody> selectEmailBody(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception;

	/**
	 * 未读
	 * 
	 * @param maps
	 *            map条件参数
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@DynDatasource
	List<EmailBody> selectIsRead(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception;

}
