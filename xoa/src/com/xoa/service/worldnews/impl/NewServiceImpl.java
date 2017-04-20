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
	
	
	
	@Override
	public List<News> selectNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.selectNews(maps);
		for (News news : list) {
				Users user=UsersMapper.findUserByName(news.getProvider());
				news.setUserName(user.getUserName());
				SysCode code=sysCodeMapper.getSysCode(news.getTypeId());
				news.setTypeName(code.getCodeName());
				
			if (news.getReaders().indexOf(name) != -1) {
				news.setRead(1);
			} else {
				news.setRead(0);
			}
		}
		return list;
	}

	@Override
	public List<News> unreadNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.unreadNews(maps);
		List<News> list1 = new ArrayList<News>();
		for (News news : list) {
			Users user=UsersMapper.findUserByName(news.getProvider());
			news.setUserName(user.getUserName());
		/*	String code=sysCodeMapper.getSysCode(news.getTypeId());
			news.setTypeName(code);*/
			if (news.getReaders().indexOf(name) == -1) {
				list1.add(news);
			}
		}
		return list1;
	}

	@Override
	public void sendNews(News news) {
		newsMapper.save(news);

	}

	@Override
	public void updateNews(News news) {
		newsMapper.update(news);
	}

	@Override
	public News queryById(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		News news = newsMapper.detailedNews(maps);
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

	}
	@Override
	public void deleteByPrimaryKey(Integer newsId) {
		newsMapper.deleteNews(newsId);
	}
	 
	@Override
	public List<News> selectNewsManage(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		String[] strArray = null;
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<News> list = newsMapper.selectNewsManage(maps);
		for (News news : list) {
			Users user=UsersMapper.findUserByName(news.getProvider());
			news.setUserName(user.getUserName());
		/*	String code=sysCodeMapper.getSysCode(news.getTypeId());
			news.setTypeName(code);*/
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
		}
		return list;
	}

}
