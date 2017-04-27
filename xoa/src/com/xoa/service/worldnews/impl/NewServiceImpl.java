package com.xoa.service.worldnews.impl;

import com.xoa.dao.common.SysCodeMapper;
import com.xoa.dao.department.DepartmentMapper;
import com.xoa.dao.users.UsersMapper;
import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.common.SysCode;
import com.xoa.model.department.Department;
import com.xoa.model.users.Users;
import com.xoa.model.worldnews.News;
import com.xoa.service.department.DepartmentService;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.DateFormat;
import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;

import org.springframework.stereotype.Service;

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
	private DepartmentMapper departmentMapper;//部门DAO
	
	@Resource
	private UsersMapper UsersMapper; 
	
	@Resource
	private DepartmentService  departmentService;
	
	@Resource
	private SysCodeMapper sysCodeMapper;
	
	
	
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
			Integer pageSize, boolean useFlag, String name) throws Exception {
		ToJson<News>  newJson=new ToJson<News>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.unreadNews(maps);
		List<News> list1 = new ArrayList<News>();
		for (News news : list) {
			news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
			news.setProviderName(news.getUsers().getUserName());
			news.setTypeName(news.getCodes().getCodeName());
			if (news.getReaders().indexOf(name) == -1) {
				list1.add(news);
			}
		}
		newJson.setObj(list1);
		newJson.setTotleNum(pageParams.getTotal());
		return newJson;
	}
	
	@Override
	public ToJson<News> readNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		ToJson<News>  newJson=new ToJson<News>();
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.readNews(maps);
		List<News> list1 = new ArrayList<News>();
		for (News news : list) {
			news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
			news.setProviderName(news.getUsers().getUserName());
			news.setTypeName(news.getCodes().getCodeName());
			if (news.getReaders().indexOf(name) != -1) {
				list1.add(news);
			}
		}
		newJson.setObj(list1);
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
			Integer pageSize, boolean useFlag, String name) throws Exception {
		String[] strArray = null;
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		News news = newsMapper.detailedNews(maps);
		news.setNewsDateTime(DateFormat.getStrDate(news.getNewsTime()));
		news.setProviderName(news.getUsers().getUserName());
		news.setTypeName(news.getCodes().getCodeName());
		StringBuffer s=new StringBuffer();
		if (news.getToId().equals("ALL_DEPT")) {
			List<Department> list1 = departmentMapper.getDatagrid();
			for (Department department : list1) {
				if (department.getDeptName()!=null) {
					s.append(department.getDeptName());
					s.append(",");
					news.setDepName(s.toString());
				}
				
			}
		} else {
			strArray = news.getToId().split(",");
			for (int i = 0; i < strArray.length; i++) {
				List<String> depname = departmentService.getDeptNameById(Integer.parseInt(strArray[i]));
				for (String string : depname) {
					if (string!=null) {
						s.append(string);
						s.append(",");
						news.setDepName(s.toString());
					}
					
				}
				
			}
		}
		if (news.getReaders().indexOf(name) == -1) {
			StringBuffer str2 = new StringBuffer(news.getReaders());
			str2.append(",");
			str2.append(name);
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
			Integer pageSize, boolean useFlag) throws Exception {
		ToJson<News>  newJson=new ToJson<News>();
		
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.selectNewsManage(maps);
		for (News news : list) {
			news.setProviderName(news.getUsers().getUserName());
			news.setTypeName(news.getCodes().getCodeName());
			
		}
		newJson.setObj(list);
		newJson.setTotleNum(pageParams.getTotal());
		return newJson;
	}

	@Override
	public void updatePublish(News news) {
		// TODO Auto-generated method stub
		
	}

}
