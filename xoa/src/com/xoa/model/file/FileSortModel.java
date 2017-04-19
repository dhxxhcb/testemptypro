package com.xoa.model.file;

/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-18 下午7:39:21
 * 类介绍  :   文件柜目录表 
 * 构造参数:   
 *
 */
public class FileSortModel {
	/**
	 * 自增唯一
	 */
	 int sortId;
	 /**
	  * 上级目录ID
	  */
	 int sortParent;
	 /**
	  * 目录排序号
	  */
	 String sortNo;
	 /**
	  * 目录名称
	  */
	 String sortName; 
	 /**
	  * 类型(1-公共文件柜,2-个人文件柜)
	  */
	 String sortType;
	 /**
	  * 有访问权限的用户ID串
	  */
	 String userId;
	 /**
	  * 有新建权限的用户ID串
	  */
	 String newUser;
	 /**
	  * 有编辑权限的用户ID串
	  */
	 String managerUser;
	 /**
	  * 有删除权限的用户ID串
	  */
	 String delUser;
	 /**
	  * 有下载/打印权限的用户ID串
	  */
	 String downUser;
	 /**
	  * 个人共享
	  */
	 String sharUser;
	 /**
	  * 所有者ID串
	  */
	 String owner;
	 /**
	  *有签阅权限的用户ID串
	  */
	 String signUser;
	 /**
	  * 评论/打分权限
	  */
	 String review;
	 /**
	  * 
	  * @Title: getReview
	  * @Description: 评论/打分权限 get
	  * @author(作者):      ys
	  * @param: @return   
	  * @return: String   
	  * @throws
	  */
	public String getReview() {
		return review;
	}
	/**
	  * 
	  * @Title: getReview
	  * @Description: 评论/打分权限 set
	  * @author(作者):      ys
	  * @param: @return   
	  * @return: String   
	  * @throws
	  */
	public void setReview(String review) {
		this.review = review;
	}
	/**
	 * 
	 * @Title: getSortId
	 * @Description: 自增唯一 get
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public int getSortId() {
		return sortId;
	}
	/**
	 * 
	 * @Title: setSortId
	 * @Description: 自增唯一 set
	 * @author(作者):      ys
	 * @param: @param sortId   
	 * @return: void   
	 * @throws
	 */
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	/**
	 * 
	 * @Title: getSortParent
	 * @Description: 上级目录ID get
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: int   
	 * @throws
	 */
	public int getSortParent() {
		return sortParent;
	}
	/**
	 * 
	 * @Title: setSortParent
	 * @Description: 上级目录ID set
	 * @author(作者):      ys
	 * @param: @param sortParent   
	 * @return: void   
	 * @throws
	 */
	public void setSortParent(int sortParent) {
		this.sortParent = sortParent;
	}
	/**
	 * 
	 * @Title: getSortNo
	 * @Description: 目录排序号 get
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getSortNo() {
		return sortNo;
	}
	/**
	 * 
	 * @Title: setSortNo
	 * @Description: 目录排序号 set
	 * @author(作者):      ys
	 * @param: @param sortNo   
	 * @return: void   
	 * @throws
	 */
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	/**
	 * 
	 * @Title: getSortName
	 * @Description: 目录名称 get
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getSortName() {
		return sortName;
	}
	/**
	 * 
	 * @Title: setSortName
	 * @Description: 目录名称 set
	 * @author(作者):      ys
	 * @param: @param sortName   
	 * @return: void   
	 * @throws
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	/**
	 * 
	 * @Title: getSortType
	 * @Description: 类型(1-公共文件柜,2-个人文件柜)
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getSortType() {
		return sortType;
	}
	/**
	 * 
	 * @Title: setSortType
	 * @Description: 类型(1-公共文件柜,2-个人文件柜)
	 * @author(作者):      ys
	 * @param: @param sortType   
	 * @return: void   
	 * @throws
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	/**
	 * 
	 * @Title: getUserId
	 * @Description: 有访问权限的用户ID串
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 
	 * @Title: setUserId
	 * @Description: 有访问权限的用户ID串
	 * @author(作者):      ys
	 * @param: @param userId   
	 * @return: void   
	 * @throws
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 
	 * @Title: getNewUser
	 * @Description: 有新建权限的用户ID串
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getNewUser() {
		return newUser;
	}
	/**
	 * 
	 * @Title: setNewUser
	 * @Description: 有新建权限的用户ID串
	 * @author(作者):      ys
	 * @param: @param newUser   
	 * @return: void   
	 * @throws
	 */
	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}
	/**
	 * 
	 * @Title: getManagerUser
	 * @Description: 有编辑权限的用户ID串
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getManagerUser() {
		return managerUser;
	}
	/**
	 * 
	 * @Title: setManagerUser
	 * @Description: 有编辑权限的用户ID串
	 * @author(作者):      ys
	 * @param: @param managerUser   
	 * @return: void   
	 * @throws
	 */
	public void setManagerUser(String managerUser) {
		this.managerUser = managerUser;
	}
	/**
	 * 
	 * @Title: getDelUser
	 * @Description: 有删除权限的用户ID串
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getDelUser() {
		return delUser;
	}
	/**
	 * 
	 * @Title: setDelUser
	 * @Description: 有删除权限的用户ID串
	 * @author(作者):      ys
	 * @param: @param delUser   
	 * @return: void   
	 * @throws
	 */
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	/**
	 * 
	 * @Title: getDownUser
	 * @Description: 有下载/打印权限的用户ID串
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getDownUser() {
		return downUser;
	}
	/**
	 * 
	 * @Title: setDownUser
	 * @Description: 有下载/打印权限的用户ID串
	 * @author(作者):      ys
	 * @param: @param downUser   
	 * @return: void   
	 * @throws
	 */
	public void setDownUser(String downUser) {
		this.downUser = downUser;
	}
	/**
	 * 
	 * @Title: getSharUser
	 * @Description: 个人共享
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getSharUser() {
		return sharUser;
	}
	/**
	 * 
	 * @Title: setSharUser
	 * @Description: 个人共享
	 * @author(作者):      ys
	 * @param: @param sharUser   
	 * @return: void   
	 * @throws
	 */
	public void setSharUser(String sharUser) {
		this.sharUser = sharUser;
	}
	/**
	 * 
	 * @Title: getOwner
	 * @Description: 所有者ID串
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 
	 * @Title: setOwner
	 * @Description: 所有者ID串
	 * @author(作者):      ys
	 * @param: @param owner   
	 * @return: void   
	 * @throws
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 
	 * @Title: getSignUser
	 * @Description: 有签阅权限的用户ID串
	 * @author(作者):      ys
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public String getSignUser() {
		return signUser;
	}
	/**
	 * 
	 * @Title: setSignUser
	 * @Description: 有签阅权限的用户ID串
	 * @author(作者):      ys
	 * @param: @param signUser   
	 * @return: void   
	 * @throws
	 */
	public void setSignUser(String signUser) {
		this.signUser = signUser;
	}
}
