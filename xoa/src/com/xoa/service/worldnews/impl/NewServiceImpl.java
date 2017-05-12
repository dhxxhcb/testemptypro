package com.xoa.service.worldnews.impl;

import com.xoa.dao.common.SysCodeMapper;
import com.xoa.dao.department.DepartmentMapper;
import com.xoa.dao.users.UserPrivMapper;
import com.xoa.dao.users.UsersMapper;
import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.common.SysCode;
import com.xoa.model.department.Department;
import com.xoa.model.users.UserPriv;
import com.xoa.model.users.Users;
import com.xoa.model.worldnews.News;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.users.UsersPrivService;
import com.xoa.service.users.UsersService;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.DateFormat;
import com.xoa.util.GetAttachmentListUtil;
import com.xoa.util.ToJson;
import com.xoa.util.common.StringUtils;
import com.xoa.util.page.PageParams;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-19 下午3:40:36
 * 类介绍  :    新闻ServiceImpl(逻辑层)
 * 构造参数:   
 *
 */
@Service
public class NewServiceImpl implements NewService {

	@Resource
	private NewsMapper newsMapper;//新闻DAO

	@Resource
	private DepartmentService  departmentService;
	@Resource
	private DepartmentMapper DepartmentMapper;
	@Resource
	private UsersService  usersService;
	@Resource
	private UsersPrivService  usersPrivService;
	@Resource
	private UserPrivMapper  userPrivMapper;
	@Resource
	private UsersMapper  usersMapper;
	
	
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:35:41
	 * 方法介绍:   查询新闻列表
	 * 参数说明:   @param maps map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @param name 名字
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<News> 返回新闻列表List
	 */
	@Override
	public ToJson<News>  selectNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		ToJson<News>  newJson=new ToJson<News>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.selectNews(maps);
		for (News news : list) {
			news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
				news.setProviderName(news.getUsers().getUserName());
				news.setTypeName(news.getCodes().getCodeName());
				
			if (news.getReaders().indexOf(name) != -1) {
				news.setRead(1);
			} else {
				news.setRead(0);
			}
		}
		newJson.setObj(list);
		newJson.setTotleNum(pageParams.getTotal());
		return newJson;
	}
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:35:41
	 * 方法介绍:   查询未读新闻列表
	 * 参数说明:   @param maps map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @param name 名字
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<News> 返回新闻列表List
	 */
	@Override
	public ToJson<News> unreadNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name,String sqlType) throws Exception {
		     String[] strArray = null;
	        String[] strArray1 = null;
	        String[] strArray2 = null;
		ToJson<News>  newJson=new ToJson<News>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		Users users=usersMapper.findUserByName(name);
		List<News> list = newsMapper.unreadNews(maps);
		List<News> list1 = new ArrayList<News>();
		List<News> list2 = new ArrayList<News>();
		for (News news : list) {
			news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
			news.setProviderName(news.getUsers().getUserName());
			news.setTypeName(news.getCodes().getCodeName());
			if (news.getAttachmentName()!=null&&news.getAttachmentId()!=null) {
				news.setAttachment(GetAttachmentListUtil.returnAttachment(news.getAttachmentName(), news.getAttachmentId(), sqlType,GetAttachmentListUtil.MODULE_NEWS));
			}
			 String depId=news.getToId();
				if ("ALL_DEPT".equals(depId)) {
					list1.add(news);
				}else if(depId!=null&&!"".equals(depId)){
					strArray=depId.split(",");
				   for (int j = 0; j < strArray.length; j++) {
					if (users.getDeptId().toString().equals(strArray[j])) {
						  list1.add(news);
					}
				}
				}
				  String userId=news.getUserId();
			     if (userId!=null&&!userId.equals("")){
			    	if (users.getUid()!=null&&!"".equals(users.getUid())) {
			    	 strArray1=userId.split(",");
			    	  for (int j = 0; j < strArray1.length; j++) {
							if (users.getUid().toString().equals(strArray1[j])) {
								  list1.add(news);
							}
						}
			    	 }
			     }
			    	String roleId=news.getPrivId();
			      if (roleId!=null&&!roleId.equals("")) {
			    	  if (users.getUserPriv()!=null&&!"".equals(users.getUserPriv())) {
			    		  strArray2=depId.split(",");
			    	  for (int j = 0; j < strArray2.length; j++) {
							if (users.getUserPriv().toString().equals(strArray2[j])) {
								  list1.add(news);
							}
						}
				}}
			
		}
		for (News newss : list1) {
			if (newss.getReaders().indexOf(name) == -1) {
				list2.add(newss);
			}
		}
		newJson.setObj(list2);
		newJson.setTotleNum(pageParams.getTotal());
		return newJson;
	}
	
	@Override
	public ToJson<News> readNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name,String sqlType) throws Exception {
		   String[] strArray = null;
	        String[] strArray1 = null;
	        String[] strArray2 = null;
		ToJson<News>  newJson=new ToJson<News>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		Users users=usersMapper.findUserByName(name);
		List<News> list = newsMapper.unreadNews(maps);
		List<News> list1 = new ArrayList<News>();
		List<News> list2 = new ArrayList<News>();
		for (News news : list) {
			news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
			news.setProviderName(news.getUsers().getUserName());
			news.setTypeName(news.getCodes().getCodeName());
			if (news.getAttachmentName()!=null&&news.getAttachmentId()!=null) {
				news.setAttachment(GetAttachmentListUtil.returnAttachment(news.getAttachmentName(), news.getAttachmentId(), sqlType,GetAttachmentListUtil.MODULE_NEWS));
			}
			 String depId=news.getToId();
				if ("ALL_DEPT".equals(depId)) {
					list1.add(news);
				}else if(depId!=null&&!"".equals(depId)){
					strArray=depId.split(",");
				   for (int j = 0; j < strArray.length; j++) {
					if (users.getDeptId().toString().equals(strArray[j])) {
						  list1.add(news);
					}
				}
				} String userId=news.getUserId();
			     if (userId!=null&&!userId.equals("")){
			    	if (users.getUid()!=null&&!"".equals(users.getUid())) {
			    	 strArray1=userId.split(",");
			    	  for (int j = 0; j < strArray1.length; j++) {
							if (users.getUid().toString().equals(strArray1[j])) {
								  list1.add(news);
							}
						}
			    	 }
			     }
			    	String roleId=news.getPrivId();
			      if (roleId!=null&&!roleId.equals("")) {
			    	  if (users.getUserPriv()!=null&&!"".equals(users.getUserPriv())) {
			    		  strArray2=roleId.split(",");
			    	  for (int j = 0; j < strArray2.length; j++) {
							if (users.getUserPriv().toString().equals(strArray2[j])) {
								  list1.add(news);
							}
						}
				}}
			
		}
		for (News newss : list1) {
			if (newss.getReaders().indexOf(name) != -1) {
				list2.add(newss);
			}
		}
		newJson.setObj(list2);
		newJson.setTotleNum(pageParams.getTotal());
		return newJson;
	}
	/**
	 * 
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:39:24
	 * 方法介绍:   添加新闻
	 * 参数说明:   @param news
	 * @return     void
	 */
	@Override
	public void sendNews(News news) {
		newsMapper.save(news);

	}
	 /**
	  * 
	  * 创建作者:   王曰岐
	  * 创建日期:   2017-4-19 下午3:39:48
	  * 方法介绍:   修改新闻
	  * 参数说明:   @param news
	  * @return     void
	  */
	@Override
	public void updateNews(News news) {
		newsMapper.update(news);
	}
	 /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-19 下午3:40:16
     * 方法介绍:   根据ID查询一条
     * 参数说明:   @param newsId
     * @return     void
     */
	@Override
	public News queryById(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name,String sqlType) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		    String[] strArray = null;
	        String[] strArray1 = null;
	        String[] strArray2 = null;
		News news = newsMapper.detailedNews(maps);
		news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
		news.setProviderName(news.getUsers().getUserName());
		news.setTypeName(news.getCodes().getCodeName());
		if (news.getAttachmentName()!=null&&news.getAttachmentId()!=null) {
			news.setAttachment(GetAttachmentListUtil.returnAttachment(news.getAttachmentName(), news.getAttachmentId(), sqlType,GetAttachmentListUtil.MODULE_NEWS));
		}
		StringBuffer s=new StringBuffer();
		StringBuffer s1=new StringBuffer();
		StringBuffer s2=new StringBuffer();
		
		  String depId=news.getToId();
	      
	      if ("ALL_DEPT".equals(depId)) {
	    	  news.setDeprange("全体部门");
			}else if(depId!=null&&!"".equals(depId)) {
				strArray=depId.split(",");
				for (int i = 0; i < strArray.length; i++) {
					String name1=departmentService.getDpNameById(Integer.parseInt(strArray[i]));
				if (name1!=null) {
					s.append(name1);
	        		s.append(",");
	        		news.setDeprange(s.toString());
				}
					
				}
				
			}
	      String userId=news.getUserId();
	      if (userId!=null&&!userId.equals("")) {
	    	  strArray1=userId.split(",");
	    	  for (int i = 0; i < strArray1.length; i++) {
	    		  System.out.println(Integer.parseInt(strArray1[i]));
	    		  String name2=usersService.findUsersByuid(Integer.parseInt(strArray1[i]));
					 if (name2!=null) {
						 s1.append(name2);
						 s1.append(",");
						 news.setUserrange(s1.toString());
					}
				}
		  }
	      String roleId=news.getPrivId();
	      if (roleId!=null&&!roleId.equals("")) {
	    	  strArray2=roleId.split(",");
	    	  for (int i = 0; i < strArray2.length; i++) {
	    		  String name3=usersPrivService.getPrivNameById(Integer.parseInt(strArray2[i]));
	    		    if (name3!=null) {
	    			  s2.append(name3);
						 s2.append(",");
						 news.setRolerange(s2.toString());
				}
				}
	  	   
		  }
		if (news.getReaders().indexOf(name) == -1||StringUtils.checkNull(news.getReaders())) {
			StringBuffer str2 = new StringBuffer(news.getReaders());
			str2.append(name);
			str2.append(",");
			String str1 =str2.toString();
			news.setNewsId(news.getNewsId());
			news.setReaders(str1);
			news.setClickCount(news.getClickCount() + 1);
			newsMapper.updateNews(news);
		} else {
			news.setNewsId(news.getNewsId());
			news.setClickCount(news.getClickCount() + 1);
			newsMapper.updateclickCount(news);
		}

		return news;

	} /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-19 下午3:40:16
     * 方法介绍:   根据ID删除一条
     * 参数说明:   @param newsId
     * @return     void
     */
	@Override
	public void deleteByPrimaryKey(Integer newsId) {
		newsMapper.deleteNews(newsId);
	}
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-4-19 下午3:39:06
	 * 方法介绍:   查询新闻管理
	 * 参数说明:   @param maps map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize 每页显示条数
	 * 参数说明:   @param useFlag 是否开启分页插件
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<News>
	 */
	@Override
	public ToJson<News> selectNewsManage(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag,String name,String sqlType ) throws Exception {
		ToJson<News>  newJson=new ToJson<News>();
		    String[] strArray = null;
	        String[] strArray1 = null;
	        String[] strArray2 = null;
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.selectNews(maps);
		List<News> list1=new  ArrayList<News>();
		Users users=usersMapper.findUserByName(name);
		if (users!=null) {
		for (News news : list) {
			news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
				news.setProviderName(news.getUsers().getUserName());
				news.setTypeName(news.getCodes().getCodeName());
				if (news.getAttachmentName()!=null&&news.getAttachmentId()!=null) {
					news.setAttachment(GetAttachmentListUtil.returnAttachment(news.getAttachmentName(), news.getAttachmentId(), sqlType,GetAttachmentListUtil.MODULE_NEWS));
				}
				 String depId=news.getToId();
				if ("ALL_DEPT".equals(depId)) {
					list1.add(news);
				}else if(depId!=null&&!"".equals(depId)){
					strArray=depId.split(",");
				   for (int j = 0; j < strArray.length; j++) {
					if (users.getDeptId().toString().equals(strArray[j])) {
						  list1.add(news);
					}
				}
				}
				 String userId=news.getUserId();
			     if (userId!=null&&!userId.equals("")){
			    	if (users.getUid()!=null&&!"".equals(users.getUid())) {
			    	 strArray1=userId.split(",");
			    	  for (int j = 0; j < strArray1.length; j++) {
							if (users.getUid().toString().equals(strArray1[j])) {
								  list1.add(news);
							}
						}
			    	 }
			     }
			    	String roleId=news.getPrivId();
			      if (roleId!=null&&!roleId.equals("")) {
			    	  if (users.getUserPriv()!=null&&!"".equals(users.getUserPriv())) {
			    		  strArray2=roleId.split(",");
			    	  for (int j = 0; j < strArray2.length; j++) {
							if (users.getUserPriv().toString().equals(strArray2[j])) {
								  list1.add(news);
							}
						}
				}}
			if (news.getReaders().indexOf(name) != -1) {
				news.setRead(1);
			} else {
				news.setRead(0);
			}
		}
		}
		
		
		  newJson.setObj(list1);
		newJson.setTotleNum(pageParams.getTotal());
		return newJson;
	}

	@Override
	public void updatePublish(News news) {
		// TODO Auto-generated method stub
		
	}

}
