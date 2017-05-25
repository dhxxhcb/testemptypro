package com.xoa.model.workflow;

public class FlowRunPrcs {
	/** 主键ID **/
	private int id;
	/** 流程实例ID **/
	private int runId;
	/** 流程实例步骤ID **/
	private int prcsId;
	/** 用户ID **/
	private String userId;
	/** 工作接收时间 **/
	private String prcsTime;
	/** 工作转交/办结时间 **/
	private String deliverTime;
	/** 步骤状态(1-未接收,2-办理中,3-转交下一步，下一步经办人无人接收,4-已办结,5-自由流程预设步骤,6-已挂起,) **/
	private String prcsFlag;
	/** 步骤ID[设计流程中的步骤号] **/
	private int flowPrcs;
	/** 是否主办(0-经办,1-主办) **/
	private String opFlag;
	/** 主办人选项(0-指定主办人,1-先接收者主办,2-无主办人会签,) **/
	private String topFlag;
	/** 上一步流程FLOW_PRCS **/
	private String parent;
	/** 子流程的流程实例ID **/
	private int childRun;
	/** 待定 **/
	private String timeOut;
	/** 步骤可写字段[仅自由流程且只有主办人生效] **/
	private String freeItem;
	/** 待定 **/
	private String timeOutTemp;
	/** 工作委托用户ID串 **/
	private String otherUser;
	/** 是否超时(1-超时,其他-不超时) **/
	private String timeOutFlag;
	/** 工作创建时间 **/
	private String createTime;
	/** 工作移交用户ID **/
	private String fromUser;
	/** 取消挂起的时间 **/
	private String activeTime;
	/** 批注 **/
	private String comment;
	/** 超时统计查询增加部门 **/
	private int prcsDept;
	/** 上一步流程PRCS_ID **/
	private String parentPrcsId;
	/** 返回步骤PRCS_ID标志 **/
	private int backPrcsId;
	/** 返回步骤FLOW_PRCS标志 **/
	private int backFlowPrcs;
	/** 是否排除工作时段按排班类型(0-否,1-是) **/
	private Object timeOutAttend;
	/** 超时计算方法(0-本步骤接收后开始计时,1-上一步骤转交后开始计时 ) **/
	private Integer timeOutType;
	/**  **/
	private String runPrcsName;
	/**  **/
	private String runPrcsId;
	/** 是否是移动端操作(0-否,1-是) **/
	private Integer mobileFlag;
	/** 是否催办 **/
	private int isRemind;
	/** 区分自由流程回收的是预设步骤还是普通流转步骤，1-普通流转步骤，5-预设步骤 **/
	private Integer tempPrcsFlag;
	/** 工作天数换算方式(0-24小时为一天，1-按个人排班类型工作时长为一天) **/
	private String workingdaysType;

    /**
     * 发起人姓名
     */
	private String userName;

	/**
	 * 创建作者:   张勇
	 * 创建日期:   2017/5/25 14:04
	 * 方法介绍:   一对一关联对象
	 * 参数说明:   
	 * @return     
	 */
	private FlowRun flowRun;


    public FlowRun getFlowRun() {
        return flowRun;
    }

    public void setFlowRun(FlowRun flowRun) {
        this.flowRun = flowRun;
    }

    public String getFreeItem() {
        return freeItem == null ? "" : freeItem.trim();
    }

    public void setFreeItem(String freeItem) {
        this.freeItem = freeItem == null ? "" : freeItem.trim();
    }

    public String getOtherUser() {
        return otherUser==null?"":otherUser.trim();
    }

    public void setOtherUser(String otherUser) {
        this.otherUser = otherUser == null ? null : otherUser.trim();
    }

    public String getComment() {
        return comment==null?"":comment.trim();
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRunId() {
        return runId;
    }

    public void setRunId(Integer runId) {
        this.runId = runId;
    }

    public Integer getPrcsId() {
        return prcsId;
    }

    public void setPrcsId(Integer prcsId) {
        this.prcsId = prcsId;
    }

    public String getUserId() {
        return userId==null?"":userId.trim();
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPrcsTime() {
        return prcsTime==null?"":prcsTime;
    }

    public void setPrcsTime(String prcsTime) {
        this.prcsTime = prcsTime;
    }

    public String getDeliverTime() {
        return deliverTime==null?"":deliverTime.trim();
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getPrcsFlag() {
        return prcsFlag==null?"":prcsFlag.trim();
    }

    public void setPrcsFlag(String prcsFlag) {
        this.prcsFlag = prcsFlag == null ? null : prcsFlag.trim();
    }

    public Integer getFlowPrcs() {
        return flowPrcs;
    }

    public void setFlowPrcs(Integer flowPrcs) {
        this.flowPrcs = flowPrcs;
    }

    public String getOpFlag() {
        return opFlag==null?"":opFlag.trim();
    }

    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag == null ? null : opFlag.trim();
    }

    public String getTopFlag() {
        return topFlag==null?"":topFlag.trim();
    }

    public void setTopFlag(String topFlag) {
        this.topFlag = topFlag == null ? null : topFlag.trim();
    }

    public String getParent() {
        return parent==null?"":parent.trim();
    }

    public void setParent(String parent) {
        this.parent = parent == null ? null : parent.trim();
    }

    public Integer getChildRun() {
        return childRun;
    }

    public void setChildRun(Integer childRun) {
        this.childRun = childRun;
    }

    public String getTimeOut() {
        return timeOut==null?"":timeOut.trim();
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut == null ? null : timeOut.trim();
    }

    public String getTimeOutTemp() {
        return timeOutTemp==null?"":timeOutTemp.trim();
    }

    public void setTimeOutTemp(String timeOutTemp) {
        this.timeOutTemp = timeOutTemp == null ? null : timeOutTemp.trim();
    }

    public String getTimeOutFlag() {
        return timeOutFlag==null?"":timeOutFlag.trim();
    }

    public void setTimeOutFlag(String timeOutFlag) {
        this.timeOutFlag = timeOutFlag == null ? null : timeOutFlag.trim();
    }

    public String getCreateTime() {
        return createTime==null?"":createTime.trim();
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFromUser() {
        return fromUser==null?"":fromUser.trim();
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser == null ? null : fromUser.trim();
    }

    public String getActiveTime() {
        return activeTime==null?"":activeTime.trim();
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public Integer getPrcsDept() {
        return prcsDept;
    }

    public void setPrcsDept(Integer prcsDept) {
        this.prcsDept = prcsDept;
    }

    public String getParentPrcsId() {
        return parentPrcsId==null?"":parentPrcsId.trim();
    }

    public void setParentPrcsId(String parentPrcsId) {
        this.parentPrcsId = parentPrcsId == null ? null : parentPrcsId.trim();
    }

    public Integer getBackPrcsId() {
        return backPrcsId;
    }

    public void setBackPrcsId(Integer backPrcsId) {
        this.backPrcsId = backPrcsId;
    }

    public Integer getBackFlowPrcs() {
        return backFlowPrcs;
    }

    public void setBackFlowPrcs(Integer backFlowPrcs) {
        this.backFlowPrcs = backFlowPrcs;
    }

    public Object getTimeOutAttend() {
        return timeOutAttend;
    }

    public void setTimeOutAttend(Object timeOutAttend) {
        this.timeOutAttend = timeOutAttend;
    }

    public Integer getTimeOutType() {
        return timeOutType;
    }

    public void setTimeOutType(Integer timeOutType) {
        this.timeOutType = timeOutType;
    }

    public String getRunPrcsName() {
        return runPrcsName==null?"":runPrcsName.trim();
    }

    public void setRunPrcsName(String runPrcsName) {
        this.runPrcsName = runPrcsName == null ? null : runPrcsName.trim();
    }

    public String getRunPrcsId() {
        return runPrcsId==null?"":runPrcsId.trim();
    }

    public void setRunPrcsId(String runPrcsId) {
        this.runPrcsId = runPrcsId == null ? null : runPrcsId.trim();
    }

    public Integer getMobileFlag() {
        return mobileFlag;
    }

    public void setMobileFlag(Integer mobileFlag) {
        this.mobileFlag = mobileFlag;
    }

    public Integer getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(Integer isRemind) {
        this.isRemind = isRemind;
    }

    public Integer getTempPrcsFlag() {
        return tempPrcsFlag;
    }

    public void setTempPrcsFlag(Integer tempPrcsFlag) {
        this.tempPrcsFlag = tempPrcsFlag;
    }

    public String getWorkingdaysType() {
        return workingdaysType==null?"":workingdaysType.trim();
    }

    public void setWorkingdaysType(String workingdaysType) {
        this.workingdaysType = workingdaysType == null ? null : workingdaysType.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}