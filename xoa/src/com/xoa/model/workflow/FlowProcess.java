package com.xoa.model.workflow;

import java.util.List;
import java.util.Map;

public class FlowProcess {

	/** 主键ID **/
	private int id;
	/** 流程ID **/
	private int flowId;
	/** 步骤ID **/
	private int prcsId;
	/** 节点类型(0-步骤节点,1-自流程节点,2-外部流转节点) **/
	private byte prcsType;
	/** 步骤名称 **/
	private String prcsName;
	/** 经办人ID串 **/
	private String prcsUser;
	/** 可写字段串 **/
	private String prcsItem;
	/** 保密字段串 **/
	private String hiddenItem;
	/** 必填字段串 **/
	private String requiredItem;
	/** 经办部门ID串 **/
	private String prcsDept;
	/** 经办角色ID串 **/
	private String prcsPriv;
	/** 转交步骤ID串 **/
	private String prcsTo;
	/** 节点横坐标 **/
	private int setLeft;
	/** 节点纵坐标 **/
	private int setTop;
	/** 转交调用插件 **/
	private String plugin;
	/** 保存调用插件 **/
	private String pluginSave;
	/** 允许在不可写情况下自动赋值的宏控件 **/
	private String prcsItemAuto;
	/** 转入条件组成的串 **/
	private String prcsIn;
	/** 转出条件组成的串 **/
	private String prcsOut;
	/** 是否允许会签(0-允许会签,1-禁止会签,2-强制会签) **/
	private String feedback;
	/** 转入条件组成的逻辑表达式 **/
	private String prcsInSet;
	/** 转出条件组成的逻辑表达式 **/
	private String prcsOutSet;
	/** 自动选人规则(1-自动选择流程发起人,2-自动选择本部门主管,3-指定自动选择默认人员,4-自动选择上级主管领导,5-自动选择一级部门主管,6-自动选择上级分管领导,7-按表单字段选择,8-自动选择指定步骤主办人,9-自动选择本部门助理,10-自动选择本部门内符合条件所有人员,11-自动选择本一级部门内符合条件所有人员,12-自动选择指定部门主管,13-自动选择指定部门助理,14-自动选择指定部门上级主管领导,15-自动选择指定部门上级分管领导) **/
	private String autoType;
	/** 自动选择指定自动选择的部门 **/
	private String autoDept;
	/** 指定自动选择默认人员—主办人 **/
	private String autoUserOp;
	/** 指定自动选择默认人员—经办人 **/
	private String autoUser;
	/** 指定子流程返回父流程时自动选择默认人员—主办人 **/
	private String autoUserOpReturn;
	/** 指定子流程返回父流程时自动选择默认人员—经办人 **/
	private String autoUserReturn;
	/** 选人过滤规则(1-只允许选择本部门经办人,2-只允许选择本角色经办人,3-只允许选择上级部门经办人,4-只允许选择下级部门经办人,) **/
	private String userFilter;
	/** 选人过滤规则指定角色 **/
	private String userFilterPrcsPriv;
	/** 选人过滤规则指定辅助角色 **/
	private String userFilterPrcsPrivOther;
	/** 选人过滤规则指定部门 **/
	private String userFilterPrcsDept;
	/** 选人过滤规则指定辅助部门 **/
	private String userFilterPrcsDeptOther;
	/** 办理时限 **/
	private String timeOut;
	/** 是否允许转交时设置办理时限(0-不允许,1-允许) **/
	private String timeOutModify;
	/** 是否排除非工作时段(按排班类型)：(0-否,1-是,) **/
	private String timeOutAttend;
	/** 会签意见可见性(0-总是可见,1-本步骤经办人之间不可见,2-针对其他步骤不可见,) **/
	private String signlook;
	/** 主办人相关选项：(0-明确指定主办人,1-先接收者为主办人,2-无主办人会签,) **/
	private String topDefault;
	/** 是否允许修改主办人相关选项及默认经办人：(0-不允许,1-允许,) **/
	private String userLock;
	/** 转交时内部邮件通知以下人员ID串 **/
	private String mailTo;
	/** 转交时内部邮件通知以下部门人员ID串 **/
	private String mailToDept;
	/** 转交时内部邮件通知以下角色人员ID串 **/
	private String mailToPriv;
	/** 是否允许并发(0-禁止并发,1-允许并发,2-强制并发) **/
	private String syncDeal;
	/** 用途未知 **/
	private String syncDealCheck;
	/** 强制转交，经办人未办理完毕时是否允许主办人强制转交(0-不允许,1-允许,) **/
	private String turnPriv;
	/** 子流程的流程ID **/
	private int childFlow;
	/** 并发合并选项(0-非强制合并,1-强制合并,) **/
	private String gatherNode;
	/** 是否允许回退(0-不允许,1-允许回退上一步骤,2-允许回退之前步骤,) **/
	private String allowBack;
	/** 公共附件中的Office文档详细权限设置：(1-新建权限,2-编辑权限,3-删除权限,4-下载权限,5-打印权限,) **/
	private String attachPriv;
	/** 部门针对对象步骤的ID，0为当前步骤。配合自动选人规则使用。当自动选人规则为以下选项时启用(2-自动选择本部门主管,4-自动选择上级主管领导,6-自动选择上级分管领导,9-自动选择本部门助理,) **/
	private int autoBaseUser;
	/** 不符合条件公式时，给用户的文字描述 **/
	private String conditionDesc;
	/** 父流程->子流程映射关系 **/
	private String relationIn;
	/** 子流程->父流程映射关系 **/
	private String relationOut;
	/** 用途未知 **/
	private int remindFlag;
	/** 对应呈批单(0-表示不启用呈批单) **/
	private int dispAip;
	/** 超时计算方法(0-本步骤接收后开始计时,1-上一步骤转交后开始计时,) **/
	private String timeOutType;
	/** 是否允许本步骤经办人编辑附件(0-不允许,1-允许,) **/
	private String attachEditPriv;
	/** 是否允许本步骤经办人在线创建文档(0-允许,1-不允许,) **/
	private String attachEditPrivOnline;
	/** 宏标记附件上传为图片时展示效果(0-显示图片,1-显示图标和名称,) **/
	private String attachMacroMark;
	/** 列表控件模式(1-修改模式,2-添加模式,3-删除模式,保存格式如下例：列表控件1,列表控件2,|1`2`3,1`2,) **/
	private String controlMode;
	/** 列表控件单独列权限(1-只读,2-保密,4-必填，各项的与值) **/
	private String listColumnPriv;
	/** 传阅设置(0-不允许,1-允许,) **/
	private int viewPriv;
	/** 附件上传控件的权限(1-新建,2-编辑,3-删除,4-下载,5-打印) **/
	private String fileuploadPriv;
	/** 图片上传控件的权限(1-新建,2-删除,3-下载) **/
	private String imguploadPriv;
	/** 会签人设置(0-不允许,1-本步骤经办人,2-全部人员) **/
	private boolean signType;
	/** 会签人加签(0-不允许，1-允许) **/
	private boolean countersign;
	/** 工作天数换算方式(0-24小时为一天，1-按个人排班类型工作时长为一天) **/
	private String workingdaysType;

    private List<Map<String, String>> connections;
    
    private List<FlowProcessList> designdata;
    
    private Integer max;
    
    private String flowName;
    
	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

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
        return prcsUser == null ? "" :prcsUser.trim();
    }

    public void setPrcsUser(String prcsUser) {
        this.prcsUser = prcsUser == null ? null : prcsUser.trim();
    }

    public String getPrcsItem() {
        return prcsItem == null ? "" : prcsItem.trim();
    }

    public void setPrcsItem(String prcsItem) {
        this.prcsItem = prcsItem == null ? null : prcsItem.trim();
    }

    public String getHiddenItem() {
        return  hiddenItem == null ? "" : hiddenItem.trim();
    }

    public void setHiddenItem(String hiddenItem) {
        this.hiddenItem = hiddenItem == null ? null : hiddenItem.trim();
    }

    public String getRequiredItem() {
        return requiredItem == null ? "" : requiredItem.trim();
    }

    public void setRequiredItem(String requiredItem) {
        this.requiredItem = requiredItem == null ? null : requiredItem.trim();
    }

    public String getPrcsDept() {
        return prcsDept;
    }

    public void setPrcsDept(String prcsDept) {
        this.prcsDept = prcsDept == null ? "" : prcsDept.trim();
    }

    public String getPrcsPriv() {
        return prcsPriv;
    }

    public void setPrcsPriv(String prcsPriv) {
        this.prcsPriv = prcsPriv == null ? "" : prcsPriv.trim();
    }

    public String getPrcsTo() {
        return prcsTo;
    }

    public void setPrcsTo(String prcsTo) {
        this.prcsTo = prcsTo == null ? null : prcsTo.trim();
    }

    public String getPlugin() {
        return plugin == null ? "" : plugin.trim();
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

    public boolean getCountersign() {
        return countersign;
    }

    public void setCountersign(boolean countersign) {
        this.countersign = countersign;
    }

    public String getWorkingdaysType() {
        return workingdaysType;
    }

    public void setWorkingdaysType(String workingdaysType) {
        this.workingdaysType = workingdaysType == null ? null : workingdaysType.trim();
    }
}