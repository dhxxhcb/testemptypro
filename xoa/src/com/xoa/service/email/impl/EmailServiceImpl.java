package com.xoa.service.email.impl;

import com.xoa.dao.email.EmailBodyMapper;
import com.xoa.dao.email.EmailMapper;
import com.xoa.model.email.EmailBodyModel;
import com.xoa.model.email.EmailModel;
import com.xoa.service.email.EmailService;
import com.xoa.service.users.UsersService;
import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:54:20
 * 类介绍  :   邮件业务层实现类
 * 构造参数:   
 *
 */
@Service
public class EmailServiceImpl implements EmailService {
	private Logger logger = Logger.getLogger(EmailServiceImpl.class);

	@Resource
	private EmailBodyMapper emailBodyMapper;

	@Resource
	private EmailMapper emailMapper;
	
	@Resource
	private UsersService usersService;

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:47:08
	 * 方法介绍:   创建邮件并发送
	 * 参数说明:   @param emailBody  邮件内容实体类
	 * 参数说明:   @param email 邮件状态实体类
	 * @return     void
	 */
	@Override
	public void sendEmail(EmailBodyModel emailBody, EmailModel email) {
		emailBodyMapper.save(emailBody);
		String toID = emailBody.getToId2().trim()
				+ emailBody.getCopyToId().trim()
				+ emailBody.getSecretToId().trim();
		if (toID != null && toID != "") {
			String[] toID2 = toID.split(",");
			for (int i = 0; i < toID2.length; i++) {
				email.setToId(toID2[i]);
				email.setSign("0");
				email.setReceipt("0");
				email.setReadFlag("0");
				email.setIsR("");
				email.setIsF("");
				email.setEmailId(email.getEmailId());
				email.setDeleteFlag("0");
				email.setBoxId(0);
				email.setBodyId(emailBody.getBodyId());
				emailMapper.save(email);
			}
		}
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:47:26
	 * 方法介绍:   草稿箱
	 * 参数说明:   @param emailBody 邮件内容实体类
	 * @return     void
	 */
	@Override
	public void saveEmail(EmailBodyModel emailBody) {
		emailBodyMapper.save(emailBody);
	}

	
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:48:04
	 * 方法介绍:   查询邮件
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * 参数说明:   @throws Exception
	 * @return     List<EmailBodyModel>
	 */
	@Override
	public ToJson<EmailBodyModel> selectEmail(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		logger.info("查询邮件!");
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		logger.info("邮件查询emailService赋值！");
		List<EmailBodyModel> list =new ArrayList<EmailBodyModel>();
		List<EmailBodyModel> listEmai = emailBodyMapper.selectObjcet(maps);
		for(EmailBodyModel emailBody:listEmai){
			emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
			emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyName()));
			emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToName()));
			list.add(emailBody);
		}
		tojson.setObj(list);
		tojson.setTotleNum(pageParams.getTotal());
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:48:31
	 * 方法介绍:   根据ID删除草稿箱邮件
	 * 参数说明:   @param bodyId 邮件Id
	 * @return     void
	 */
	@Override
	public void deleteByID(Integer bodyId) {
		emailBodyMapper.deleteDrafts(bodyId);
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:51:42
	 * 方法介绍:   草稿箱查询
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * 参数说明:   @throws Exception
	 * @return     List<EmailBodyModel>
	 */
	@Override
	public ToJson<EmailBodyModel> listDrafts(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<EmailBodyModel> list =new ArrayList<EmailBodyModel>();
		List<EmailBodyModel> listEmai = emailBodyMapper.listDrafts(maps);
		for(EmailBodyModel emailBody:listEmai){
			emailBody.setToName(usersService.getUserNameById(emailBody.getToId2()));
			emailBody.setCopyName(usersService.getUserNameById(emailBody.getCopyName()));
			emailBody.setSecretToName(usersService.getUserNameById(emailBody.getSecretToName()));
			list.add(emailBody);
		}
		tojson.setObj(list);
		tojson.setTotleNum(pageParams.getTotal());
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:52:01
	 * 方法介绍:   已发送查询
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * 参数说明:   @throws Exception
	 * @return     List<EmailBodyModel>
	 */
	@Override
	public ToJson<EmailBodyModel> listSendEmail(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception {
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		tojson.setObj(emailBodyMapper.listSendEmail(maps));
		tojson.setTotleNum(pageParams.getTotal());
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:52:30
	 * 方法介绍:   废纸篓查询
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * 参数说明:   @throws Exception
	 * @return     List<EmailBodyModel>
	 */
	@Override
	public ToJson<EmailBodyModel> listWastePaperbasket(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception {
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		tojson.setObj(emailBodyMapper.listWastePaperbasket(maps));
		tojson.setTotleNum(pageParams.getTotal());
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:52:59
	 * 方法介绍:   已发送查询
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * 参数说明:   @throws Exception
	 * @return     List<EmailBodyModel>
	 */
	@Override
	public ToJson<EmailBodyModel> selectEmailBody(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception {
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		tojson.setObj(emailBodyMapper.listqueryEmailBody(maps));
		tojson.setTotleNum(pageParams.getTotal());
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:48:55
	 * 方法介绍:   根据ID查询一条邮件
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * @return     EmailBodyModel
	 */
	@Override
	public EmailBodyModel queryById(Map<String,Object> maps,Integer page, Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		return emailBodyMapper.queryById(maps);
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:49:30
	 * 方法介绍:   收件箱查询
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * 参数说明:   @throws Exception
	 * @return     List<EmailBodyModel>
	 */
	@Override
	public ToJson<EmailBodyModel> selectInbox(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		tojson.setObj(emailBodyMapper.selectInbox(maps));
		tojson.setTotleNum(pageParams.getTotal());
		return tojson;
	}

	
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:53:42
	 * 方法介绍:   未读
	 * 参数说明:   @param maps 相关条件参数传值
	 * 参数说明:   @param page 当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return 结果集合
	 * 参数说明:   @throws Exception
	 * @return     List<EmailBodyModel>
	 */
	@Override
	public ToJson<EmailBodyModel> selectIsRead(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		ToJson<EmailBodyModel> tojson = new ToJson<EmailBodyModel>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		tojson.setObj(emailBodyMapper.selectIsRead(maps));
		tojson.setTotleNum(pageParams.getTotal());
		return tojson;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午10:47:44
	 * 方法介绍:    未读转为已读
	 * 参数说明:   @param email  收件箱参数
	 * @return     void
	 */
	@Override
	public void updateIsRead(EmailModel email) {
		emailMapper.updateIsRead(email);
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午11:16:38
	 * 方法介绍:   发件箱删除
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	@Override
	public String deleteOutEmail(Integer emailId,String flag) {
		String returnRes = "0";
		try {
			if(flag.trim().equals("0")||flag.trim().equals("")){
				emailBodyMapper.updateOutbox(emailId);
			}else if(flag.trim().equals("3")){
				emailBodyMapper.updateOutboxs(emailId);
			}else{
				emailBodyMapper.deleteOutbox(emailId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			returnRes = "1";
		}
		return returnRes;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午11:16:38
	 * 方法介绍:   发件箱删除邮件
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	@Override
	public String deleteInEmail(Integer emailId, String flag) {
		String returnRes = "0";
		try {
			if(flag.trim().equals("0")||flag.trim().equals("")){
				emailBodyMapper.updateInbox(emailId);
			}else{
				emailBodyMapper.updateInboxs(emailId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			returnRes = "1";
		}
		return returnRes;
	}

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-21 上午11:16:38
	 * 方法介绍:   废纸篓删除邮件
	 * 参数说明:   @param emailBodyModel
	 * @return     void
	 */
	@Override
	public String deleteRecycleEmail(Integer emailId, String flag) {
		String returnRes = "0";
		try {
			if(flag.trim().equals("3")){
				emailBodyMapper.updateRecycle(emailId);
			}else{
				emailBodyMapper.deleteRecycle(emailId);
			}
		} catch (Exception e) {
			returnRes = "1";
		}
		return returnRes;
	}
	
}
