package com.xoa.service.notify.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoa.dao.department.DepartmentMapper;
import com.xoa.dao.notify.NotifyMapper;
import com.xoa.model.department.Department;
import com.xoa.model.notify.Notify;
import com.xoa.model.users.Users;
import com.xoa.model.worldnews.News;


import com.xoa.service.notify.NotifyService;
import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;
/**
 * 
 * @ClassName (类名):  NotifyServiceImpl
 * @Description(简述): 实现类
 * @author(作者):      张丽军 
 * @date(日期):        2017-4-18 上午11:44:32
 *
 */
@Service
public class NotifyServiceImpl implements  NotifyService{
  
	@Resource
	private NotifyMapper notifyMapper;
	
	@Resource
	private DepartmentMapper departmentMapper;
	/**
	 * 
	 * <p>Title: selectNotify</p>
	 * <p>Description: 查询公告信息</p>
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @param name
	 * @return
	 * @throws Exception
	 * @author(作者):  张丽军
	 * @date(日期):        2017-4-18 上午11:44:32
	 * @see com.xoa.service.notify.NotifyService#selectNotify(java.util.Map, java.lang.Integer, java.lang.Integer, boolean, java.lang.String)
	 */
	@Override
	public List<Notify> selectNotify(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name)throws Exception {
		PageParams pageParams = new PageParams();  
        pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        maps.put("page", pageParams);  
        List<Notify> list = notifyMapper.selectNotify(maps);
            for (Notify notify1 : list) {
                 notify1.setName(notify1.getUsers().getUserName());
                 notify1.setUsers(null);
                 if (notify1.getReaders().indexOf(name)!=-1) {
        	        notify1.setReaders("1");
			        }else {
				     notify1.setReaders("0");
			}
		}
        System.out.println("公告查询条数："+list.size());
		return list;
	}


	/**
	 * 
	 * <p>Title: unreadNotify</p>
	 * <p>Description: 未读信息</p>
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @param name
	 * @return
	 * @throws Exception
	 * @author(作者): 张丽军
	 * @date(日期):        2017-4-18 上午11:44:32
	 * @see com.xoa.service.notify.NotifyService#unreadNotify(java.util.Map, java.lang.Integer, java.lang.Integer, boolean, java.lang.String)
	 */

    @Override
    public List<Notify> unreadNotify(Map<String, Object> maps, Integer page,
		Integer pageSize, boolean useFlag, String name) throws Exception {
	PageParams pageParams = new PageParams();  
    pageParams.setUseFlag(useFlag);  
    pageParams.setPage(page);  
    pageParams.setPageSize(pageSize);  
    maps.put("page", pageParams);  
    List<Notify> list = notifyMapper.unreadNotify(maps);
    List<Notify> list1 =new ArrayList<Notify>();
    	for (Notify notify : list) {
			if (notify.getReaders().indexOf(name)==-1) {
				list1.add(notify);
			}
	}
    return list1;
}
    
    
   /**
    * 
    * <p>Title: updateNotify</p>
    * <p>Description:更新公告信息 </p>
    * @param notify
    * @author(作者):  张丽军
    * @date(日期):        2017-4-18 上午11:44:32
    * @see com.xoa.service.notify.NotifyService#updateNotify(com.xoa.model.notify.Notify)
    */
    @Transactional
    public void updateNotify(Notify notify) {
	     if(notify.getNotifyId()!=-1){
	    	notifyMapper.updateNotify(notify);
	     }else{
		    notifyMapper.addNotify(notify);
	     }
    }

   /**
    * 
    * <p>Title: addNotify</p>
    * <p>Description: 新增公告信息</p>
    * @param notify
    * @author(作者):  张丽军
    * @date(日期):        2017-4-18 上午11:44:32
    * @see com.xoa.service.notify.NotifyService#addNotify(com.xoa.model.notify.Notify)
    */
	@Override
	@Transactional
	public void addNotify(Notify notify) {

			notifyMapper.addNotify(notify);
			
	}

	/**
	 * 
	 * <p>Title: queryById</p>
	 * <p>Description: 查询公告详情</p>
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @param name
	 * @return
	 * @throws Exception
	 * @author(作者):  张丽军
	 * @date(日期):        2017-4-18 上午11:44:32
	 * @see com.xoa.service.notify.NotifyService#queryById(java.util.Map, java.lang.Integer, java.lang.Integer, boolean, java.lang.String)
	 */
	@Override
	public Notify queryById(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception {
		PageParams pageParams = new PageParams();  
        pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        maps.put("page", pageParams);
        Notify notify=notifyMapper.detailedNotify(maps);
        Notify notifyy=new Notify();
        if(notify.getReaders().indexOf(name)!=-1){
        	StringBuffer str2= new StringBuffer(notify.getReaders());
        	String str1=str2.append(name).toString();
        	notify.setNotifyId(notify.getNotifyId());
        	notifyy.setReaders(str1);
        	notify.setClickCount(notify.getClickCount()+1);
        	notifyMapper.updateNotify(notify);
		}else {
			notify.setNotifyId(notify.getNotifyId());
			notify.setClickCount(notify.getClickCount()+1);
			notifyMapper.updateclickCount(notify);
		}
	
	   return notify;
	  
        	
        }
        
	
    /**
     * 
     * <p>Title: getNotifyById</p>
     * <p>Description:根据ID查询一条数据 </p>
     * @param id
     * @return
     * @author(作者):  张丽军
     * @date(日期):        2017-4-18 上午11:44:32
     * @see com.xoa.service.notify.NotifyService#getNotifyById(java.lang.String)
     */
	@Override
	public List<Notify> getNotifyById(String id) {
		return notifyMapper.getNotifyById(id);
	}
	
	/**
	 * 
	 * <p>Title: getNotifyById</p>
	 * <p>Description: 根据ID查询一条数据</p>
	 * @param id
	 * @return
	 * @author(作者):  张丽军
	 * @date(日期):        2017-4-18 上午11:44:32
	 * @see com.xoa.service.notify.NotifyService#getNotifyById(java.lang.Integer)
	 */
	@Override
	public Notify getNotifyById(Integer id) {
		return notifyMapper.getNotifyById(id);
	}
	/**
	 * 
	 * <p>Title: delete</p>
	 * <p>Description: 根据ID删除一条信息</p>
	 * @param notifyId
	 * @author(作者):  张丽军
	 * @date(日期):        2017-4-18 上午11:44:32
	 * @see com.xoa.service.notify.NotifyService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer notifyId) {
		
		notifyMapper.deleteById(notifyId);
	}
	
	/**
	 * 
	 * <p>Title: selectNotifyManage</p>
	 * <p>Description: 查询公告管理信息</p>
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @return
	 * @throws Exception
	 * @author(作者):  张丽军
	 * @date(日期):        2017-4-18 上午11:44:32
	 * @see com.xoa.service.notify.NotifyService#selectNotifyManage(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<Notify> selectNotifyManage(Map<String, Object> maps,
			Integer page, Integer pageSize, boolean useFlag) throws Exception {
		String[] strArray = null;
		PageParams pageParams = new PageParams();  
        pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        maps.put("page", pageParams);  
        List<Notify> list = notifyMapper.selectNotifyManage(maps);
       for (Notify notify : list) {
			if (notify.getToId().equals("ALL_DEPT")) {
				 List<Department> list1=departmentMapper.getDatagrid();
				 for (Department department : list1) {
					 notify.setName(department.getDeptName());
				}
			}else  {
				strArray=notify.getToId().split(",");
				for (int i = 0; i < strArray.length; i++) {
			 String name=departmentMapper.getDeptNameById(Integer.parseInt(strArray[i]));
			 notify.setName(name);
				}
			}
		}
		return list;
	}


}
