package com.xoa.service.workflow.wrapper;

import java.util.List;

public class JobSelectorModel {
	Integer sort_id;// 主键Id
	Integer sort_parent;// 父级Id
	String sort_name;// 名称
	String have_child;

	public String getHave_child() {
		return have_child;
	}

	public void setHave_child(String have_child) {
		this.have_child = have_child;
	}

	JobSelectorModel child;

	 List<JobSelectorModel> childs;

	public List<JobSelectorModel> getChilds() {
		return childs;
	}

	public void setChilds(List<JobSelectorModel> childs) {
		this.childs = childs;
	}

	public JobSelectorModel getChild() {
		return child;
	}

	public void setChild(JobSelectorModel child) {
		this.child = child;
	}

	public Integer getSort_id() {
		return sort_id;
	}

	public void setSort_id(Integer sort_id) {
		this.sort_id = sort_id;
	}

	public Integer getSort_parent() {
		return sort_parent;
	}

	public void setSort_parent(Integer sort_parent) {
		this.sort_parent = sort_parent;
	}

	public String getSort_name() {
		return sort_name;
	}

	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
}
