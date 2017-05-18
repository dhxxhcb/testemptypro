package com.xoa.model.workflow;

import java.util.List;
import java.util.Map;

public class FlowProcess {
    private Integer id;

    private Integer flowId;

    private Integer prcsId;

    private Byte prcsType;

    private String prcsName;

    private Integer setLeft;

    private Integer setTop;

    private String feedback;

    private String autoType;

    private String userFilter;

    private String timeOut;

    private String timeOutModify;

    private String timeOutAttend;

    private String signlook;

    private String topDefault;

    private String userLock;

    private String syncDeal;

    private String syncDealCheck;

    private String turnPriv;

    private Integer childFlow;

    private String gatherNode;

    private String allowBack;

    private String attachPriv;

    private Integer autoBaseUser;

    private Integer remindFlag;

    private Integer dispAip;

    private String timeOutType;

    private String attachEditPriv;

    private String attachEditPrivOnline;

    private String attachMacroMark;

    private Integer viewPriv;

    private Boolean signType;

    private Boolean countersign;

    private String workingdaysType;

    private String prcsUser;

    private String prcsItem;

    private String hiddenItem;

    private String requiredItem;

    private String prcsDept;

    private String prcsPriv;

    private String prcsTo;

    private String plugin;

    private String pluginSave;

    private String prcsItemAuto;

    private String prcsIn;

    private String prcsOut;

    private String prcsInSet;

    private String prcsOutSet;

    private String autoDept;

    private String autoUserOp;

    private String autoUser;

    private String autoUserOpReturn;

    private String autoUserReturn;

    private String userFilterPrcsPriv;

    private String userFilterPrcsPrivOther;

    private String userFilterPrcsDept;

    private String userFilterPrcsDeptOther;

    private String mailTo;

    private String mailToDept;

    private String mailToPriv;

    private String conditionDesc;

    private String relationIn;

    private String relationOut;

    private String controlMode;

    private String listColumnPriv;

    private String fileuploadPriv;

    private String imguploadPriv;

    private List<Map<String, String>> connections;
    
    private List<FlowProcessList> designdata;
    
    private Integer max;
    
	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public List<FlowProcessList> getDesigndata() {
		return designdata;
	}

	public void setDesigndata(List<FlowProcessList> designdata) {
		this.designdata = designdata;
	}

	public List<Map<String, String>> getConnections() {
		return connections;
	}

	public void setConnections(List<Map<String,String>> connections) {
		this.connections = connections;
	}

	public String getPrcsUser() {
        return prcsUser;
    }

    public void setPrcsUser(String prcsUser) {
        this.prcsUser = prcsUser == null ? null : prcsUser.trim();
    }

    public String getPrcsItem() {
        return prcsItem;
    }

    public void setPrcsItem(String prcsItem) {
        this.prcsItem = prcsItem == null ? null : prcsItem.trim();
    }

    public String getHiddenItem() {
        return hiddenItem;
    }

    public void setHiddenItem(String hiddenItem) {
        this.hiddenItem = hiddenItem == null ? null : hiddenItem.trim();
    }

    public String getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(String requiredItem) {
        this.requiredItem = requiredItem == null ? null : requiredItem.trim();
    }

    public String getPrcsDept() {
        return prcsDept;
    }

    public void setPrcsDept(String prcsDept) {
        this.prcsDept = prcsDept == null ? null : prcsDept.trim();
    }

    public String getPrcsPriv() {
        return prcsPriv;
    }

    public void setPrcsPriv(String prcsPriv) {
        this.prcsPriv = prcsPriv == null ? null : prcsPriv.trim();
    }

    public String getPrcsTo() {
        return prcsTo;
    }

    public void setPrcsTo(String prcsTo) {
        this.prcsTo = prcsTo == null ? null : prcsTo.trim();
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin == null ? null : plugin.trim();
    }

    public String getPluginSave() {
        return pluginSave;
    }

    public void setPluginSave(String pluginSave) {
        this.pluginSave = pluginSave == null ? null : pluginSave.trim();
    }

    public String getPrcsItemAuto() {
        return prcsItemAuto;
    }

    public void setPrcsItemAuto(String prcsItemAuto) {
        this.prcsItemAuto = prcsItemAuto == null ? null : prcsItemAuto.trim();
    }

    public String getPrcsIn() {
        return prcsIn;
    }

    public void setPrcsIn(String prcsIn) {
        this.prcsIn = prcsIn == null ? null : prcsIn.trim();
    }

    public String getPrcsOut() {
        return prcsOut;
    }

    public void setPrcsOut(String prcsOut) {
        this.prcsOut = prcsOut == null ? null : prcsOut.trim();
    }

    public String getPrcsInSet() {
        return prcsInSet;
    }

    public void setPrcsInSet(String prcsInSet) {
        this.prcsInSet = prcsInSet == null ? null : prcsInSet.trim();
    }

    public String getPrcsOutSet() {
        return prcsOutSet;
    }

    public void setPrcsOutSet(String prcsOutSet) {
        this.prcsOutSet = prcsOutSet == null ? null : prcsOutSet.trim();
    }

    public String getAutoDept() {
        return autoDept;
    }

    public void setAutoDept(String autoDept) {
        this.autoDept = autoDept == null ? null : autoDept.trim();
    }

    public String getAutoUserOp() {
        return autoUserOp;
    }

    public void setAutoUserOp(String autoUserOp) {
        this.autoUserOp = autoUserOp == null ? null : autoUserOp.trim();
    }

    public String getAutoUser() {
        return autoUser;
    }

    public void setAutoUser(String autoUser) {
        this.autoUser = autoUser == null ? null : autoUser.trim();
    }

    public String getAutoUserOpReturn() {
        return autoUserOpReturn;
    }

    public void setAutoUserOpReturn(String autoUserOpReturn) {
        this.autoUserOpReturn = autoUserOpReturn == null ? null : autoUserOpReturn.trim();
    }

    public String getAutoUserReturn() {
        return autoUserReturn;
    }

    public void setAutoUserReturn(String autoUserReturn) {
        this.autoUserReturn = autoUserReturn == null ? null : autoUserReturn.trim();
    }

    public String getUserFilterPrcsPriv() {
        return userFilterPrcsPriv;
    }

    public void setUserFilterPrcsPriv(String userFilterPrcsPriv) {
        this.userFilterPrcsPriv = userFilterPrcsPriv == null ? null : userFilterPrcsPriv.trim();
    }

    public String getUserFilterPrcsPrivOther() {
        return userFilterPrcsPrivOther;
    }

    public void setUserFilterPrcsPrivOther(String userFilterPrcsPrivOther) {
        this.userFilterPrcsPrivOther = userFilterPrcsPrivOther == null ? null : userFilterPrcsPrivOther.trim();
    }

    public String getUserFilterPrcsDept() {
        return userFilterPrcsDept;
    }

    public void setUserFilterPrcsDept(String userFilterPrcsDept) {
        this.userFilterPrcsDept = userFilterPrcsDept == null ? null : userFilterPrcsDept.trim();
    }

    public String getUserFilterPrcsDeptOther() {
        return userFilterPrcsDeptOther;
    }

    public void setUserFilterPrcsDeptOther(String userFilterPrcsDeptOther) {
        this.userFilterPrcsDeptOther = userFilterPrcsDeptOther == null ? null : userFilterPrcsDeptOther.trim();
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo == null ? null : mailTo.trim();
    }

    public String getMailToDept() {
        return mailToDept;
    }

    public void setMailToDept(String mailToDept) {
        this.mailToDept = mailToDept == null ? null : mailToDept.trim();
    }

    public String getMailToPriv() {
        return mailToPriv;
    }

    public void setMailToPriv(String mailToPriv) {
        this.mailToPriv = mailToPriv == null ? null : mailToPriv.trim();
    }

    public String getConditionDesc() {
        return conditionDesc;
    }

    public void setConditionDesc(String conditionDesc) {
        this.conditionDesc = conditionDesc == null ? null : conditionDesc.trim();
    }

    public String getRelationIn() {
        return relationIn;
    }

    public void setRelationIn(String relationIn) {
        this.relationIn = relationIn == null ? null : relationIn.trim();
    }

    public String getRelationOut() {
        return relationOut;
    }

    public void setRelationOut(String relationOut) {
        this.relationOut = relationOut == null ? null : relationOut.trim();
    }

    public String getControlMode() {
        return controlMode;
    }

    public void setControlMode(String controlMode) {
        this.controlMode = controlMode == null ? null : controlMode.trim();
    }

    public String getListColumnPriv() {
        return listColumnPriv;
    }

    public void setListColumnPriv(String listColumnPriv) {
        this.listColumnPriv = listColumnPriv == null ? null : listColumnPriv.trim();
    }

    public String getFileuploadPriv() {
        return fileuploadPriv;
    }

    public void setFileuploadPriv(String fileuploadPriv) {
        this.fileuploadPriv = fileuploadPriv == null ? null : fileuploadPriv.trim();
    }

    public String getImguploadPriv() {
        return imguploadPriv;
    }

    public void setImguploadPriv(String imguploadPriv) {
        this.imguploadPriv = imguploadPriv == null ? null : imguploadPriv.trim();
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getPrcsId() {
        return prcsId;
    }

    public void setPrcsId(Integer prcsId) {
        this.prcsId = prcsId;
    }

    public Byte getPrcsType() {
        return prcsType;
    }

    public void setPrcsType(Byte prcsType) {
        this.prcsType = prcsType;
    }

    public String getPrcsName() {
        return prcsName;
    }

    public void setPrcsName(String prcsName) {
        this.prcsName = prcsName == null ? null : prcsName.trim();
    }

    public Integer getSetLeft() {
        return setLeft;
    }

    public void setSetLeft(Integer setLeft) {
        this.setLeft = setLeft;
    }

    public Integer getSetTop() {
        return setTop;
    }

    public void setSetTop(Integer setTop) {
        this.setTop = setTop;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    public String getAutoType() {
        return autoType;
    }

    public void setAutoType(String autoType) {
        this.autoType = autoType == null ? null : autoType.trim();
    }

    public String getUserFilter() {
        return userFilter;
    }

    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter == null ? null : userFilter.trim();
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut == null ? null : timeOut.trim();
    }

    public String getTimeOutModify() {
        return timeOutModify;
    }

    public void setTimeOutModify(String timeOutModify) {
        this.timeOutModify = timeOutModify == null ? null : timeOutModify.trim();
    }

    public String getTimeOutAttend() {
        return timeOutAttend;
    }

    public void setTimeOutAttend(String timeOutAttend) {
        this.timeOutAttend = timeOutAttend == null ? null : timeOutAttend.trim();
    }

    public String getSignlook() {
        return signlook;
    }

    public void setSignlook(String signlook) {
        this.signlook = signlook == null ? null : signlook.trim();
    }

    public String getTopDefault() {
        return topDefault;
    }

    public void setTopDefault(String topDefault) {
        this.topDefault = topDefault == null ? null : topDefault.trim();
    }

    public String getUserLock() {
        return userLock;
    }

    public void setUserLock(String userLock) {
        this.userLock = userLock == null ? null : userLock.trim();
    }

    public String getSyncDeal() {
        return syncDeal;
    }

    public void setSyncDeal(String syncDeal) {
        this.syncDeal = syncDeal == null ? null : syncDeal.trim();
    }

    public String getSyncDealCheck() {
        return syncDealCheck;
    }

    public void setSyncDealCheck(String syncDealCheck) {
        this.syncDealCheck = syncDealCheck == null ? null : syncDealCheck.trim();
    }

    public String getTurnPriv() {
        return turnPriv;
    }

    public void setTurnPriv(String turnPriv) {
        this.turnPriv = turnPriv == null ? null : turnPriv.trim();
    }

    public Integer getChildFlow() {
        return childFlow;
    }

    public void setChildFlow(Integer childFlow) {
        this.childFlow = childFlow;
    }

    public String getGatherNode() {
        return gatherNode;
    }

    public void setGatherNode(String gatherNode) {
        this.gatherNode = gatherNode == null ? null : gatherNode.trim();
    }

    public String getAllowBack() {
        return allowBack;
    }

    public void setAllowBack(String allowBack) {
        this.allowBack = allowBack == null ? null : allowBack.trim();
    }

    public String getAttachPriv() {
        return attachPriv;
    }

    public void setAttachPriv(String attachPriv) {
        this.attachPriv = attachPriv == null ? null : attachPriv.trim();
    }

    public Integer getAutoBaseUser() {
        return autoBaseUser;
    }

    public void setAutoBaseUser(Integer autoBaseUser) {
        this.autoBaseUser = autoBaseUser;
    }

    public Integer getRemindFlag() {
        return remindFlag;
    }

    public void setRemindFlag(Integer remindFlag) {
        this.remindFlag = remindFlag;
    }

    public Integer getDispAip() {
        return dispAip;
    }

    public void setDispAip(Integer dispAip) {
        this.dispAip = dispAip;
    }

    public String getTimeOutType() {
        return timeOutType;
    }

    public void setTimeOutType(String timeOutType) {
        this.timeOutType = timeOutType == null ? null : timeOutType.trim();
    }

    public String getAttachEditPriv() {
        return attachEditPriv;
    }

    public void setAttachEditPriv(String attachEditPriv) {
        this.attachEditPriv = attachEditPriv == null ? null : attachEditPriv.trim();
    }

    public String getAttachEditPrivOnline() {
        return attachEditPrivOnline;
    }

    public void setAttachEditPrivOnline(String attachEditPrivOnline) {
        this.attachEditPrivOnline = attachEditPrivOnline == null ? null : attachEditPrivOnline.trim();
    }

    public String getAttachMacroMark() {
        return attachMacroMark;
    }

    public void setAttachMacroMark(String attachMacroMark) {
        this.attachMacroMark = attachMacroMark == null ? null : attachMacroMark.trim();
    }

    public Integer getViewPriv() {
        return viewPriv;
    }

    public void setViewPriv(Integer viewPriv) {
        this.viewPriv = viewPriv;
    }

    public Boolean getSignType() {
        return signType;
    }

    public void setSignType(Boolean signType) {
        this.signType = signType;
    }

    public Boolean getCountersign() {
        return countersign;
    }

    public void setCountersign(Boolean countersign) {
        this.countersign = countersign;
    }

    public String getWorkingdaysType() {
        return workingdaysType;
    }

    public void setWorkingdaysType(String workingdaysType) {
        this.workingdaysType = workingdaysType == null ? null : workingdaysType.trim();
    }
}