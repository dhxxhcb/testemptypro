package com.xoa.model.workflow;

import java.util.List;

public class FlowSort {
    private Integer sortId;

    private Integer sortNo;

    private String sortName;

    private Integer deptId;

    private Integer sortParent;

    private String haveChild;

    private Integer flowcounts;

    private String departName;

    public String getDepartName() {
        if(departName==null){
            departName="全部部门";
        }
        return departName;
    }
    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Integer getFlowcounts() {
        if(flowcounts==null){
            flowcounts=0;
        }
        return flowcounts;
    }

    public void setFlowcounts(Integer flowcounts) {
        this.flowcounts = flowcounts;
    }

    private List<FlowSort> childs;

    public List<FlowSort> getChilds() {
        return childs;
    }

    public void setChilds(List<FlowSort> childs) {
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
}