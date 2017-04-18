package com.xoa.service.email.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xoa.dao.email.EmailBodyMapper;
import com.xoa.dao.email.EmailMapper;
import com.xoa.model.email.Email;
import com.xoa.model.email.EmailBody;
import com.xoa.service.email.EmailUtilService;
import com.xoa.util.page.PageParams;

/**
 * 
 * @ClassName (类名):  EmailUtilServiceImpl
 * @Description(简述): 邮箱操作业务类
 * @author(作者):      zlx
 * @date(日期):        2017-4-17 下午5:44:41
 *
 */
@Service
public class EmailUtilServiceImpl implements EmailUtilService {
	private Logger logger = Logger.getLogger(EmailUtilServiceImpl.class);

	@Resource
	private EmailBodyMapper emailBodyMapper;

	@Resource
	private EmailMapper emailMapper;

	/**
	 * 创建邮件并发送
	 * <p>Title: sendEmail</p>
	 * <p>Description: </p>
	 * @param emailBody 件箱、收件箱内容信息对象 邮件内容实体类
	 * @param email 收件人实体类 邮件状态实体类
	 * @author(作者):  zlx
	 */
	@Override
	public void sendEmail(EmailBody emailBody, Email email) {
		emailBodyMapper.save(emailBody);
		String toID = emailBody.getToId2().trim()
				+ emailBody.getCopyToId().trim()
				+ emailBody.getSecretToId().trim();
		if (toID != null && toID != "") {
			String[] toID2 = toID.split(",");
			for (int i = 0; i < toID2.length; i++) {
				email.setToId(toID2[i]);
				email.setSign(email.getSign());
				email.setReceipt(email.getReceipt());
				email.setReadFlag(email.getReadFlag());
				email.setIsR(email.getIsR());
				email.setIsF(email.getIsF());
				email.setEmailId(email.getEmailId());
				email.setEmailBody(emailBody);
				email.setDeleteFlag(email.getDeleteFlag());
				email.setBoxId(email.getBoxId());
				email.setBodyId(emailBody.getBodyId());
				emailMapper.save(email);
			}
		}
	}

	/** 
	 *  查询邮件
	 * <p>Title: selectEmail</p>
	 * <p>Description: </p>
	 * @param maps 相关条件参数传值
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return 结果集合
	 * @throws Exception
	 * @author(作者):  zlx
	 */
	@Override
	public List<EmailBody> selectEmail(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		logger.info("查询邮件!");
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		logger.info("邮件查询emailService赋值！");
		return emailBodyMapper.selectObjcet(maps);
	}

	/**
	 * 根据id删除
	 * <p>Title: deleteByPrimaryKey</p>
	 * <p>Description: </p>
	 * @param bodyId 邮件Id
	 * @author(作者):  zlx
	 */
	@Override
	public void deleteByPrimaryKey(Integer bodyId) {
		emailBodyMapper.deleteByPrimaryKey(bodyId);
	}

	/**
	 * 草稿箱查询
	 * <p>Title: listDrafts</p>
	 * <p>Description: </p>
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @author(作者):  zy
	 * @see com.xoa.service.email.EmailUtilService#listDrafts(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<EmailBody> listDrafts(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<EmailBody> list = emailBodyMapper.listDrafts(maps);
		return list;
	}

	/**
	 * 发件箱查询
	 * <p>Title: listSendEmail</p>
	 * <p>Description: </p>
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 * @author(作者):  zy
	 * @see com.xoa.service.email.EmailUtilService#listSendEmail(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<EmailBody> listSendEmail(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<EmailBody> list = emailBodyMapper.listSendEmail(maps);
		System.out.println(list.size());
		return list;
	}

	/**
	 *  废纸篓查询
	 * <p>Title: listWastePaperbasket</p>
	 * <p>Description: </p>
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize  每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 * @author(作者):  zy
	 * @see com.xoa.service.email.EmailUtilService#listWastePaperbasket(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<EmailBody> listWastePaperbasket(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<EmailBody> list = emailBodyMapper.listWastePaperbasket(maps);
		System.out.println(list.size());
		return list;
	}

	/**
	 * 条件分页查询
	 * <p>Title: selectEmailBody</p>
	 * <p>Description: </p>
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 * @author(作者):  zlx
	 * @see com.xoa.service.email.EmailUtilService#selectEmailBody(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<EmailBody> selectEmailBody(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<EmailBody> list = emailBodyMapper.listqueryEmailBody(maps);
		return list;
	}

	/**
	 *   根据ID查询一条邮件
	 * <p>Title: queryById</p>
	 * <p>Description: </p>
	 * @param maps map参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否启用插件
	 * @return
	 * @author(作者):  zlx
	 * @see com.xoa.service.email.EmailUtilService#queryById(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public EmailBody queryById(Map<String,Object> maps,Integer page, Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		return emailBodyMapper.queryById(maps);
	}

	/**
	 *  收件箱查询
	 * <p>Title: selectInbox</p>
	 * <p>Description: </p>
	 * @param maps map参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启插件
	 * @return
	 * @throws Exception
	 * @author(作者):  zy
	 * @see com.xoa.service.email.EmailUtilService#selectInbox(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<EmailBody> selectInbox(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<EmailBody> list = emailBodyMapper.selectInbox(maps);
		return list;
	}

	
	
	/**
	 *  未读
	 * <p>Title: selectIsRead</p>
	 * <p>Description: </p>
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 
	 * @return
	 * @throws Exception
	 * @author(作者):  zy
	 * @see com.xoa.service.email.EmailUtilService#selectIsRead(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<EmailBody> selectIsRead(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<EmailBody> list = emailBodyMapper.selectIsRead(maps);
		return list;
	}

	
	
}
