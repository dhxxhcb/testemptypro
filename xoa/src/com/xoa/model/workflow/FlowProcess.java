package com.xoa.model.workflow;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FlowProcess implements Serializable {

    private static final long serialVersionUID = 1233L;

    /**
     * 主键ID
     **/
    private int id;
    /**
     * 流程ID
     **/
    private int flowId;
    /**
     * 步骤ID
     **/
    private int prcsId;
    /**
     * 节点类型(0-步骤节点,1-自流程节点,2-外部流转节点)
     **/
    private byte prcsType;
    /**
     * 步骤名称
     **/
    private String prcsName;
    /**
     * 经办人ID串
     **/
    private String prcsUser;
    /**
     * 可写字段串
     **/
    private String prcsItem;
    /**
     * 保密字段串
     **/
    private String hiddenItem;
    /**
     * 必填字段串
     **/
    private String requiredItem;
    /**
     * 经办部门ID串
     **/
    private String prcsDept;
    /**
     * 经办角色ID串
     **/
    private String prcsPriv;
    /**
     * 转交步骤ID串
     **/
    private String prcsTo;
    /**
     * 节点横坐标
     **/
    private int setLeft;
    /**
     * 节点纵坐标
     **/
    private int setTop;
    /**
     * 转交调用插件
     **/
    private String plugin;
    /**
     * 保存调用插件
     **/
    private String pluginSave;
    /**
     * 允许在不可写情况下自动赋值的宏控件
     **/
    private String prcsItemAuto;
    /**
     * 转入条件组成的串
     **/
    private String prcsIn;
    /**
     * 转出条件组成的串
     **/
    private String prcsOut;
    /**
     * 是否允许会签(0-允许会签,1-禁止会签,2-强制会签)
     **/
    private String feedback;
    /**
     * 转入条件组成的逻辑表达式
     **/
    private String prcsInSet;
    /**
     * 转出条件组成的逻辑表达式
     **/
    private String prcsOutSet;
    /**
     * 自动选人规则(1-自动选择流程发起人,2-自动选择本部门主管,3-指定自动选择默认人员,4-自动选择上级主管领导,5-自动选择一级部门主管,6-自动选择上级分管领导,7-按表单字段选择,8-自动选择指定步骤主办人,9-自动选择本部门助理,10-自动选择本部门内符合条件所有人员,11-自动选择本一级部门内符合条件所有人员,12-自动选择指定部门主管,13-自动选择指定部门助理,14-自动选择指定部门上级主管领导,15-自动选择指定部门上级分管领导)
     **/
    private String autoType;
    /**
     * 自动选择指定自动选择的部门
     **/
    private String autoDept;
    /**
     * 指定自动选择默认人员—主办人
     **/
    private String autoUserOp;
    /**
     * 指定自动选择默认人员—经办人
     **/
    private String autoUser;
    /**
     * 指定子流程返回父流程时自动选择默认人员—主办人
     **/
    private String autoUserOpReturn;
    /**
     * 指定子流程返回父流程时自动选择默认人员—经办人
     **/
    private String autoUserReturn;
    /**
     * 选人过滤规则(1-只允许选择本部门经办人,2-只允许选择本角色经办人,3-只允许选择上级部门经办人,4-只允许选择下级部门经办人,)
     **/
    private String userFilter;
    /**
     * 选人过滤规则指定角色
     **/
    private String userFilterPrcsPriv;
    /**
     * 选人过滤规则指定辅助角色
     **/
    private String userFilterPrcsPrivOther;
    /**
     * 选人过滤规则指定部门
     **/
    private String userFilterPrcsDept;
    /**
     * 选人过滤规则指定辅助部门
     **/
    private String userFilterPrcsDeptOther;
    /**
     * 办理时限
     **/
    private String timeOut;
    /**
     * 是否允许转交时设置办理时限(0-不允许,1-允许)
     **/
    private String timeOutModify;
    /**
     * 是否排除非工作时段(按排班类型)：(0-否,1-是,)
     **/
    private String timeOutAttend;
    /**
     * 会签意见可见性(0-总是可见,1-本步骤经办人之间不可见,2-针对其他步骤不可见,)
     **/
    private String signlook;
    /**
     * 主办人相关选项：(0-明确指定主办人,1-先接收者为主办人,2-无主办人会签,)
     **/
    private String topDefault;
    /**
     * 是否允许修改主办人相关选项及默认经办人：(0-不允许,1-允许,)
     **/
    private String userLock;
    /**
     * 转交时内部邮件通知以下人员ID串
     **/
    private String mailTo;
    /**
     * 转交时内部邮件通知以下部门人员ID串
     **/
    private String mailToDept;
    /**
     * 转交时内部邮件通知以下角色人员ID串
     **/
    private String mailToPriv;
    /**
     * 是否允许并发(0-禁止并发,1-允许并发,2-强制并发)
     **/
    private String syncDeal;
    /**
     * 用途未知
     **/
    private String syncDealCheck;
    /**
     * 强制转交，经办人未办理完毕时是否允许主办人强制转交(0-不允许,1-允许,)
     **/
    private String turnPriv;
    /**
     * 子流程的流程ID
     **/
    private int childFlow;
    /**
     * 并发合并选项(0-非强制合并,1-强制合并,)
     **/
    private String gatherNode;
    /**
     * 是否允许回退(0-不允许,1-允许回退上一步骤,2-允许回退之前步骤,)
     **/
    private String allowBack;
    /**
     * 公共附件中的Office文档详细权限设置：(1-新建权限,2-编辑权限,3-删除权限,4-下载权限,5-打印权限,)
     **/
    private String attachPriv;
    /**
     * 部门针对对象步骤的ID，0为当前步骤。配合自动选人规则使用。当自动选人规则为以下选项时启用(2-自动选择本部门主管,4-自动选择上级主管领导,6-自动选择上级分管领导,9-自动选择本部门助理,)
     **/
    private int autoBaseUser;
    /**
     * 不符合条件公式时，给用户的文字描述
     **/
    private String conditionDesc;
    /**
     * 父流程->子流程映射关系
     **/
    private String relationIn;
    /**
     * 子流程->父流程映射关系
     **/
    private String relationOut;
    /**
     * 用途未知
     **/
    private int remindFlag;
    /**
     * 对应呈批单(0-表示不启用呈批单)
     **/
    private int dispAip;
    /**
     * 超时计算方法(0-本步骤接收后开始计时,1-上一步骤转交后开始计时,)
     **/
    private String timeOutType;
    /**
     * 是否允许本步骤经办人编辑附件(0-不允许,1-允许,)
     **/
    private String attachEditPriv;
    /**
     * 是否允许本步骤经办人在线创建文档(0-允许,1-不允许,)
     **/
    private String attachEditPrivOnline;
    /**
     * 宏标记附件上传为图片时展示效果(0-显示图片,1-显示图标和名称,)
     **/
    private String attachMacroMark;
    /**
     * 列表控件模式(1-修改模式,2-添加模式,3-删除模式,保存格式如下例：列表控件1,列表控件2,|1`2`3,1`2,)
     **/
    private String controlMode;
    /**
     * 列表控件单独列权限(1-只读,2-保密,4-必填，各项的与值)
     **/
    private String listColumnPriv;
    /**
     * 传阅设置(0-不允许,1-允许,)
     **/
    private int viewPriv;
    /**
     * 附件上传控件的权限(1-新建,2-编辑,3-删除,4-下载,5-打印)
     **/
    private String fileuploadPriv;
    /**
     * 图片上传控件的权限(1-新建,2-删除,3-下载)
     **/
    private String imguploadPriv;
    /**
     * 会签人设置(0-不允许,1-本步骤经办人,2-全部人员)
     **/
    private int signType;
    /**
     * 会签人加签(0-不允许，1-允许)
     **/
    private int countersign;
    /**
     * 工作天数换算方式(0-24小时为一天，1-按个人排班类型工作时长为一天)
     **/
    private String workingdaysType;

    /**
     * 返回页面参数
     */
    private String setType;

    /**
     * 关联创建工作流
     */
    private FlowTypeModel flowTypeModel;

    /**
     * 条件设置Json串
     */
    private String settlementOfCondition;

    /**
     * 可写字段Json串
     */
    private String prcsItemTwo;

    /**
     * 可写字段如果有值转为autoUser
     */
    private  String ITEM_ID;

    /**
     * 可写字段如果有值转为autoUser
     */
    private String AUTO_PRCS_USER;

    private List<Map<String, String>> connections;

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

    public List<Map<String, String>> getConnections() {
        return connections;
    }

    public void setConnections(List<Map<String, String>> connections) {
        this.connections = connections;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlowId(int flowId) {
        this.flowId = flowId;
    }

    public void setPrcsId(int prcsId) {
        this.prcsId = prcsId;
    }


    public void setSetLeft(int setLeft) {
        this.setLeft = setLeft;
    }

    public void setSetTop(int setTop) {
        this.setTop = setTop;
    }

    public void setChildFlow(int childFlow) {
        this.childFlow = childFlow;
    }

    public void setAutoBaseUser(int autoBaseUser) {
        this.autoBaseUser = autoBaseUser;
    }

    public void setDispAip(int dispAip) {
        this.dispAip = dispAip;
    }

    public void setViewPriv(int viewPriv) {
        this.viewPriv = viewPriv;
    }


    public String getPrcsUser() {
        return prcsUser == null ? "" : prcsUser.trim();
    }

    public void setPrcsUser(String prcsUser) {
        this.prcsUser = prcsUser;
    }

    public String getPrcsItem() {
        return prcsItem == null ? "" : prcsItem.trim();
    }

    public void setPrcsItem(String prcsItem) {
        this.prcsItem = prcsItem;
    }

    public String getHiddenItem() {
        return hiddenItem == null ? "" : hiddenItem.trim();
    }

    public void setHiddenItem(String hiddenItem) {
        this.hiddenItem = hiddenItem;
    }

    public String getRequiredItem() {
        return requiredItem == null ? "" : requiredItem.trim();
    }

    public void setRequiredItem(String requiredItem) {
        this.requiredItem = requiredItem;
    }

    public String getPrcsDept() {
        return prcsDept == null ? "" : prcsDept;
    }

    public void setPrcsDept(String prcsDept) {
        this.prcsDept = prcsDept;
    }

    public String getPrcsPriv() {
        return prcsPriv == null ? "" : prcsPriv.trim();
    }

    public void setPrcsPriv(String prcsPriv) {
        this.prcsPriv = prcsPriv;
    }

    public String getPrcsTo() {
        return prcsTo == null ? "" : prcsTo.trim();
    }

    public void setPrcsTo(String prcsTo) {
        this.prcsTo = prcsTo;
    }

    public String getPlugin() {
        return plugin == null ? "" : plugin.trim();
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String getPluginSave() {
        return pluginSave == null ? "" : pluginSave.trim();
    }

    public void setPluginSave(String pluginSave) {
        this.pluginSave = pluginSave;
    }


    public String getPrcsItemAuto() {
        return prcsItemAuto == null ? "" : prcsItemAuto.trim();
    }

    public void setPrcsItemAuto(String prcsItemAuto) {
        this.prcsItemAuto = prcsItemAuto;
    }

    public String getPrcsIn() {
        return prcsIn == null ? "" : prcsIn;
    }

    public void setPrcsIn(String prcsIn) {
        this.prcsIn = prcsIn;
    }

    public String getPrcsOut() {
        return prcsOut == null ? "" : prcsOut.trim();
    }

    public void setPrcsOut(String prcsOut) {
        this.prcsOut = prcsOut;
    }

    public String getPrcsInSet() {
        return prcsInSet == null ? "" : prcsInSet.trim();
    }

    public void setPrcsInSet(String prcsInSet) {
        this.prcsInSet = prcsInSet;
    }

    public String getPrcsOutSet() {
        return prcsOutSet == null ? "" : prcsOutSet;
    }

    public void setPrcsOutSet(String prcsOutSet) {
        this.prcsOutSet = prcsOutSet;
    }

    public String getAutoDept() {
        return autoDept == null ? "" : autoDept.trim();
    }

    public void setAutoDept(String autoDept) {
        this.autoDept = autoDept;
    }

    public String getAutoUserOp() {
        return autoUserOp == null ? "" : autoUserOp.trim();
    }

    public void setAutoUserOp(String autoUserOp) {
        this.autoUserOp = autoUserOp;
    }

    public String getAutoUser() {
        return autoUser == null ? "" : autoUser;
    }

    public void setAutoUser(String autoUser) {
        this.autoUser = autoUser;
    }

    public String getAutoUserOpReturn() {
        return autoUserOpReturn == null ? "" : autoUserOpReturn.trim();
    }

    public void setAutoUserOpReturn(String autoUserOpReturn) {
        this.autoUserOpReturn = autoUserOpReturn;
    }

    public String getAutoUserReturn() {
        return autoUserReturn == null ? "" : autoUserReturn.trim();
    }

    public void setAutoUserReturn(String autoUserReturn) {
        this.autoUserReturn = autoUserReturn;
    }

    public String getUserFilterPrcsPriv() {
        return userFilterPrcsPriv == null ? "" : userFilterPrcsPriv.trim();
    }

    public void setUserFilterPrcsPriv(String userFilterPrcsPriv) {
        this.userFilterPrcsPriv = userFilterPrcsPriv == null ? null : userFilterPrcsPriv.trim();
    }

    public String getUserFilterPrcsPrivOther() {
        return userFilterPrcsPrivOther == null ? "" : userFilterPrcsPrivOther.trim();
    }

    public void setUserFilterPrcsPrivOther(String userFilterPrcsPrivOther) {
        this.userFilterPrcsPrivOther = userFilterPrcsPrivOther == null ? null : userFilterPrcsPrivOther.trim();
    }

    public String getUserFilterPrcsDept() {
        return userFilterPrcsDept == null ? "" : userFilterPrcsDept.trim();
    }

    public void setUserFilterPrcsDept(String userFilterPrcsDept) {
        this.userFilterPrcsDept = userFilterPrcsDept == null ? null : userFilterPrcsDept.trim();
    }

    public String getUserFilterPrcsDeptOther() {
        return userFilterPrcsDeptOther == null ? "" : userFilterPrcsDept.trim();
    }

    public void setUserFilterPrcsDeptOther(String userFilterPrcsDeptOther) {
        this.userFilterPrcsDeptOther = userFilterPrcsDeptOther == null ? null : userFilterPrcsDeptOther.trim();
    }

    public String getMailTo() {
        return mailTo == null ? "" : mailTo.trim();
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailToDept() {
        return mailToDept == null ? "" : mailToDept.trim();
    }

    public void setMailToDept(String mailToDept) {
        this.mailToDept = mailToDept;
    }

    public String getMailToPriv() {
        return mailToPriv == null ? "" : mailToDept.trim();
    }

    public void setMailToPriv(String mailToPriv) {
        this.mailToPriv = mailToPriv;
    }

    public String getConditionDesc() {
        return conditionDesc == null ? "" : conditionDesc.trim();
    }

    public void setConditionDesc(String conditionDesc) {
        this.conditionDesc = conditionDesc;
    }

    public String getRelationIn() {
        return relationIn == null ? "" : relationIn.trim();
    }

    public void setRelationIn(String relationIn) {
        this.relationIn = relationIn;
    }

    public String getRelationOut() {
        return relationOut == null ? "" : relationOut.trim();
    }

    public void setRelationOut(String relationOut) {
        this.relationOut = relationOut;
    }

    public String getControlMode() {
        return controlMode == null ? "" : controlMode.trim();
    }

    public void setControlMode(String controlMode) {
        this.controlMode = controlMode == null ? null : controlMode.trim();
    }

    public String getListColumnPriv() {
        return listColumnPriv == null ? "" : listColumnPriv.trim();
    }

    public void setListColumnPriv(String listColumnPriv) {
        this.listColumnPriv = listColumnPriv == null ? null : listColumnPriv.trim();
    }

    public String getFileuploadPriv() {
        return fileuploadPriv == null ? "" : fileuploadPriv.trim();
    }

    public void setFileuploadPriv(String fileuploadPriv) {
        this.fileuploadPriv = fileuploadPriv == null ? null : fileuploadPriv.trim();
    }

    public String getImguploadPriv() {
        return imguploadPriv == null ? "" : imguploadPriv.trim();
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

//    public byte[] getPrcsType() {
//        return prcsType == null ? new byte[0] : prcsType;
//    }
//
//    public void setPrcsType(byte[] prcsType) {
//        this.prcsType = prcsType;
//    }


    public byte getPrcsType() {
        return prcsType == 0 ? 0 : prcsType;
    }

    public void setPrcsType(byte prcsType) {
        this.prcsType = prcsType;
    }

    public String getPrcsName() {
        return prcsName == null ? "" : prcsName.trim();
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
        return feedback == null ? "0" : feedback.trim();
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAutoType() {
        return autoType == null ? "" : autoType.trim();
    }

    public void setAutoType(String autoType) {
        this.autoType = autoType == null ? null : autoType.trim();
    }

    public String getUserFilter() {
        return userFilter == null ? "" : userFilter.trim();
    }

    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter == null ? null : userFilter.trim();
    }

    public String getTimeOut() {
        return timeOut == null ? "" : timeOut.trim();
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut == null ? null : timeOut.trim();
    }

    public String getTimeOutModify() {
        return timeOutModify == null ? "0" : timeOutModify.trim();
    }

    public void setTimeOutModify(String timeOutModify) {
        this.timeOutModify = timeOutModify == null ? null : timeOutModify.trim();
    }

    public String getTimeOutAttend() {
        return timeOutAttend == null ? "0" : timeOutAttend.trim();
    }

    public void setTimeOutAttend(String timeOutAttend) {
        this.timeOutAttend = timeOutAttend == null ? null : timeOutAttend.trim();
    }

    public String getSignlook() {
        return signlook == null ? "0" : signlook.trim();
    }

    public void setSignlook(String signlook) {
        this.signlook = signlook == null ? null : signlook.trim();
    }

    public String getTopDefault() {
        return topDefault == null ? "0" : topDefault.trim();
    }

    public void setTopDefault(String topDefault) {
        this.topDefault = topDefault == null ? null : topDefault.trim();
    }

    public String getUserLock() {
        return userLock == null ? "1" : userLock.trim();
    }

    public void setUserLock(String userLock) {
        this.userLock = userLock == null ? null : userLock.trim();
    }

    public String getSyncDeal() {
        return syncDeal == null ? "0" : syncDeal.trim();
    }

    public void setSyncDeal(String syncDeal) {
        this.syncDeal = syncDeal == null ? null : syncDeal.trim();
    }

    public String getSyncDealCheck() {
        return syncDealCheck == null ? "" : syncDealCheck.trim();
    }

    public void setSyncDealCheck(String syncDealCheck) {
        this.syncDealCheck = syncDealCheck;
    }

    public String getTurnPriv() {
        return turnPriv == null ? "1" : turnPriv.trim();
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
        return gatherNode == null ? "0" : gatherNode.trim();
    }

    public void setGatherNode(String gatherNode) {
        this.gatherNode = gatherNode == null ? null : gatherNode.trim();
    }

    public String getAllowBack() {
        return allowBack == null ? "0" : allowBack.trim();
    }

    public void setAllowBack(String allowBack) {
        this.allowBack = allowBack == null ? null : allowBack.trim();
    }

    public String getAttachPriv() {
        return attachPriv == null ? "" : attachPriv.trim();
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


    public Integer getDispAip() {
        return dispAip;
    }

    public void setDispAip(Integer dispAip) {
        this.dispAip = dispAip;
    }

    public String getTimeOutType() {
        return timeOutType == null ? "" : timeOutType.trim();
    }

    public void setTimeOutType(String timeOutType) {
        this.timeOutType = timeOutType == null ? null : timeOutType.trim();
    }

    public String getAttachEditPriv() {
        return attachEditPriv == null ? "" : attachEditPriv.trim();
    }

    public void setAttachEditPriv(String attachEditPriv) {
        this.attachEditPriv = attachEditPriv == null ? null : attachEditPriv.trim();
    }

    public String getAttachEditPrivOnline() {
        return attachEditPrivOnline == null ? "" : attachEditPrivOnline.trim();
    }

    public void setAttachEditPrivOnline(String attachEditPrivOnline) {
        this.attachEditPrivOnline = attachEditPrivOnline == null ? null : attachEditPrivOnline.trim();
    }

    public String getAttachMacroMark() {
        return attachMacroMark == null ? "" : attachMacroMark.trim();
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

    public String getWorkingdaysType() {
        return workingdaysType == null ? "" : workingdaysType.trim();
    }

    public int getRemindFlag() {
        return remindFlag;
    }

    public void setRemindFlag(int remindFlag) {
        this.remindFlag = remindFlag;
    }

    public void setWorkingdaysType(String workingdaysType) {
        this.workingdaysType = workingdaysType == null ? null : workingdaysType.trim();
    }

    /**
     * 返回页面参数
     * @return
     */
    public String getSetType() {
        return setType==null?"chat":setType.trim();
    }

    /**
     * 返回页面参数
     * @param setType
     */
    public void setSetType(String setType) {
        this.setType = setType;
    }

    /**
     * 关联创建工作流
     * @return
     */
    public FlowTypeModel getFlowTypeModel() {
        return flowTypeModel;
    }

    /**
     * 关联创建工作流
     * @param flowTypeModel
     */
    public void setFlowTypeModel(FlowTypeModel flowTypeModel) {
        this.flowTypeModel = flowTypeModel;
    }

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }

    public int getCountersign() {
        return countersign;
    }

    public void setCountersign(int countersign) {
        this.countersign = countersign;
    }

    public String getSettlementOfCondition() {
        return settlementOfCondition;
    }

    public void setSettlementOfCondition(String settlementOfCondition) {
        this.settlementOfCondition = settlementOfCondition;
    }

    /**
     * 可写字段如果有值转为autoUser
     * @return
     */
    public String getITEM_ID() {
        return ITEM_ID;
    }

    /**
     * 可写字段如果有值转为autoUser
     * @param ITEM_ID
     */
    public void setITEM_ID(String ITEM_ID) {
        this.ITEM_ID = ITEM_ID;
    }

    /**
     * 可写字段如果有值转为autoUser
     * @return
     */
    public String getAUTO_PRCS_USER() {
        return AUTO_PRCS_USER;
    }

    /**
     * 可写字段如果有值转为autoUser
     * @param AUTO_PRCS_USER
     */
    public void setAUTO_PRCS_USER(String AUTO_PRCS_USER) {
        this.AUTO_PRCS_USER = AUTO_PRCS_USER;
    }

    /**
     * 可写字段Json串
     * @return
     */
    public String getPrcsItemTwo() {
        return prcsItemTwo;
    }

    /**
     * 可写字段Json串
     * @param prcsItemTwo
     */
    public void setPrcsItemTwo(String prcsItemTwo) {
        this.prcsItemTwo = prcsItemTwo;
    }
}