package com.xoa.model.workflow;

import java.util.List;

public class FormSort {
    private Integer sortId;

    private Integer sortNo;

    private String sortName;

    private Integer sortParent;

    private String haveChild;

    private Integer deptId;

    private List<FormSort> childs;

    public List<FormSort> getChilds() {
        return childs;
    }

    public void setChilds(List<FormSort> childs) {
        this.childs = childs;
    }



    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName == null ? null : sortName.trim();
    }

    public Integer getSortParent() {
        return sortParent;
    }

    public void setSortParent(Integer sortParent) {
        this.sortParent = sortParent;
    }

    public String getHaveChild() {
        return haveChild;
    }

    public void setHaveChild(String haveChild) {
        this.haveChild = haveChild == null ? null : haveChild.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}