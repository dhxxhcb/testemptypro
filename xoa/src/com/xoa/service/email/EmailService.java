package com.xoa.service.email;

import java.util.List;
import java.util.Map;

import com.xoa.model.email.EmailModel;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.util.dataSource.DynDatasource;

public interface EmailService {

	/**
	 * 创建邮件并发送
	 * 
	 * @param emailBody
	 *            邮件内容实体类
	 * @param email
	 *            邮件状态实体类
	 */
	@DynDatasource
	public void sendEmail(EmailBodyModel emailBody, EmailModel email);
	
	//草稿箱
	@DynDatasource
	public void saveEmail(EmailBodyModel emailBody);

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
	public List<EmailBodyModel> selectEmail(Map<String, Object> maps, Integer page,
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
	public EmailBodyModel queryById(Map<String,Object> maps,Integer page, Integer pageSize, boolean useFlag);

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
	List<EmailBodyModel> selectInbox(Map<String, Object> maps, Integer page,
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
	List<EmailBodyModel> listDrafts(Map<String, Object> maps, Integer page,
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
	List<EmailBodyModel> listSendEmail(Map<String, Object> maps, Integer page,
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
	List<EmailBodyModel> listWastePaperbasket(Map<String, Object> maps,
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
	public List<EmailBodyModel> selectEmailBody(Map<String, Object> maps,
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
	List<EmailBodyModel> selectIsRead(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception;

}