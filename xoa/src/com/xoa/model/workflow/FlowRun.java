package com.xoa.model.workflow;

public class FlowRun {
	/** 主键ID **/
	private int rid;
	/** 流程实例ID **/
	private int runId;
	/** 流程实例名称 **/
	private String runName;
	/** 流程ID **/
	private int flowId;
	/** 流程发起人ID **/
	private String beginUser;
	/** 流程发起人部门ID **/
	private int beginDept;
	/** 流程实例创建时间 **/
	private String beginTime;
	/** 流程实例结束时间 **/
	private String endTime;
	/** 附件ID串 **/
	private String attachmentId;
	/** 附件名称串 **/
	private String attachmentName;
	/** 删除标记(0-未删除,1-已删除)删除后流程实例可在工作销毁中确实删除或还原 **/
	private String delFlag;
	/** 关注该流程的用户 **/
	private String focusUser;
	/** 父流程ID **/
	private int parentRun;
	/** 已废弃，改为FLOW_RUN_PRCS表中记录 **/
	private String fromUser;
	/** 相关的版式文件信息 **/
	private String aipFiles;
	/** 待定 **/
	private String preSet;
	/** 传阅人ID串工作办理结束时选择的传阅人 **/
	private String viewUser;
	/** 是否归档(0-否,1-是) **/
	private int archive;
	/** 强制结束信息 **/
	private String forceOver;
	/** 工作等级 0-普通 1-重要 2-紧急 **/
	private int workLevel;
	/** 删除时间 **/
	private String delTime;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRunId() {
		return runId;
	}
	public void setRunId(int runId) {
		this.runId = runId;
	}
	public String getRunName() {
		return runName;
	}
	public void setRunName(String runName) {
		this.runName = runName;
	}
	public int getFlowId() {
		return flowId;
	}
	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}
	public String getBeginUser() {
		return beginUser;
	}
	public void setBeginUser(String beginUser) {
		this.beginUser = beginUser;
	}
	public int getBeginDept() {
		return beginDept;
	}
	public void setBeginDept(int beginDept) {
		this.beginDept = beginDept;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getFocusUser() {
		return focusUser;
	}
	public void setFocusUser(String focusUser) {
		this.focusUser = focusUser;
	}
	public int getParentRun() {
		return parentRun;
	}
	public void setParentRun(int parentRun) {
		this.parentRun = parentRun;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getAipFiles() {
		return aipFiles;
	}
	public void setAipFiles(String aipFiles) {
		this.aipFiles = aipFiles;
	}
	public String getPreSet() {
		return preSet;
	}
	public void setPreSet(String preSet) {
		this.preSet = preSet;
	}
	public String getViewUser() {
		return viewUser;
	}
	public void setViewUser(String viewUser) {
		this.viewUser = viewUser;
	}
	public int getArchive() {
		return archive;
	}
	public void setArchive(int archive) {
		this.archive = archive;
	}
	public String getForceOver() {
		return forceOver;
	}
	public void setForceOver(String forceOver) {
		this.forceOver = forceOver;
	}
	public int getWorkLevel() {
		return workLevel;
	}
	public void setWorkLevel(int workLevel) {
		this.workLevel = workLevel;
	}
	public String getDelTime() {
		return delTime;
	}
	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}
	
	
   
}