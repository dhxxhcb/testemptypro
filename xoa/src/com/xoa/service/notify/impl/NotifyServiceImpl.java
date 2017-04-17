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

@Service
public class NotifyServiceImpl implements  NotifyService{
	
	@Resource
	private NotifyMapper notifyMapper;
	
	@Resource
	private DepartmentMapper departmentMapper;
	/**
	 * 查询公告
	 * @param maps map条件参数
	 * @param page 当前页
	 * @param pageSize 每页显示条数
	 * @param useFlag 是否开启分页插件
	 * @return
	 * @throws Exception
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
	 * 未读公告
	 * @return
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
     * 修改 公告
     * @return
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
     * 保存公告
     * @return
     */
	@Override
	@Transactional
	public void addNotify(Notify notify) {

			notifyMapper.addNotify(notify);
			
	}

	/**
	 * 已读、未读公告查询
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
        
	

	@Override
	public List<Notify> getNotifyById(String id) {
		return notifyMapper.getNotifyById(id);
	}
	
	@Override
	public Notify getNotifyById(Integer id) {
		return notifyMapper.getNotifyById(id);
	}
	/**
	 * 
	 *根据ID 删除公告
	 * @return
	 */
	@Override
	public void delete(Integer notifyId) {
		
		notifyMapper.deleteById(notifyId);
	}
	
	/**
	 * 公告管理信息查询
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
