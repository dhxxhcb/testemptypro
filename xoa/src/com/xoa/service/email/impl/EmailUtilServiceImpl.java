package com.xoa.service.email.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.email.EmailBodyMapper;
import com.xoa.dao.email.EmailMapper;
import com.xoa.model.email.Email;
import com.xoa.model.email.EmailBody;
import com.xoa.service.email.EmailUtilService;
import com.xoa.util.page.PageParams;
/**
 * 邮箱操作业务类
 * @author zlx
 * @version 1.0
 */
@Service
public class EmailUtilServiceImpl implements EmailUtilService{

	@Resource
	private EmailBodyMapper emailBodyMapper;
	
	@Resource
	private EmailMapper emailMapper;

	/**
	 * 创建邮件并发送
	 * @param emailBody   发件箱、收件箱内容信息对象
	 * 邮件内容实体类
	 * @param email   收件人实体类
	 * 邮件状态实体类
	 */
	@Override
	public void sendEmail(EmailBody emailBody,Email email) {
		emailBodyMapper.save(emailBody);
		String toID = emailBody.getToId2().trim()+emailBody.getCopyToId().trim()+emailBody.getSecretToId().trim();
		if(toID != null && toID != ""){
			String[]  toID2 = emailBody.getToId2().split(",");
			for(int i = 0 ; i < toID2.length; i++){
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
	   *根据ID删除一条
	   * @param bodyId
	   * 邮件Id
	   */
	@Override
	public void deleteByPrimaryKey(Integer bodyId) {
		emailBodyMapper.deleteByPrimaryKey(bodyId);
	}

	/**
	 * 草稿箱查询
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EmailBody> listDrafts(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) {
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
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EmailBody> listSendEmail(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception {
		PageParams pageParams = new PageParams();  
		pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        maps.put("page", pageParams);  
        List<EmailBody> list=emailBodyMapper.listSendEmail(maps);
        System.out.println(list.size());
		return list;
	}
	
	/**
	 * 废纸篓查询
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EmailBody> listWastePaperbasket(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag) throws Exception {
		PageParams pageParams = new PageParams();  
		pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        maps.put("page", pageParams);  
        List<EmailBody> list = emailBodyMapper.listWastePaperbasket(maps);
        System.out.println(list.size());
		return  list;
	}
	/**
	 * 条件分页查询
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EmailBody> selectEmailBody(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		 PageParams pageParams = new PageParams();  
		 pageParams.setUseFlag(useFlag);  
         pageParams.setPage(page);  
         pageParams.setPageSize(pageSize);  
         maps.put("page", pageParams);  
         List<EmailBody> list = emailBodyMapper.listqueryEmailBody(maps);
		return list;
	}
    /**@param bodyId
     * 根据ID查询一条邮件
     */
	@Override
	public EmailBody queryById(Integer bodyId) {
		return emailBodyMapper.queryById(bodyId);
	}

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


}
