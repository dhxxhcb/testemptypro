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

    /**
     * 主键ID
     */
	private Integer flowId;

    /**
     * 流程名称
     */
    private String flowName;

    /**
     * 表单ID
     */
    private Integer formId;

    /**
     * 是否允许附件(0-否,1-是)
     */
    private String flowDoc;

    /**
     * 流程类型(1-固定流程,2-自由流程)
     */
    private String flowType;

    /**
     * 流程排序号
     */
    private Integer flowNo;

    /**
     * 流程分类ID
     */
    private Integer flowSort;

    /**
     * 自动编号计数器
     */
    private Integer autoNum;

    /**
     * 自动编号显示长度
     */
    private Integer autoLen;

    /**
     * 新建工作时是否允许手工修改文号：
     * (0-不允许手工修改文号,1-允许手工修改文号,
     *  2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     *  4-允许在自动文号前后输入前缀和后缀,)
     */
    private String autoEdit;

    /**
     * 点评权限-已废弃
     */
    private String commentPriv;

    /**
     * 所属部门ID
     */
    private Integer deptId;

    /**
     * 是否允许预设步骤(0-否,1-是)
     */
    private String freePreset;

    /**
     * 委托类型(0-禁止委托,1-仅允许委托当前步骤经办人
     * (本步骤实际的经办人，该步骤可能定义了五个人，
     * 但是转交时选择了三个),2-自由委托,
     * 3-按步骤设置的经办权限委托(跟1的区别是按照定义的经办人来委托))
     */
    private String freeOther;

    /**
     * 待定 '0'
     */
    private String allowPreSet;

    /**
     * 是否强制修改文号(1-是,其他-否),
     * 新建工作时是否允许手工修改文号为
     * (2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 4-允许在自动文号前后输入前缀和后缀,时可设置该选项)
     */
    private String forcePreSet;

    /**
     * 允许传阅(0-不允许,1-允许)
     */
    private Integer viewPriv;

    /**
     * 是否启用版本控制(0-否,1-是)
     */
    private Integer isVersion;

    /**
     * 更多选项(1公告通知,2内部邮件,3转存,4归档)
     */
    private String flowAction;

    /**
     * 自动编号计数器年刷新
     */
    private Integer autoNumYear;

    /**
     * 自动编号计数器月刷新
     */
    private Integer autoNumMonth;

    /**
     * 年月编号刷新标记
     */
    private Date autoNumTime;

    /**
     * 管理与监控权限[全局]-已废弃
     */
    private String manageUser;

    /**
     * 自动文号表达式
     */
    private String autoName;

    /**
     * 查询权限[全局]-已废弃
     */
    private String queryUser;

    /**
     * 流程说明
     */
    private String flowDesc;

    /**
     * 自由流程新建权限：分为按用户、按部门、
     * 按角色三种授权方式,形成“用户ID串|部门ID串|角色ID串”
     * 格式的字符串,其中用户ID串、部门ID串和角色ID串均是逗号分隔的字符串,
     */
    private String newUser;

    /**
     * 查询字段串
     */
    private String queryItem;

    /**
     * 本部门发起查询权限-已废弃
     */
    private String queryUserDept;

    /**
     * 本部门管理与监控权限-已废弃
     */
    private String manageUserDept;

    /**
     * 编辑权限-已废弃
     */
    private String editPriv;

    /**
     * 列表扩展字段串查询页面仅查询该流程时生效
     */
    private String listFldsStr;

    /**
     * 流程对应模块ID
     */
    private String modelId;

    /**
     * 流程对应模块名称
     */
    private String modelName;

    /**
     * 说明文档附件ID串
     */
    private String attachmentId;

    /**
     * 说明文档附件名称串
     */
    private String attachmentName;

    /**
     * 传阅人ID串
     */
    private String viewUser;

    /**
     * 传阅部门ID串
     */
    private String viewDept;

    /**
     * 传阅角色ID串
     */
    private String viewRole;


    /**
     * 主键ID
     * @return
     */
    public Integer getFlowId() {
        return flowId;
    }

    /**
     * 主键ID
     * @param flowId
     */
    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    /**
     * 流程名称
     * @return
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * 流程名称
     * @param flowName
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    /**
     * 表单ID
     * @return
     */
    public Integer getFormId() {
        return formId;
    }

    /**
     * 表单ID
     * @param formId
     */
    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    /**
     * 是否允许附件(0-否,1-是)
     * @return
     */
    public String getFlowDoc() {
        return flowDoc;
    }

    /**
     * 是否允许附件(0-否,1-是)
     * @param flowDoc
     */
    public void setFlowDoc(String flowDoc) {
        this.flowDoc = flowDoc == null ? null : flowDoc.trim();
    }

    /**
     * 流程类型(1-固定流程,2-自由流程)
     * @return
     */
    public String getFlowType() {
        return flowType;
    }

    /**
     * 流程类型(1-固定流程,2-自由流程)
     * @param flowType
     */
    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    /**
     * 流程排序号
     * @return
     */
    public Integer getFlowNo() {
        return flowNo;
    }

    /**
     * 流程排序号
     * @param flowNo
     */
    public void setFlowNo(Integer flowNo) {
        this.flowNo = flowNo;
    }

    /**
     * 流程分类ID
     * @return
     */
    public Integer getFlowSort() {
        return flowSort;
    }

    /**
     * 流程分类ID
     * @param flowSort
     */
    public void setFlowSort(Integer flowSort) {
        this.flowSort = flowSort;
    }

    /**
     * 自动编号计数器
     * @return
     */
    public Integer getAutoNum() {
        return autoNum;
    }

    /**
     * 自动编号计数器
     * @param autoNum
     */
    public void setAutoNum(Integer autoNum) {
        this.autoNum = autoNum;
    }

    /**
     * 自动编号显示长度
     * @return
     */
    public Integer getAutoLen() {
        return autoLen;
    }

    /**
     * 自动编号显示长度
     * @param autoLen
     */
    public void setAutoLen(Integer autoLen) {
        this.autoLen = autoLen;
    }

    /**
     * 新建工作时是否允许手工修改文号：
     * (0-不允许手工修改文号,1-允许手工修改文号, 2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 4-允许在自动文号前后输入前缀和后缀,)
     * @return
     */
    public String getAutoEdit() {
        return autoEdit;
    }

    /**
     * 新建工作时是否允许手工修改文号：
     * (0-不允许手工修改文号,1-允许手工修改文号, 2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 4-允许在自动文号前后输入前缀和后缀,)
     * @param autoEdit
     */
    public void setAutoEdit(String autoEdit) {
        this.autoEdit = autoEdit == null ? null : autoEdit.trim();
    }

    /**
     * 点评权限-已废弃
     * @return
     */
    public String getCommentPriv() {
        return commentPriv;
    }

    /**
     * 点评权限-已废弃
     * @param commentPriv
     */
    public void setCommentPriv(String commentPriv) {
        this.commentPriv = commentPriv == null ? null : commentPriv.trim();
    }

    /**
     * 所属部门ID
     * @return
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 所属部门ID
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 是否允许预设步骤(0-否,1-是)
     * @return
     */
    public String getFreePreset() {
        return freePreset;
    }

    /**
     * 是否允许预设步骤(0-否,1-是)
     * @param freePreset
     */
    public void setFreePreset(String freePreset) {
        this.freePreset = freePreset == null ? null : freePreset.trim();
    }

    /**
     * 委托类型(0-禁止委托,1-仅允许委托当前步骤经办人
     * (本步骤实际的经办人，该步骤可能定义了五个人，
     * 但是转交时选择了三个),2-自由委托,
     * 3-按步骤设置的经办权限委托(跟1的区别是按照定义的经办人来委托))
     * @return
     */
    public String getFreeOther() {
        return freeOther;
    }

    /**
     * 委托类型(0-禁止委托,1-仅允许委托当前步骤经办人
     * (本步骤实际的经办人，该步骤可能定义了五个人，
     * 但是转交时选择了三个),2-自由委托,
     * 3-按步骤设置的经办权限委托(跟1的区别是按照定义的经办人来委托))
     * @param freeOther
     */
    public void setFreeOther(String freeOther) {
        this.freeOther = freeOther == null ? null : freeOther.trim();
    }

    /**
     * 待定 '0'
     * @return
     */
    public String getAllowPreSet() {
        return allowPreSet;
    }

    /**
     * 待定 '0'
     * @param allowPreSet
     */
    public void setAllowPreSet(String allowPreSet) {
        this.allowPreSet = allowPreSet == null ? null : allowPreSet.trim();
    }

    /**
     * 是否强制修改文号(1-是,其他-否),
     * 新建工作时是否允许手工修改文号为
     * (2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 4-允许在自动文号前后输入前缀和后缀,时可设置该选项)
     * @return
     */
    public String getForcePreSet() {
        return forcePreSet;
    }

    /**
     * 是否强制修改文号(1-是,其他-否),
     * 新建工作时是否允许手工修改文号为
     * (2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 4-允许在自动文号前后输入前缀和后缀,时可设置该选项)
     * @param forcePreSet
     */
    public void setForcePreSet(String forcePreSet) {
        this.forcePreSet = forcePreSet == null ? null : forcePreSet.trim();
    }

    /**
     * 允许传阅(0-不允许,1-允许)
     * @return
     */
    public Integer getViewPriv() {
        return viewPriv;
    }

    /**
     * 允许传阅(0-不允许,1-允许)
     * @param viewPriv
     */
    public void setViewPriv(Integer viewPriv) {
        this.viewPriv = viewPriv;
    }

    /**
     * 是否启用版本控制(0-否,1-是)
     * @return
     */
    public Integer getIsVersion() {
        return isVersion;
    }

    /**
     * 是否启用版本控制(0-否,1-是)
     * @param isVersion
     */
    public void setIsVersion(Integer isVersion) {
        this.isVersion = isVersion;
    }

    /**
     * 更多选项(1公告通知,2内部邮件,3转存,4归档)
     * @return
     */
    public String getFlowAction() {
        return flowAction;
    }

    /**
     * 更多选项(1公告通知,2内部邮件,3转存,4归档)
     * @param flowAction
     */
    public void setFlowAction(String flowAction) {
        this.flowAction = flowAction == null ? null : flowAction.trim();
    }

    /**
     * 自动编号计数器年刷新
     * @return
     */
    public Integer getAutoNumYear() {
        return autoNumYear;
    }

    /**
     * 自动编号计数器年刷新
     * @param autoNumYear
     */
    public void setAutoNumYear(Integer autoNumYear) {
        this.autoNumYear = autoNumYear;
    }

    /**
     * 自动编号计数器月刷新
     * @return
     */
    public Integer getAutoNumMonth() {
        return autoNumMonth;
    }

    /**
     * 自动编号计数器月刷新
     * @param autoNumMonth
     */
    public void setAutoNumMonth(Integer autoNumMonth) {
        this.autoNumMonth = autoNumMonth;
    }

    /**
     * 年月编号刷新标记
     * @return
     */
    public Date getAutoNumTime() {
        return autoNumTime;
    }

    /**
     * 年月编号刷新标记
     * @param autoNumTime
     */
    public void setAutoNumTime(Date autoNumTime) {
        this.autoNumTime = autoNumTime;
    }

    /**
     * 管理与监控权限[全局]-已废弃
     * @return
     */
    public String getManageUser() {
        return manageUser;
    }

    /**
     * 管理与监控权限[全局]-已废弃
     * @param manageUser
     */
    public void setManageUser(String manageUser) {
        this.manageUser = manageUser == null ? null : manageUser.trim();
    }

    /**
     * 自动文号表达式
     * @return
     */
    public String getAutoName() {
        return autoName;
    }

    /**
     * 自动文号表达式
     * @param autoName
     */
    public void setAutoName(String autoName) {
        this.autoName = autoName == null ? null : autoName.trim();
    }

    /**
     * 查询权限[全局]-已废弃
     * @return
     */
    public String getQueryUser() {
        return queryUser;
    }

    /**
     * 查询权限[全局]-已废弃
     * @param queryUser
     */
    public void setQueryUser(String queryUser) {
        this.queryUser = queryUser == null ? null : queryUser.trim();
    }

    /**
     * 流程说明
     * @return
     */
    public String getFlowDesc() {
        return flowDesc;
    }

    /**
     * 流程说明
     * @param flowDesc
     */
    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc == null ? null : flowDesc.trim();
    }

    /**
     * 自由流程新建权限：分为按用户、按部门、
     * 按角色三种授权方式,形成“用户ID串|部门ID串|角色ID串”
     * 格式的字符串,其中用户ID串、部门ID串和角色ID串均是逗号分隔的字符串,
     * @return
     */
    public String getNewUser() {
        return newUser;
    }

    /**
     * 自由流程新建权限：分为按用户、按部门、
     * 按角色三种授权方式,形成“用户ID串|部门ID串|角色ID串”
     * 格式的字符串,其中用户ID串、部门ID串和角色ID串均是逗号分隔的字符串,
     * @param newUser
     */
    public void setNewUser(String newUser) {
        this.newUser = newUser == null ? null : newUser.trim();
    }

    /**
     * 查询字段串
     * @return
     */
    public String getQueryItem() {
        return queryItem;
    }

    /**
     * 查询字段串
     * @param queryItem
     */
    public void setQueryItem(String queryItem) {
        this.queryItem = queryItem == null ? null : queryItem.trim();
    }

    /**
     * 本部门发起查询权限-已废弃
     * @return
     */
    public String getQueryUserDept() {
        return queryUserDept;
    }

    /**
     * 本部门发起查询权限-已废弃
     * @param queryUserDept
     */
    public void setQueryUserDept(String queryUserDept) {
        this.queryUserDept = queryUserDept == null ? null : queryUserDept.trim();
    }

    /**
     * 本部门管理与监控权限-已废弃
     * @return
     */
    public String getManageUserDept() {
        return manageUserDept;
    }

    /**
     * 本部门管理与监控权限-已废弃
     *  manageUserDept
     */
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