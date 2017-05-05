package com.xoa.model.workflow;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-5-5 下午2:33:50
 * 类介绍  :   创建工作流
 * 构造参数:   
 *
 */
public class FlowTypeModel implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer flowId;

    private String flowName;

    private Integer formId;

    private String flowDoc;

    private String flowType;

    private Integer flowNo;

    private Integer flowSort;

    private Integer autoNum;

    private Integer autoLen;

    private String autoEdit;

    private String commentPriv;

    private Integer deptId;

    private String freePreset;

    private String freeOther;

    private String allowPreSet;

    private String forcePreSet;

    private Integer viewPriv;

    private Integer isVersion;

    private String flowAction;

    private Integer autoNumYear;

    private Integer autoNumMonth;

    private Date autoNumTime;
    
    private String manageUser;

    private String autoName;

    private String queryUser;

    private String flowDesc;

    private String newUser;

    private String queryItem;

    private String queryUserDept;

    private String manageUserDept;

    private String editPriv;

    private String listFldsStr;

    private String modelId;

    private String modelName;

    private String attachmentId;

    private String attachmentName;

    private String viewUser;

    private String viewDept;

    private String viewRole;
    

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getFlowDoc() {
        return flowDoc;
    }

    public void setFlowDoc(String flowDoc) {
        this.flowDoc = flowDoc == null ? null : flowDoc.trim();
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    public Integer getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(Integer flowNo) {
        this.flowNo = flowNo;
    }

    public Integer getFlowSort() {
        return flowSort;
    }

    public void setFlowSort(Integer flowSort) {
        this.flowSort = flowSort;
    }

    public Integer getAutoNum() {
        return autoNum;
    }

    public void setAutoNum(Integer autoNum) {
        this.autoNum = autoNum;
    }

    public Integer getAutoLen() {
        return autoLen;
    }

    public void setAutoLen(Integer autoLen) {
        this.autoLen = autoLen;
    }

    public String getAutoEdit() {
        return autoEdit;
    }

    public void setAutoEdit(String autoEdit) {
        this.autoEdit = autoEdit == null ? null : autoEdit.trim();
    }

    public String getCommentPriv() {
        return commentPriv;
    }

    public void setCommentPriv(String commentPriv) {
        this.commentPriv = commentPriv == null ? null : commentPriv.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getFreePreset() {
        return freePreset;
    }

    public void setFreePreset(String freePreset) {
        this.freePreset = freePreset == null ? null : freePreset.trim();
    }

    public String getFreeOther() {
        return freeOther;
    }

    public void setFreeOther(String freeOther) {
        this.freeOther = freeOther == null ? null : freeOther.trim();
    }

    public String getAllowPreSet() {
        return allowPreSet;
    }

    public void setAllowPreSet(String allowPreSet) {
        this.allowPreSet = allowPreSet == null ? null : allowPreSet.trim();
    }

    public String getForcePreSet() {
        return forcePreSet;
    }

    public void setForcePreSet(String forcePreSet) {
        this.forcePreSet = forcePreSet == null ? null : forcePreSet.trim();
    }

    public Integer getViewPriv() {
        return viewPriv;
    }

    public void setViewPriv(Integer viewPriv) {
        this.viewPriv = viewPriv;
    }

    public Integer getIsVersion() {
        return isVersion;
    }

    public void setIsVersion(Integer isVersion) {
        this.isVersion = isVersion;
    }

    public String getFlowAction() {
        return flowAction;
    }

    public void setFlowAction(String flowAction) {
        this.flowAction = flowAction == null ? null : flowAction.trim();
    }

    public Integer getAutoNumYear() {
        return autoNumYear;
    }

    public void setAutoNumYear(Integer autoNumYear) {
        this.autoNumYear = autoNumYear;
    }

    public Integer getAutoNumMonth() {
        return autoNumMonth;
    }

    public void setAutoNumMonth(Integer autoNumMonth) {
        this.autoNumMonth = autoNumMonth;
    }

    public Date getAutoNumTime() {
        return autoNumTime;
    }

    public void setAutoNumTime(Date autoNumTime) {
        this.autoNumTime = autoNumTime;
    }
    
    public String getManageUser() {
        return manageUser;
    }

    public void setManageUser(String manageUser) {
        this.manageUser = manageUser == null ? null : manageUser.trim();
    }

    public String getAutoName() {
        return autoName;
    }

    public void setAutoName(String autoName) {
        this.autoName = autoName == null ? null : autoName.trim();
    }

    public String getQueryUser() {
        return queryUser;
    }

    public void setQueryUser(String queryUser) {
        this.queryUser = queryUser == null ? null : queryUser.trim();
    }

    public String getFlowDesc() {
        return flowDesc;
    }

    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc == null ? null : flowDesc.trim();
    }

    public String getNewUser() {
        return newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser == null ? null : newUser.trim();
    }

    public String getQueryItem() {
        return queryItem;
    }

    public void setQueryItem(String queryItem) {
        this.queryItem = queryItem == null ? null : queryItem.trim();
    }

    public String getQueryUserDept() {
        return queryUserDept;
    }

    public void setQueryUserDept(String queryUserDept) {
        this.queryUserDept = queryUserDept == null ? null : queryUserDept.trim();
    }

    public String getManageUserDept() {
        return manageUserDept;
    }

    public void setManageUserDept(String manageUserDept) {
        this.manageUserDept = manageUserDept == null ? null : manageUserDept.trim();
    }

    public String getEditPriv() {
        return editPriv;
    }

    public void setEditPriv(String editPriv) {
        this.editPriv = editPriv == null ? null : editPriv.trim();
    }

    public String getListFldsStr() {
        return listFldsStr;
    }

    public void setListFldsStr(String listFldsStr) {
        this.listFldsStr = listFldsStr == null ? null : listFldsStr.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getViewUser() {
        return viewUser;
    }

    public void setViewUser(String viewUser) {
        this.viewUser = viewUser == null ? null : viewUser.trim();
    }

    public String getViewDept() {
        return viewDept;
    }

    public void setViewDept(String viewDept) {
        this.viewDept = viewDept == null ? null : viewDept.trim();
    }

    public String getViewRole() {
        return viewRole;
    }

    public void setViewRole(String viewRole) {
        this.viewRole = viewRole == null ? null : viewRole.trim();
    }
}