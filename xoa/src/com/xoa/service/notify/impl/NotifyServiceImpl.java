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




import com.xoa.service.notify.NotifyService;
import com.xoa.util.ToJson;
import com.xoa.util.page.PageParams;

/**
 * 
 * 创建作者:   张丽军
 * 创建日期:   2017-4-18 下午6:22:58
 * 类介绍  :   公告实现类
 * 构造参数:   无
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
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-18 下午11:59:41
	 * 方法介绍:   查询公告信息
	 * 参数说明:   @param maps  map条件参数
	 * 参数说明:   @param page  当前页
	 * 参数说明:   @param pageSize  每页显示条数
	 * 参数说明:   @param useFlag   是否开启分页插件
	 * 参数说明:   @param name
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<Notify>
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
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-19 上午12:03:54
	 * 方法介绍:   未读信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @param name
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<Notify>
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
     * 创建作者:   张丽军
     * 创建日期:   2017-4-19 上午11:49:31
     * 方法介绍:   更新公告信息
     * 参数说明:   @param notify
     * @return     void
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
     * 创建作者:   张丽军
     * 创建日期:   2017-4-19 上午11:51:20
     * 方法介绍:   新增公告信息
     * 参数说明:   @param notify
     * @return     void
     */
	@Override
	@Transactional
	public void addNotify(Notify notify) {

			notifyMapper.addNotify(notify);
			
	}

	   /**
	    * 
	    * 创建作者:   张丽军
	    * 创建日期:   2017-4-19 上午11:51:50
	    * 方法介绍:   根据ID查找公告详情
	    * 参数说明:   @param maps
	    * 参数说明:   @param page
	    * 参数说明:   @param pageSize
	    * 参数说明:   @param useFlag
	    * 参数说明:   @param name
	    * 参数说明:   @return
	    * 参数说明:   @throws Exception
	    * @return     Notify
	    */
	@Override
	public Notify queryById(Map<String, Object> maps,Integer page,Integer pageSize,boolean useFlag,String name) throws Exception {
		PageParams pageParams = new PageParams();  
        pageParams.setUseFlag(useFlag);  
        pageParams.setPage(page);  
        pageParams.setPageSize(pageSize);  
        maps.put("page", pageParams);
        Notify notify=notifyMapper.detailedNotify(maps);
      if(notify.getReaders().indexOf(name)==-1){
        	StringBuffer str2= new StringBuffer(notify.getReaders());
        	str2.append(",");
        	str2.append(name);
        	String str1=str2.toString();
        	notify.setNotifyId(notify.getNotifyId());
        	notify.setReaders(str1);
        	notifyMapper.updateReaders(notify);
		}
	
	   return notify;
	  
        	
        }
        
	 /**
	   * 
	   * 创建作者:   张丽军
	   * 创建日期:   2017-4-19 上午11:48:39
	   * 方法介绍:   根据ID获取公告信息
	   * 参数说明:   @param id
	   * 参数说明:   @return
	   * @return     List<Notify>
	   */
	@Override
	public List<Notify> getNotifyById(String id) {
		return notifyMapper.getNotifyById(id);
	}
	
	 /**
	   * 
	   * 创建作者:   张丽军
	   * 创建日期:   2017-4-19 上午11:48:39
	   * 方法介绍:   根据ID获取公告信息
	   * 参数说明:   @param id
	   * 参数说明:   @return
	   * @return     List<Notify>
	   */
	@Override
	public Notify getNotifyById(Integer id) {
		return notifyMapper.getNotifyById(id);
	}
	   
	   /**
	    * 
	    * 创建作者:   张丽军
	    * 创建日期:   2017-4-19 上午11:51:31
	    * 方法介绍:   删除公告信息
	    * 参数说明:   @param notifyId
	    * @return     void
	    */
	@Override
	public void delete(Integer notifyId) {
		
		notifyMapper.deleteById(notifyId);
	}
	
	/**
	 * 
	 * 创建作者:   张丽军
	 * 创建日期:   2017-4-19 上午12:03:43
	 * 方法介绍:   查询公告管理信息
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * 参数说明:   @throws Exception
	 * @return     List<Notify>
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
