package com.xoa.service.worldnews.impl;

import com.xoa.dao.department.DepartmentMapper;
import com.xoa.dao.worldnews.NewsMapper;
import com.xoa.model.department.Department;
import com.xoa.model.worldnews.NewsModel;
import com.xoa.service.worldnews.NewService;
import com.xoa.util.dataSource.DynDatasource;
import com.xoa.util.page.PageParams;
import com.xoa.util.ToJson;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @ClassName (类名):  NewServiceImpl
 * @Description(简述): TODO
 * @author(作者):      wyq
 * @date(日期):        2017-4-17 下午5:58:46
 *
 */
@Service
public class NewServiceImpl implements NewService {

	@Resource
	private NewsMapper newsMapper;//新闻DAO

	@Resource
	private DepartmentMapper departmentMapper;//部门DAO

	/**
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
	@Override
	public List<NewsModel> selectNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<NewsModel> list = newsMapper.selectNews(maps);
		for (NewsModel news : list) {
			if (news.getReaders().indexOf(name) != -1) {
				news.setRead(1);
			} else {
				news.setRead(0);
			}
		}
		return list;
	}

	/**
	 * 
	 * <p>
	 * Title: unreadNews
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @param name
	 * @return
	 * @throws Exception
	 * @author(作者): wyq
	 * @see com.xoa.service.worldnews.NewService#unreadNews(java.util.Map,
	 *      java.lang.Integer, java.lang.Integer, boolean, java.lang.String)
	 */
	@Override
	public List<NewsModel> unreadNews(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<NewsModel> list = newsMapper.unreadNews(maps);
		List<NewsModel> list1 = new ArrayList<NewsModel>();
		for (NewsModel news : list) {
			if (news.getReaders().indexOf(name) == -1) {
				list1.add(news);
			}
		}
		return list1;
	}

	/**
	 * 
	 * <p>
	 * Title: sendNews
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param news
	 * @author(作者): wyq
	 * @see com.xoa.service.worldnews.NewService#sendNews(com.xoa.model.worldnews.NewsModel)
	 */
	@Override
	public void sendNews(NewsModel news) {
		newsMapper.save(news);

	}

	/**
	 * 
	 * <p>
	 * Title: updateNews
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param news
	 * @author(作者): wyq
	 * @see com.xoa.service.worldnews.NewService#updateNews(com.xoa.model.worldnews.NewsModel)
	 */
	@Override
	public void updateNews(NewsModel news) {
		// TODO Auto-generated method stub
		newsMapper.update(news);
	}

	/**
	 * 
	 * <p>
	 * Title: queryById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @param name
	 * @return
	 * @throws Exception
	 * @author(作者): wyq
	 * @see com.xoa.service.worldnews.NewService#queryById(java.util.Map,
	 *      java.lang.Integer, java.lang.Integer, boolean, java.lang.String)
	 */
	@Override
	public NewsModel queryById(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag, String name) throws Exception {
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		NewsModel news = newsMapper.detailedNews(maps);
		NewsModel newa = new NewsModel();
		if (news.getReaders().indexOf(name) != -1) {
			StringBuffer str2 = new StringBuffer(news.getReaders());
			String str1 = str2.append(name).toString();
			news.setNewsId(news.getNewsId());
			newa.setReaders(str1);
			news.setClickCount(news.getClickCount() + 1);
			newsMapper.updateNews(news);
		} else {
			news.setNewsId(news.getNewsId());
			news.setClickCount(news.getClickCount() + 1);
			newsMapper.updateclickCount(news);
		}

		return news;

	}

	/**
	 * 
	 * <p>
	 * Title: deleteByPrimaryKey
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param newsId
	 * @author(作者): wyq
	 * @see com.xoa.service.worldnews.NewService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public void deleteByPrimaryKey(Integer newsId) {
		// TODO Auto-generated method stub
		newsMapper.deleteNews(newsId);
	}

	/**
	 * 
	 * <p>
	 * Title: selectNewsManage
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @return
	 * @throws Exception
	 * @author(作者): wyq
	 * @see com.xoa.service.worldnews.NewService#selectNewsManage(java.util.Map,
	 *      java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<NewsModel> selectNewsManage(Map<String, Object> maps, Integer page,
			Integer pageSize, boolean useFlag) throws Exception {
		String[] strArray = null;
		PageParams pageParams = new PageParams();
		pageParams.setUseFlag(useFlag);
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		maps.put("page", pageParams);
		List<NewsModel> list = newsMapper.selectNewsManage(maps);
		for (NewsModel news : list) {
			if (news.getToId().equals("ALL_DEPT")) {
				List<Department> list1 = departmentMapper.getDatagrid();
				for (Department department : list1) {
					news.setName(department.getDeptName());
				}
			} else {
				strArray = news.getToId().split(",");
				for (int i = 0; i < strArray.length; i++) {
					String name = departmentMapper.getDeptNameById(Integer
							.parseInt(strArray[i]));
					news.setName(name);
				}
			}
		}
		return list;
	}

}
