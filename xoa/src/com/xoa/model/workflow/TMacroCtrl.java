package com.xoa.model.workflow;

import com.xoa.model.department.Department;
import com.xoa.model.users.UserPriv;
import com.xoa.model.users.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsb on 2017/5/24.
 */
public class TMacroCtrl {

    private String controlId="Macro";
    private String SYS_USERID;//当前用户ID
    private String SYS_USERNAME;//当前用户姓名
    private String SYS_DEPTNAME;//当前用户部门(长名称)
    private String SYS_DEPTNAME_SHORT;//当前用户部门(短名称)
    private String SYS_USERPRIV;//当前用户角色
    private String SYS_USERPRIVOTHER;//当前用户辅助角色
    private String SYS_USERNAME_DATE;//当前用户姓名+日期
    private String SYS_USERNAME_DATETIME;//当前用户姓名+日期+时间
    private String SYS_FORMNAME;//表单名称
    private String SYS_RUNNAME;//工作名称/文号
    private String SYS_RUNDATE;//流程开始日期
    private String SYS_RUNDATETIME;//流程开始日期+时间
    private String SYS_RUNID;//流水号
    private String SYS_AUTONUM;//文号计数器
    private String SYS_AUTONUM_YEAR;//文号计数器(按年编号)
    private String SYS_AUTONUM_MONTH;//文号计数器(按月编号)
    private String SYS_IP;//经办人IP地址
    private String SYS_MANAGER1;//部门主管(本部门)
    private String SYS_MANAGER2;//部门主管(上级部门)
    private String SYS_MANAGER3;//部门主管(一级部门)
    private String SYS_SQL;//来自SQL查询语句
    //0=||>>>>>>>>>>>>>>>>>
    private List<Department>  SYS_LIST_DEPT=new ArrayList<>();//部门列表
    private List<Users>  SYS_LIST_USER=new ArrayList<>();//人员列表
    private List<UserPriv> SYS_LIST_PRIV=new ArrayList<>();//角色列表
    private List<UserPriv>  SYS_LIST_PRIV_ONLY=new ArrayList<>();//主角色列表
    private List<UserPriv>  SYS_LIST_PRIV_OTHER=new ArrayList<>();//辅助角色列表
    /*private List<UserPriv>  SYS_LIST_PRCSUSER1=new ArrayList<>();//流程设置所有经办人列表
    private List<UserPriv>  SYS_LIST_PRCSUSER2=new ArrayList<>();//本步骤设置经办人列表*/
    private List<Department>  SYS_LIST_MANAGER1=new ArrayList<>();//部门主管(本部门)
    private List<Department>  SYS_LIST_MANAGER2=new ArrayList<>();//部门主管(上级部门)
    private List<Department>  SYS_LIST_MANAGER3=new ArrayList<>();//部门主管(一级部门)

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getSYS_USERID() {
        return SYS_USERID;
    }

    public void setSYS_USERID(String SYS_USERID) {
        this.SYS_USERID = SYS_USERID;
    }

    public String getSYS_USERNAME() {
        return SYS_USERNAME;
    }

    public void setSYS_USERNAME(String SYS_USERNAME) {
        this.SYS_USERNAME = SYS_USERNAME;
    }

    public String getSYS_DEPTNAME() {
        return SYS_DEPTNAME;
    }

    public void setSYS_DEPTNAME(String SYS_DEPTNAME) {
        this.SYS_DEPTNAME = SYS_DEPTNAME;
    }

    public String getSYS_DEPTNAME_SHORT() {
        return SYS_DEPTNAME_SHORT;
    }

    public void setSYS_DEPTNAME_SHORT(String SYS_DEPTNAME_SHORT) {
        this.SYS_DEPTNAME_SHORT = SYS_DEPTNAME_SHORT;
    }

    public String getSYS_USERPRIV() {
        return SYS_USERPRIV;
    }

    public void setSYS_USERPRIV(String SYS_USERPRIV) {
        this.SYS_USERPRIV = SYS_USERPRIV;
    }

    public String getSYS_USERPRIVOTHER() {
        return SYS_USERPRIVOTHER;
    }

    public void setSYS_USERPRIVOTHER(String SYS_USERPRIVOTHER) {
        this.SYS_USERPRIVOTHER = SYS_USERPRIVOTHER;
    }

    public String getSYS_USERNAME_DATE() {
        return SYS_USERNAME_DATE;
    }

    public void setSYS_USERNAME_DATE(String SYS_USERNAME_DATE) {
        this.SYS_USERNAME_DATE = SYS_USERNAME_DATE;
    }

    public String getSYS_USERNAME_DATETIME() {
        return SYS_USERNAME_DATETIME;
    }

    public void setSYS_USERNAME_DATETIME(String SYS_USERNAME_DATETIME) {
        this.SYS_USERNAME_DATETIME = SYS_USERNAME_DATETIME;
    }

    public String getSYS_FORMNAME() {
        return SYS_FORMNAME;
    }

    public void setSYS_FORMNAME(String SYS_FORMNAME) {
        this.SYS_FORMNAME = SYS_FORMNAME;
    }

    public String getSYS_RUNNAME() {
        return SYS_RUNNAME;
    }

    public void setSYS_RUNNAME(String SYS_RUNNAME) {
        this.SYS_RUNNAME = SYS_RUNNAME;
    }

    public String getSYS_RUNDATE() {
        return SYS_RUNDATE;
    }

    public void setSYS_RUNDATE(String SYS_RUNDATE) {
        this.SYS_RUNDATE = SYS_RUNDATE;
    }

    public String getSYS_RUNDATETIME() {
        return SYS_RUNDATETIME;
    }

    public void setSYS_RUNDATETIME(String SYS_RUNDATETIME) {
        this.SYS_RUNDATETIME = SYS_RUNDATETIME;
    }

    public String getSYS_RUNID() {
        return SYS_RUNID;
    }

    public void setSYS_RUNID(String SYS_RUNID) {
        this.SYS_RUNID = SYS_RUNID;
    }

    public String getSYS_AUTONUM() {
        return SYS_AUTONUM;
    }

    public void setSYS_AUTONUM(String SYS_AUTONUM) {
        this.SYS_AUTONUM = SYS_AUTONUM;
    }

    public String getSYS_AUTONUM_YEAR() {
        return SYS_AUTONUM_YEAR;
    }

    public void setSYS_AUTONUM_YEAR(String SYS_AUTONUM_YEAR) {
        this.SYS_AUTONUM_YEAR = SYS_AUTONUM_YEAR;
    }

    public String getSYS_AUTONUM_MONTH() {
        return SYS_AUTONUM_MONTH;
    }

    public void setSYS_AUTONUM_MONTH(String SYS_AUTONUM_MONTH) {
        this.SYS_AUTONUM_MONTH = SYS_AUTONUM_MONTH;
    }

    public String getSYS_IP() {
        return SYS_IP;
    }

    public void setSYS_IP(String SYS_IP) {
        this.SYS_IP = SYS_IP;
    }

    public String getSYS_MANAGER1() {
        return SYS_MANAGER1;
    }

    public void setSYS_MANAGER1(String SYS_MANAGER1) {
        this.SYS_MANAGER1 = SYS_MANAGER1;
    }

    public String getSYS_MANAGER2() {
        return SYS_MANAGER2;
    }

    public void setSYS_MANAGER2(String SYS_MANAGER2) {
        this.SYS_MANAGER2 = SYS_MANAGER2;
    }

    public String getSYS_MANAGER3() {
        return SYS_MANAGER3;
    }

    public void setSYS_MANAGER3(String SYS_MANAGER3) {
        this.SYS_MANAGER3 = SYS_MANAGER3;
    }

    public String getSYS_SQL() {
        return SYS_SQL;
    }

    public void setSYS_SQL(String SYS_SQL) {
        this.SYS_SQL = SYS_SQL;
    }

    public List<Department> getSYS_LIST_DEPT() {
        return SYS_LIST_DEPT;
    }

    public void setSYS_LIST_DEPT(List<Department> SYS_LIST_DEPT) {
        this.SYS_LIST_DEPT = SYS_LIST_DEPT;
    }

    public List<Users> getSYS_LIST_USER() {
        return SYS_LIST_USER;
    }

    public void setSYS_LIST_USER(List<Users> SYS_LIST_USER) {
        this.SYS_LIST_USER = SYS_LIST_USER;
    }

    public List<UserPriv> getSYS_LIST_PRIV() {
        return SYS_LIST_PRIV;
    }

    public void setSYS_LIST_PRIV(List<UserPriv> SYS_LIST_PRIV) {
        this.SYS_LIST_PRIV = SYS_LIST_PRIV;
    }

    public List<UserPriv> getSYS_LIST_PRIV_ONLY() {
        return SYS_LIST_PRIV_ONLY;
    }

    public void setSYS_LIST_PRIV_ONLY(List<UserPriv> SYS_LIST_PRIV_ONLY) {
        this.SYS_LIST_PRIV_ONLY = SYS_LIST_PRIV_ONLY;
    }

    public List<UserPriv> getSYS_LIST_PRIV_OTHER() {
        return SYS_LIST_PRIV_OTHER;
    }

    public void setSYS_LIST_PRIV_OTHER(List<UserPriv> SYS_LIST_PRIV_OTHER) {
        this.SYS_LIST_PRIV_OTHER = SYS_LIST_PRIV_OTHER;
    }

    public List<Department> getSYS_LIST_MANAGER1() {
        return SYS_LIST_MANAGER1;
    }

    public void setSYS_LIST_MANAGER1(List<Department> SYS_LIST_MANAGER1) {
        this.SYS_LIST_MANAGER1 = SYS_LIST_MANAGER1;
    }

    public List<Department> getSYS_LIST_MANAGER2() {
        return SYS_LIST_MANAGER2;
    }

    public void setSYS_LIST_MANAGER2(List<Department> SYS_LIST_MANAGER2) {
        this.SYS_LIST_MANAGER2 = SYS_LIST_MANAGER2;
    }

    public List<Department> getSYS_LIST_MANAGER3() {
        return SYS_LIST_MANAGER3;
    }

    public void setSYS_LIST_MANAGER3(List<Department> SYS_LIST_MANAGER3) {
        this.SYS_LIST_MANAGER3 = SYS_LIST_MANAGER3;
    }
}
