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
	 
	 String descrtption;
	 
	 /**
	  * 配置一对多关联
	  */
	 
	 public String getDescrtption() {
		return descrtption;
	}
	public void setDescrtption(String descrtption) {
		this.descrtption = descrtption;
	}
	/**************************************/
	 /*
	  * 附加字段 用于判断文件与文件夹区别
	  */
	 String fileType; 
	 
	 
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType =fileType;
	}
	/**************************************/
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:50:54
	 * 方法介绍:   评论/打分权限 get
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getReview() {
		return review;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:51:08
	 * 方法介绍:   评论/打分权限 set
	 * 参数说明:   @param review
	 * @return     void
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:51:23
	 * 方法介绍:   自增唯一 get
	 * 参数说明:   @return
	 * @return     int
	 */
	public int getSortId() {
		return sortId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:51:38
	 * 方法介绍:   自增唯一 set
	 * 参数说明:   @param sortId
	 * @return     void
	 */
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:52:01
	 * 方法介绍:   上级目录ID get
	 * 参数说明:   @return
	 * @return     int
	 */
	public int getSortParent() {
		return sortParent;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:52:14
	 * 方法介绍:   上级目录ID set
	 * 参数说明:   @param sortParent
	 * @return     void
	 */
	public void setSortParent(int sortParent) {
		this.sortParent = sortParent;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:52:26
	 * 方法介绍:   目录排序号 get
	 * 参数说明:   @return
	 * @return   String
	 */
	public String getSortNo() {
		return sortNo;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:52:47
	 * 方法介绍:   目录排序号 set
	 * 参数说明:   @param sortNo
	 * @return     void
	 */
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:53:02
	 * 方法介绍:    目录名称 get
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSortName() {
		return sortName;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:53:17
	 * 方法介绍:   目录名称 set
	 * 参数说明:   @param sortName
	 * @return     void
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:53:30
	 * 方法介绍:   类型(1-公共文件柜,2-个人文件柜)
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSortType() {
		return sortType;
	}
	

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:53:45
	 * 方法介绍:   类型(1-公共文件柜,2-个人文件柜)
	 * 参数说明:   @param sortType
	 * @return     void
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:53:56
	 * 方法介绍:   有访问权限的用户ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:54:09
	 * 方法介绍:   有访问权限的用户ID串
	 * 参数说明:   @param userId
	 * @return     void
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:54:22
	 * 方法介绍:    有新建权限的用户ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getNewUser() {
		return newUser;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:54:34
	 * 方法介绍:    有新建权限的用户ID串
	 * 参数说明:   @param newUser
	 * @return     void
	 */
	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:54:45
	 * 方法介绍:   有编辑权限的用户ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getManagerUser() {
		return managerUser;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:54:55
	 * 方法介绍:   有编辑权限的用户ID串
	 * 参数说明:   @param managerUser
	 * @return     void
	 */
	public void setManagerUser(String managerUser) {
		this.managerUser = managerUser;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:55:06
	 * 方法介绍:   有删除权限的用户ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getDelUser() {
		return delUser;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:55:16
	 * 方法介绍:   有删除权限的用户ID串
	 * 参数说明:   @param delUser
	 * @return     void
	 */
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:55:32
	 * 方法介绍:   有下载/打印权限的用户ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getDownUser() {
		return downUser;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:55:42
	 * 方法介绍:   有下载/打印权限的用户ID串
	 * 参数说明:   @param downUser
	 * @return     void
	 */
	public void setDownUser(String downUser) {
		this.downUser = downUser;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:55:55
	 * 方法介绍:   个人共享
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSharUser() {
		return sharUser;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:56:06
	 * 方法介绍:   个人共享
	 * 参数说明:   @param sharUser
	 * @return     void
	 */
	public void setSharUser(String sharUser) {
		this.sharUser = sharUser;
	}
	
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:56:17
	 * 方法介绍:   所有者ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:56:29
	 * 方法介绍:   所有者ID串
	 * 参数说明:   @param owner
	 * @return     void
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:56:45
	 * 方法介绍:   有签阅权限的用户ID串
	 * 参数说明:   @return
	 * @return     String
	 */
	public String getSignUser() {
		return signUser;
	}
	/**
	 * 
	 * 创建作者:   杨 胜
	 * 创建日期:   2017-4-20 下午12:57:09
	 * 方法介绍:   有签阅权限的用户ID串
	 * 参数说明:   @param signUser
	 * @return     void
	 */
	public void setSignUser(String signUser) {
		this.signUser = signUser;
	}
}
