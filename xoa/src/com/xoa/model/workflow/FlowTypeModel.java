package com.xoa.model.workflow;

import com.xoa.util.DateFormat;

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
     *  部门名称
     */
    private String depName;

    public String getDepName() {
        if(depName==null){
            depName="全部部门";
        }
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:32:35
     * 方法介绍:   主键ID
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getFlowId() {
        return flowId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:32:47
     * 方法介绍:   主键ID
     * 参数说明:   @param flowId
     * @return     void
     */
    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:32:58
     * 方法介绍:   流程名称
     * 参数说明:   @return
     * @return     String
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:33:17
     * 方法介绍:   流程名称
     * 参数说明:   @param flowName
     * @return     void
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? "": flowName.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:33:21
     * 方法介绍:   表单ID
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getFormId() {
        return formId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:33:40
     * 方法介绍:   表单ID
     * 参数说明:   @param formId
     * @return     void
     */
    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:33:44
     * 方法介绍:   是否允许附件(0-否,1-是)
     * 参数说明:   @return
     * @return     String
     */
    public String getFlowDoc() {
        return flowDoc;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:34:16
     * 方法介绍:   是否允许附件(0-否,1-是)
     * 参数说明:   @param flowDoc
     * @return     void
     */
    public void setFlowDoc(String flowDoc) {
        this.flowDoc = flowDoc == null ? "1" : flowDoc.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:34:24
     * 方法介绍:   流程类型(1-固定流程,2-自由流程)
     * 参数说明:   @return
     * @return     String
     */
    public String getFlowType() {
        return flowType;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:34:30
     * 方法介绍:   流程类型(1-固定流程,2-自由流程)
     * 参数说明:   @param flowType
     * @return     void
     */
    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:34:38
     * 方法介绍:   流程排序号
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getFlowNo() {
        return flowNo;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:34:44
     * 方法介绍:   流程排序号
     * 参数说明:   @param flowNo
     * @return     void
     */
    public void setFlowNo(Integer flowNo) {
        this.flowNo = flowNo == 0 ? 1:flowNo;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:34:50
     * 方法介绍:   流程分类ID
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getFlowSort() {
        return flowSort;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:34:55
     * 方法介绍:   流程分类ID
     * 参数说明:   @param flowSort
     * @return     void
     */
    public void setFlowSort(Integer flowSort) {
        this.flowSort = flowSort;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:35:02
     * 方法介绍:   自动编号计数器
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getAutoNum() {
        return autoNum;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:35:08
     * 方法介绍:   自动编号计数器
     * 参数说明:   @param autoNum
     * @return     void
     */
    public void setAutoNum(Integer autoNum) {
        this.autoNum = autoNum;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:35:16
     * 方法介绍:   自动编号显示长度
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getAutoLen() {
        return autoLen;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:35:24
     * 方法介绍:   自动编号显示长度
     * 参数说明:   @param autoLen
     * @return     void
     */
    public void setAutoLen(Integer autoLen) {
        this.autoLen = autoLen;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:35:38
     * 方法介绍:   新建工作时是否允许手工修改文号：
     * 			(0-不允许手工修改文号,1-允许手工修改文号, 2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 			4-允许在自动文号前后输入前缀和后缀,)
     * 参数说明:   @return
     * @return     String
     */
    public String getAutoEdit() {
        return autoEdit;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:35:58
     * 方法介绍:   新建工作时是否允许手工修改文号：
     * 			(0-不允许手工修改文号,1-允许手工修改文号, 2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 			4-允许在自动文号前后输入前缀和后缀,)
     * 参数说明:   @param autoEdit
     * @return     void
     */
    public void setAutoEdit(String autoEdit) {
        this.autoEdit = autoEdit == null ? "1" : autoEdit.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:36:09
     * 方法介绍:   点评权限-已废弃
     * 参数说明:   @return
     * @return     String
     */
    public String getCommentPriv() {
        return commentPriv;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:36:16
     * 方法介绍:   点评权限-已废弃
     * 参数说明:   @param commentPriv
     * @return     void
     */
    public void setCommentPriv(String commentPriv) {
        this.commentPriv = commentPriv == null ? "3" : commentPriv.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:36:25
     * 方法介绍:   所属部门ID
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:36:35
     * 方法介绍:   所属部门ID
     * 参数说明:   @param deptId
     * @return     void
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId == 0 ? 1:deptId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:36:42
     * 方法介绍:   是否允许预设步骤(0-否,1-是)
     * 参数说明:   @return
     * @return     String
     */
    public String getFreePreset() {
        return freePreset;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:36:47
     * 方法介绍:   是否允许预设步骤(0-否,1-是)
     * 参数说明:   @param freePreset
     * @return     void
     */
    public void setFreePreset(String freePreset) {
        this.freePreset = freePreset == null ? "1" : freePreset.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:37:03
     * 方法介绍:   委托类型(0-禁止委托,1-仅允许委托当前步骤经办人
     * 			(本步骤实际的经办人，该步骤可能定义了五个人，
     * 			但是转交时选择了三个),2-自由委托,
     * 			3-按步骤设置的经办权限委托(跟1的区别是按照定义的经办人来委托))
     * 参数说明:   @return
     * @return     String
     */
    public String getFreeOther() {
        return freeOther;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:37:19
     * 方法介绍:   委托类型(0-禁止委托,1-仅允许委托当前步骤经办人
     * 			(本步骤实际的经办人，该步骤可能定义了五个人，
     * 			但是转交时选择了三个),2-自由委托,
     * 			3-按步骤设置的经办权限委托(跟1的区别是按照定义的经办人来委托))
     * 参数说明:   @param freeOther
     * @return     void
     */
    public void setFreeOther(String freeOther) {
        this.freeOther = freeOther == null ? "2" : freeOther.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:37:32
     * 方法介绍:   待定 '0'
     * 参数说明:   @return
     * @return     String
     */
    public String getAllowPreSet() {
        return allowPreSet;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:37:37
     * 方法介绍:   待定 '0'
     * 参数说明:   @param allowPreSet
     * @return     void
     */
    public void setAllowPreSet(String allowPreSet) {
        this.allowPreSet = allowPreSet == null ? "0" : allowPreSet.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:37:57
     * 方法介绍:   是否强制修改文号(1-是,其他-否),
     * 			新建工作时是否允许手工修改文号为
     * 			(2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 			4-允许在自动文号前后输入前缀和后缀,时可设置该选项)
     * 参数说明:   @return
     * @return     String
     */
    public String getForcePreSet() {
        return forcePreSet;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:38:13
     * 方法介绍:   是否强制修改文号(1-是,其他-否),
     * 			新建工作时是否允许手工修改文号为
     * 			(2-允许在自动文号前输入前缀,3-允许在自动文号后输入后缀,
     * 			4-允许在自动文号前后输入前缀和后缀,时可设置该选项)
     * 参数说明:   @param forcePreSet
     * @return     void
     */
    public void setForcePreSet(String forcePreSet) {
        this.forcePreSet = forcePreSet == null ? "0" : forcePreSet.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:38:31
     * 方法介绍:   允许传阅(0-不允许,1-允许)
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getViewPriv() {
        return viewPriv;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:38:40
     * 方法介绍:   允许传阅(0-不允许,1-允许)
     * 参数说明:   @param viewPriv
     * @return     void
     */
    public void setViewPriv(Integer viewPriv) {
        this.viewPriv = viewPriv;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:38:48
     * 方法介绍:   是否启用版本控制(0-否,1-是)
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getIsVersion() {
        return isVersion;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:38:56
     * 方法介绍:   是否启用版本控制(0-否,1-是)
     * 参数说明:   @param isVersion
     * @return     void
     */
    public void setIsVersion(Integer isVersion) {
        this.isVersion = isVersion;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:39:02
     * 方法介绍:   更多选项(1公告通知,2内部邮件,3转存,4归档)
     * 参数说明:   @return
     * @return     String
     */
    public String getFlowAction() {
        return flowAction;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:39:07
     * 方法介绍:   更多选项(1公告通知,2内部邮件,3转存,4归档)
     * 参数说明:   @param flowAction
     * @return     void
     */
    public void setFlowAction(String flowAction) {
        this.flowAction = flowAction == null ? null : flowAction.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:39:14
     * 方法介绍:   自动编号计数器年刷新
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getAutoNumYear() {
        return autoNumYear;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:39:19
     * 方法介绍:   自动编号计数器年刷新
     * 参数说明:   @param autoNumYear
     * @return     void
     */
    public void setAutoNumYear(Integer autoNumYear) {
        this.autoNumYear = autoNumYear;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:39:36
     * 方法介绍:   自动编号计数器月刷新
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getAutoNumMonth() {
        return autoNumMonth;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:39:41
     * 方法介绍:   自动编号计数器月刷新
     * 参数说明:   @param autoNumMonth
     * @return     void
     */
    public void setAutoNumMonth(Integer autoNumMonth) {
        this.autoNumMonth = autoNumMonth;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:40:09
     * 方法介绍:   年月编号刷新标记
     * 参数说明:   @return
     * @return     Date
     */
    public Date getAutoNumTime() {
        return autoNumTime;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:40:16
     * 方法介绍:   年月编号刷新标记
     * 参数说明:   @param autoNumTime
     * @return     void
     */
    public void setAutoNumTime(Date autoNumTime) {
        this.autoNumTime = autoNumTime == null ? DateFormat.getDate("0000-00-00 00:00:00"):autoNumTime;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:40:25
     * 方法介绍:   管理与监控权限[全局]-已废弃
     * 参数说明:   @return
     * @return     String
     */
    public String getManageUser() {
        return manageUser;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:40:37
     * 方法介绍:   管理与监控权限[全局]-已废弃
     * 参数说明:   @param manageUser
     * @return     void
     */
    public void setManageUser(String manageUser) {
        this.manageUser = manageUser == null ? "" : manageUser.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:41:05
     * 方法介绍:   自动文号表达式
     * 参数说明:   @return
     * @return     String
     */
    public String getAutoName() {
        return autoName;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:41:21
     * 方法介绍:   自动文号表达式
     * 参数说明:   @param autoName
     * @return     void
     */
    public void setAutoName(String autoName) {
        this.autoName = autoName == null ? "" : autoName.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:45:06
     * 方法介绍:   查询权限[全局]-已废弃
     * 参数说明:   @return
     * @return     String
     */
    public String getQueryUser() {
        return queryUser;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:45:34
     * 方法介绍:   查询权限[全局]-已废弃
     * 参数说明:   @param queryUser
     * @return     void
     */
    public void setQueryUser(String queryUser) {
        this.queryUser = queryUser == null ? "" : queryUser.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:46:01
     * 方法介绍:   查询权限[全局]-已废弃
     * 参数说明:   @return
     * @return     String
     */
    public String getFlowDesc() {
        return flowDesc;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:46:10
     * 方法介绍:   查询权限[全局]-已废弃
     * 参数说明:   @param flowDesc
     * @return     void
     */
    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc == null ? "" : flowDesc.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:46:21
     * 方法介绍:   自由流程新建权限：分为按用户、按部门、
     * 			按角色三种授权方式,形成“用户ID串|部门ID串|角色ID串”
     * 			格式的字符串,其中用户ID串、部门ID串和角色ID串均是逗号分隔的字符串,
     * 参数说明:   @return
     * @return     String
     */
    public String getNewUser() {
        return newUser;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:46:37
     * 方法介绍:   自由流程新建权限：分为按用户、按部门、
     * 			按角色三种授权方式,形成“用户ID串|部门ID串|角色ID串”
     * 			格式的字符串,其中用户ID串、部门ID串和角色ID串均是逗号分隔的字符串,
     * 参数说明:   @param newUser
     * @return     void
     */
    public void setNewUser(String newUser) {
        this.newUser = newUser == null ? "" : newUser.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:46:48
     * 方法介绍:   查询字段串
     * 参数说明:   @return
     * @return     String
     */
    public String getQueryItem() {
        return queryItem;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:46:57
     * 方法介绍:   查询字段串
     * 参数说明:   @param queryItem
     * @return     void
     */
    public void setQueryItem(String queryItem) {
        this.queryItem = queryItem == null ? "" : queryItem.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:47:06
     * 方法介绍:   本部门发起查询权限-已废弃
     * 参数说明:   @return
     * @return     String
     */
    public String getQueryUserDept() {
        return queryUserDept;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:48:01
     * 方法介绍:   本部门发起查询权限-已废弃
     * 参数说明:   @param queryUserDept
     * @return     void
     */
    public void setQueryUserDept(String queryUserDept) {
        this.queryUserDept = queryUserDept == null ? "" : queryUserDept.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:48:09
     * 方法介绍:   本部门发起查询权限-已废弃
     * 参数说明:   @return
     * @return     String
     */
    public String getManageUserDept() {
        return manageUserDept;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:48:20
     * 方法介绍:   本部门管理与监控权限-已废弃
     * 参数说明:   @param manageUserDept
     * @return     void
     */
    public void setManageUserDept(String manageUserDept) {
        this.manageUserDept = manageUserDept == null ? "" : manageUserDept.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:48:36
     * 方法介绍:   编辑权限-已废弃
     * 参数说明:   @return
     * @return     String
     */
    public String getEditPriv() {
        return editPriv;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:48:44
     * 方法介绍:   编辑权限-已废弃
     * 参数说明:   @param editPriv
     * @return     void
     */
    public void setEditPriv(String editPriv) {
        this.editPriv = editPriv == null ? "" : editPriv.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:48:57
     * 方法介绍:   列表扩展字段串查询页面仅查询该流程时生效
     * 参数说明:   @return
     * @return     String
     */
    public String getListFldsStr() {
        return listFldsStr;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:49:02
     * 方法介绍:   列表扩展字段串查询页面仅查询该流程时生效
     * 参数说明:   @param listFldsStr
     * @return     void
     */
    public void setListFldsStr(String listFldsStr) {
        this.listFldsStr = listFldsStr == null ? "" : listFldsStr.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:49:11
     * 方法介绍:   流程对应模块ID
     * 参数说明:   @return
     * @return     String
     */
    public String getModelId() {
        return modelId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:49:16
     * 方法介绍:   流程对应模块ID
     * 参数说明:   @param modelId
     * @return     void
     */
    public void setModelId(String modelId) {
        this.modelId = modelId == null ? "" : modelId.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:49:26
     * 方法介绍:   流程对应模块名称
     * 参数说明:   @return
     * @return     String
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:50:03
     * 方法介绍:   流程对应模块名称
     * 参数说明:   @param modelName
     * @return     void
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? "" : modelName.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:50:15
     * 方法介绍:   说明文档附件ID串
     * 参数说明:   @return
     * @return     String
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:50:25
     * 方法介绍:   说明文档附件ID串
     * 参数说明:   @param attachmentId
     * @return     void
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? "" : attachmentId.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:50:38
     * 方法介绍:   说明文档附件名称串
     * 参数说明:   @return
     * @return     String
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:50:44
     * 方法介绍:   说明文档附件名称串
     * 参数说明:   @param attachmentName
     * @return     void
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? "" : attachmentName.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:50:56
     * 方法介绍:   传阅人ID串
     * 参数说明:   @return
     * @return     String
     */
    public String getViewUser() {
        return viewUser;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:54:25
     * 方法介绍:   传阅人ID串
     * 参数说明:   @param viewUser
     * @return     void
     */
    public void setViewUser(String viewUser) {
        this.viewUser = viewUser == null ? "" : viewUser.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:54:52
     * 方法介绍:   传阅部门ID串
     * 参数说明:   @return
     * @return     String
     */
    public String getViewDept() {
        return viewDept;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:55:01
     * 方法介绍:   传阅部门ID串
     * 参数说明:   @param viewDept
     * @return     void
     */
    public void setViewDept(String viewDept) {
        this.viewDept = viewDept == null ? "" : viewDept.trim();
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:55:40
     * 方法介绍:   传阅角色ID串
     * 参数说明:   @return
     * @return     String
     */
    public String getViewRole() {
        return viewRole;
    }

    /**
     *
     * 创建作者:   张勇
     * 创建日期:   2017-5-5 下午3:55:46
     * 方法介绍:   传阅角色ID串
     * 参数说明:   @param viewRole
     * @return     void
     */
    public void setViewRole(String viewRole) {
        this.viewRole = viewRole == null ? "" : viewRole.trim();
    }
}