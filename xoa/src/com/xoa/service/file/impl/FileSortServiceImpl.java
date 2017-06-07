package com.xoa.service.file.impl;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.xoa.dao.auth.AuthMapper;
import com.xoa.model.file.FileAuthBaseModel;
import com.xoa.model.file.FileAuthWrapper;
import com.xoa.service.file.FileSortResetAuth;
import com.xoa.util.common.StringUtils;
import com.xoa.util.common.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoa.dao.file.FileSortMapper;
import com.xoa.model.file.FileSortModel;
import com.xoa.service.file.FileSortService;
import com.xoa.util.ToJson;

/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午9:24:55
 * 类介绍  :    文件柜service实现类
 * 构造参数:   默认
 *
 */
@Service
public class FileSortServiceImpl  implements FileSortService{
	@Resource
	FileSortMapper file_SortMapper;
	@Autowired
	AuthMapper authMapper;
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:30:51
	 * 方法介绍:   动态查询File_Sort返回json数据
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return   ToJson<FileSortModel>
	 */
	public ToJson<FileSortModel> getFileSortJson(FileSortModel file) {
		ToJson<FileSortModel> toJson = new ToJson<FileSortModel>(0,"显示结果");
		List<FileSortModel> list=file_SortMapper.getFileSort(file);
		toJson.setObj(list);
		return toJson;
	
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:07
	 * 方法介绍:   动态查询 File_Sort返回<FileSortModel> list数组
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getFileSortList(FileSortModel file) {
		return file_SortMapper.getFileSort(file);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:20
	 * 方法介绍:   动态查询  File_Sort
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     ToJson<FileSortModel>
	 */
	@Override
	public ToJson<FileSortModel> getFileSortBySortId(FileSortModel file) {
		ToJson<FileSortModel> toJson = new ToJson<FileSortModel>(0,"显示结果");
		List<FileSortModel> list=file_SortMapper.getFileSort(file);
		toJson.setObj(list);
		return toJson;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:31:34
	 * 方法介绍:   添加目录树文件夹
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     int
	 */
	@Override
	public int saveFileSort(FileSortModel file) {
		return file_SortMapper.saveFileSort(file);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:15
	 * 方法介绍:   修改目录树文件夹信息
	 * 参数说明:   @param file
	 * 参数说明:   @return
	 * @return     int
	 */
	@Override
	public int updateFileSort(FileSortModel file) {
		return file_SortMapper.updateFileSort(file);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:26
	 * 方法介绍:   删除目录树文件夹信息
	 * 参数说明:   @param fileParent
	 * 参数说明:   @return
	 * @return     int
	 */
	@Override
	public int deleteBySortId(Map<String, Object> fileParent) {
		return  file_SortMapper.deleteBySortId(fileParent);
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:37
	 * 方法介绍:   根据某个父节点信息获取目录树子文件夹信息
	 * 参数说明:   @param tempNo
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getSortChrildren(int tempNo) {
		return file_SortMapper.getSortChrildren(tempNo);
	}
	
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:56:50
	 * 方法介绍:   获取目录树父文件夹信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return   List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getRootTree(int sortid) {
		return file_SortMapper.getRootTree(sortid);
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-19 上午9:57:07
	 * 方法介绍:   获取所有子文件夹信息
	 * 参数说明:   @param sortid
	 * 参数说明:   @return
	 * @return     List<FileSortModel>
	 */
	@Override
	public List<FileSortModel> getChildTree(List<String> sortidList) {
		return file_SortMapper.getChildTree(sortidList);
	}
	/**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-20 上午9:39:32
     * 方法介绍:   添加子文件夹
     * 参数说明:   @param file
     * 参数说明:   @return
     * @return   int 添加子文件夹影响行
     */
	@Override
	public int saveFileSortChr(FileSortModel file) {
		return file_SortMapper.saveFileSortChr(file);
	}

	@Override
	public BaseWrapper setFileSortAuth(Map<String, Object> mmp) {
		BaseWrapper wrapper =new BaseWrapper();
		wrapper.setStatus(true);
		wrapper.setFlag(false);
		wrapper.setMsg("操作失败");
		if(mmp==null){

			return wrapper;
		}
		Integer sortId=(Integer) mmp.get("sortId");
        if(sortId==null){
        	return wrapper;
		}
		FileSortResetAuth resetAuth =new FileSortResetAuth();
	    Map<String,String> param=resetAuth.reset("userId", (Map<String, String>)mmp.get("userId"))
				.reset("manageUser",(Map<String, String>)mmp.get("manageUser"))
				.reset("delUser",(Map<String, String>)mmp.get("delUser"))
				.reset("downUser",(Map<String, String>)mmp.get("downUser"))
				.reset("shareUser",(Map<String, String>)mmp.get("shareUser"))
				.reset("owner",(Map<String, String>)mmp.get("owner"))
				.reset("signUser",(Map<String, String>)mmp.get("signUser"))
				.reset("review",(Map<String, String>)mmp.get("review"))
				.reset("description",(Map<String, String>)mmp.get("description"))
				.reset("newUser",(Map<String, String>)mmp.get("newUser"))
				.getParam();
		param.put("sortId",sortId.toString());
		int res =file_SortMapper.updateSortAuth(param);
		if(res>0){
			wrapper.setStatus(true);
			wrapper.setFlag(true);
			wrapper.setMsg("操作成功");
		}else{
			wrapper.setStatus(true);
			wrapper.setFlag(false);
			wrapper.setMsg("操作失败");
		}
		return wrapper;
	}

	@Override
	public FileAuthWrapper getAuthBySortId(Integer sortId) {
		FileAuthWrapper wrapper =new FileAuthWrapper();

		//获取左侧树结构
		List<FileSortModel> list =file_SortMapper.queryFileSortAndChildBySortId(sortId);
		wrapper.setFileSorts(list);
		//当前页权限
		FileSortModel model =file_SortMapper.getNowFileSortAuth(sortId);
		FileAuthBaseModel auth =new FileAuthBaseModel();
		List<String> useds=new ArrayList<String>();
		if(model!=null){
			String[] userIds =FileSortResetAuth.getAuthBase(model.getUserId());
			String[] newUsers =FileSortResetAuth.getAuthBase(model.getNewUser());
			String[]  managerUsers =FileSortResetAuth.getAuthBase(model.getManagerUser());
			String[] delUsers =FileSortResetAuth.getAuthBase(model.getDelUser());
			String[]  downUsers=FileSortResetAuth.getAuthBase(model.getDownUser());
			String[] owners =FileSortResetAuth.getAuthBase(model.getOwner());
			String[] sharUsers =FileSortResetAuth.getAuthBase(model.getSharUser());
			String[] signUsers =FileSortResetAuth.getAuthBase(model.getSignUser());
			String[] review =FileSortResetAuth.getAuthBase(model.getReview());
			//查询对应的字段
			auth.setUserId(getName(userIds));
			auth.setReview(getName(review));
			auth.setDelUser(getName(delUsers));
			auth.setNewUser(getName(newUsers));
			auth.setManageUser(getName(managerUsers));
			auth.setDownUser(getName(downUsers));
			auth.setOwner(getName(owners));
			auth.setShareUser(getName(sharUsers));
			auth.setSignUser(getName(signUsers));
			wrapper.setData(auth);
			wrapper.setNowFileSortName(model.getSortName());
			//那些有数据需要标记
			if(userIds!=null){
				useds.add("visit");
			}
			if(newUsers!=null){
				useds.add("add");
			}
			if(managerUsers!=null){
				useds.add("edit");
			}if(delUsers!=null){
				useds.add("delete");
			}
			if(downUsers!=null){
				useds.add("download");
			}
			if(owners!=null){
				useds.add("all");
			}
			if(review!=null){
				useds.add("comment");
			}
			if(signUsers!=null){
				useds.add("sign");
			}
            wrapper.setUsed(useds);
			wrapper.setFlag(true);
		}else{
			wrapper.setFlag(false);
			wrapper.setMsg("还未设置权限");
		}


		return wrapper;
	}
	public FileAuthBaseModel.FileAuthChildModel getName(String[] ids){
		FileAuthBaseModel.FileAuthChildModel child=new FileAuthBaseModel().new FileAuthChildModel();
		FileAuthBaseModel.FileAuthGrandChildModel grandChild=new FileAuthBaseModel().new FileAuthGrandChildModel();
//		String[] ret =new String[3];
		if(ids==null){
			child.setDept("");
			grandChild.setDeptStr("");
			child.setUser("");
			grandChild.setUserStr("");
			child.setRole("");
			grandChild.setRoleStr("");
			child.setData(grandChild);
			return child;
		}
		String dept=ids[0];
		String role=ids[1];
		String user =ids[2];
		if(!StringUtils.checkNull(dept)){
			String ret="";
			if("ALL_DEPT".equals(dept)){
				ret="全部部门";
			}else{
                    List<String> depts = authMapper.getDeptName(dept);
                    StringBuffer sb =new StringBuffer();
                    for(String dep:depts){
						sb.append(dep);
						sb.append(",");
					}
				  ret=sb.toString();
			}
			child.setDept(dept);
			grandChild.setDeptStr(ret);
		}else{
			child.setDept("");
			grandChild.setDeptStr("");
		}
		if(!StringUtils.checkNull(role)){
			List<String> roles = authMapper.getRoleName(role);
			StringBuffer sb =new StringBuffer();
			for(String rol:roles){
				sb.append(rol);
				sb.append(",");
			}
			child.setRole(role);
			grandChild.setRoleStr(sb.toString());
		}
		else{
			child.setRole("");
			grandChild.setRoleStr("");
		}
		if(!StringUtils.checkNull(user)){
			List<String> users = authMapper.getUserName(user);
			StringBuffer sb =new StringBuffer();
			for(String us:users){
				sb.append(us);
				sb.append(",");
			}
			child.setUser(user);
			grandChild.setUserStr(sb.toString());
		}
		else{
			child.setUser("");
			grandChild.setUserStr("");
		}
		child.setData(grandChild);
		return child;
	}

}
