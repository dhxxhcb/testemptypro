package com.xoa.model.workflow;

import com.xoa.model.department.Department;
import com.xoa.util.DateFormat;

import java.util.List;

public class FlowRunPrcs {
    /** 主键ID **/
    protected int id;
    /** 流程实例ID **/
    protected int runId;
    /** 流程实例步骤ID **/
    protected int prcsId;
    /** 用户ID **/
    protected String userId;
    /** 工作接收时间 **/
    protected String prcsTime;
    /** 工作转交/办结时间 **/
    protected String deliverTime;
    /** 步骤状态(1-未接收,2-办理中,3-转交下一步，下一步经办人无人接收,4-已办结,5-自由流程预设步骤,6-已挂起,) **/
    protected String prcsFlag;
    /** 步骤ID[设计流程中的步骤号] **/
    protected int flowPrcs;
    /** 是否主办(0-经办,1-主办) **/
    protected String opFlag;
    /** 主办人选项(0-指定主办人,1-先接收者主办,2-无主办人会签,) **/
    protected String topFlag;
    /** 上一步流程FLOW_PRCS **/
    protected String parent;
    /** 子流程的流程实例ID **/
    protected int childRun;
    /** 待定 **/
    protected String timeOut;
    /** 步骤可写字段[仅自由流程且只有主办人生效] **/
    protected String freeItem;
    /** 待定 **/
    protected String timeOutTemp;
    /** 工作委托用户ID串 **/
    protected String otherUser;
    /** 是否超时(1-超时,其他-不超时) **/
    protected String timeOutFlag;
    /** 工作创建时间 **/
    protected String createTime;
    /** 工作移交用户ID **/
    protected String fromUser;
    /** 取消挂起的时间 **/
    protected String activeTime;
    /** 批注 **/
    protected String comment;
    /** 超时统计查询增加部门 **/
    protected int prcsDept;
    /** 上一步流程PRCS_ID **/
    protected String parentPrcsId;
    /** 返回步骤PRCS_ID标志 **/
    protected int backPrcsId;
    /** 返回步骤FLOW_PRCS标志 **/
    protected int backFlowPrcs;
    /** 是否排除工作时段按排班类型(0-否,1-是) **/
    protected Object timeOutAttend;
    /** 超时计算方法(0-本步骤接收后开始计时,1-上一步骤转交后开始计时 ) **/
    protected Integer timeOutType;
    /**  **/
    protected String runPrcsName;
    /**  **/
    protected String runPrcsId;
    /** 是否是移动端操作(0-否,1-是) **/
    protected Integer mobileFlag;
    /** 是否催办 **/
    protected int isRemind;
    /** 区分自由流程回收的是预设步骤还是普通流转步骤，1-普通流转步骤，5-预设步骤 **/
    protected Integer tempPrcsFlag;
    /** 工作天数换算方式(0-24小时为一天，1-按个人排班类型工作时长为一天) **/
    protected String workingdaysType;

    /**
     * 发起人姓名
     */
    protected String userName;

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/5/25 14:04
     * 方法介绍:   一对一关联对象
     * 参数说明:
     * @return
     */
    protected FlowRun flowRun;

    /**
     * 流程设置
     */
    protected FlowTypeModel flowType;

    /**
     * 关联设计流程
     */
    protected FlowProcess flowProcess;

    /**
     * 到达时间
     */
    protected String  receiptTime;
      
    /**
     * 到达停留时间
     */
    protected String arriveTime;

    /**
     * 办理停留时间
     */
	protected String handleTime;

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
        return prcsTime==null?DateFormat.getStrTime(-621701856):prcsTime;
    }

    public void setPrcsTime(String prcsTime) {
        this.prcsTime = prcsTime;
    }

    public String getDeliverTime() {
        return deliverTime==null? DateFormat.getStrTime(-621701856):deliverTime.trim();
    }

    /**
     * 工作转交/办结时间
     * @param deliverTime
     */
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

    public FlowTypeModel getFlowType() {
        return flowType;
    }

    public void setFlowType(FlowTypeModel flowType) {
        this.flowType = flowType;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/1 14:02
     * 方法介绍:   关联设计流程
     * 参数说明:
     * @return
     */
    public FlowProcess getFlowProcess() {
        return flowProcess;
    }

    /**
     * 创建作者:   张勇
     * 创建日期:   2017/6/1 14:02
     * 方法介绍:   关联设计流程
     * 参数说明:
     * @return
     */
    public void setFlowProcess(FlowProcess flowProcess) {
        this.flowProcess = flowProcess;
    }

    public String getReceiptTime() {
        return receiptTime == null ? "":receiptTime;
    }

    /**
     *  到达时间
     * @param receiptTime
     */
    public void setReceiptTime(String receiptTime) {
        this.receiptTime = receiptTime;
    }

    /**
     * 到达停留时间
     * @return
     */
    public String getArriveTime() {
        return arriveTime == null ?"":arriveTime;
    }

    /**
     * 到达停留时间
     * @param arriveTime
     */
    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    /**
     * 办理停留时间
     * @return
     */
    public String getHandleTime() {
        return handleTime == null ? "":handleTime;
    }

    /**
     * 办理停留时间
     * @param handleTime
     */
    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }
}