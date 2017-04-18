package com.xoa.model.file;

public class File_Sort {
	/**
	 * 自增唯一
	 */
	 int sort_id;
	 /**
	  * 上级目录ID
	  */
	 int sort_parent;
	 /**
	  * 目录排序号
	  */
	 String sort_no;
	 /**
	  * 目录名称
	  */
	 String sort_name; 
	 /**
	  * 类型(1-公共文件柜,2-个人文件柜)
	  */
	 String sort_type;
	 /**
	  * 有访问权限的用户ID串
	  */
	 String user_id;
	 /**
	  * 有新建权限的用户ID串
	  */
	 String new_user;
	 /**
	  * 有编辑权限的用户ID串
	  */
	 String manager_user;
	 /**
	  * 有删除权限的用户ID串
	  */
	 String del_user;
	 /**
	  * 有下载/打印权限的用户ID串
	  */
	 String down_user;
	 /**
	  * 个人共享
	  */
	 String shar_user;
	 /**
	  * 所有者ID串
	  */
	 String owner;
	 /**
	  *有签阅权限的用户ID串
	  */
	 String sign_user;
	 /**
	  * 评论/打分权限
	  */
	 String review;
	 
	 
	public int getSort_id() {
		return sort_id;
	}
	public int getSort_parent() {
		return sort_parent;
	}
	public String getSort_no() {
		return sort_no;
	}
	public String getSort_name() {
		return sort_name;
	}
	public String getSort_type() {
		return sort_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getNew_user() {
		return new_user;
	}
	public String getManager_user() {
		return manager_user;
	}
	public String getDel_user() {
		return del_user;
	}
	public String getDown_user() {
		return down_user;
	}
	public String getShar_user() {
		return shar_user;
	}
	public String getOwner() {
		return owner;
	}
	public String getSign_user() {
		return sign_user;
	}
	public String getReview() {
		return review;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	public void setSort_parent(int sort_parent) {
		this.sort_parent = sort_parent;
	}
	public void setSort_no(String sort_no) {
		this.sort_no = sort_no;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	public void setSort_type(String sort_type) {
		this.sort_type = sort_type;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setNew_user(String new_user) {
		this.new_user = new_user;
	}
	public void setManager_user(String manager_user) {
		this.manager_user = manager_user;
	}
	public void setDel_user(String del_user) {
		this.del_user = del_user;
	}
	public void setDown_user(String down_user) {
		this.down_user = down_user;
	}
	public void setShar_user(String shar_user) {
		this.shar_user = shar_user;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setSign_user(String sign_user) {
		this.sign_user = sign_user;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
