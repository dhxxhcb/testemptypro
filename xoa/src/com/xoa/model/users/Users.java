package com.xoa.model.users;

import java.util.Date;

import com.xoa.model.common.SysPara;
import com.xoa.model.department.Department;
import com.xoa.model.role.Role;

 /**
 * @ClassName (类名):  Users
 * @Description(简述): TODO
 * @author(作者):      wyq
 * @date(日期):        2017年4月17日 下午3:44:46
 *
 */
public class Users {
	
	/**
	 *唯一自增ID
	 */
	private Integer uid;
	/**
	 * 用户名
	 */
	private String userId;
	/**
	 * 用户真实姓名
	 */
	private String userName;
	/**
	 * 用户姓名索引
	 */
	private String userNameIndex;
	/**
	 * 登录名
	 */
	private String byname;
	/**
	 *使用USB KEY登录
	 */
	private String useingKey;
	/**
	 * 使用指纹验证
	 */
	private String usingFinger;
	/**
	 *用户密码
	 */
	private String password;
	/**
	 *绑定USB Key序列号
	 */
	private String keySn;
	/**
	 *动态密码卡号
	 */
	private String secureKeySn;
	/**
	 * 角色编号
	 */
	private Integer userPriv;
	/**
	 * 角色排序号
	 */
	private Short userPrivNo;
	/**
	 *角色名称
	 */
	private String userPrivName;
	/**
	 * 管理范围
	 */
	private String postPriv;
	/**
	 *管理范围指定部门
	 */
	private String postDept;
	/**
	 *部门ID
	 */
	private Integer deptId;
	/**
	 * 辅助部门
	 */
	private String deptIdOther;
	/**
	 *性别
	 */
	private String sex;
	/**
	 *生日
	 */
	private String birthday;
	/**
	 *是否农历(1-是,0-否)
	 */
	private String isLunar;
	/**
	 * 工作电话
	 */
	private String telNoDept;
	/**
	 * 工作传真
	 */
	private String faxNoDept;
	/**
	 *家庭住址
	 */
	private String addHome;
	/**
	 * 家庭邮编
	 */
	private String postNoHome;
	/**
	 *家庭电话
	 */
	private String telNoHome;
	/**
	 * 手机号
	 */
	private String mobilNo;
	/**
	 * BP机号
	 */
	private String bpNo;
	/**
	 * 电子邮件地址
	 */
	private String email;
	/**
	 *QQ号码
	 */
	private String oicqNo;
	/**
	 * ICQ号码
	 */
	private String icqNo;
	/**
	 * MSN号码
	 */
	private String msn;
	/**
	 * 自定义小头像
	 */
	private String avatar;
	/**
	 * 短信提示音
	 */
	private String callSound;
	/**
	 * 上次访问系统的时间
	 */
	private Date lastVisitTime;
	/**
	 * 短信提醒窗口弹出方式(1-自动,0-手动)
	 */
	private String smsOn;
	/**
	 * 登录模式(1-在本窗口打开OA,2-在新窗口打开OA显示工具栏,3-在新窗口打开)
	 */
	private String menuType;
	/**
	 * 上次修改密码的时间
	 */
	private Date lastPassTime;
	/**
	 * 界面主题
	 */
	private Byte theme;
	/**
	 *门户ID串
	 */
	private String portal;
	/**
	 * 登录后显示的左侧面板(1-导航,2-组织,3-短信,4-搜索)
	 */
	private String panel;
	/**
	 * 在线时长
	 */
	private Integer online;
	/**
	 * 记录在线状态(1-联机,2-忙碌,3-离开)
	 */
	private String onStatus;
	/**
	 * 岗位状态(1-出差,2-请假,3-外出)
	 */
	private String attendStatus;
	/**
	 * 手机号码是否公开(0-公开,1-不公开)
	 */
	private String mobilNoHidden;
	/**
	 * 左侧的桌面模块
	 */
	private String mytableLeft;
	/**
	 * 右侧的桌面模块
	 */
	private String mytableRight;
	/**
	 * 辅助角色编码串
	 */
	private String userPrivOther;
	/**
	 * 用户排序号
	 */
	private Short userNo;
	/**
	 * 禁止登录OA系统(1-禁止,0-不禁止)
	 */
	private Byte notLogin;
	/**
	 * 禁止查看用户列表(1-禁止,0-不禁止)
	 */
	private String notViewUser;
	/**
	 * 禁止显示桌面(1-禁止,0-不禁止)
	 */
	private String notViewTable;
	/**
	 *禁止OA搜索(1-禁止,0-不禁止)
	 */
	private String notSearch;
	/**
	 * 桌面背景图片
	 */
	private String bkground;
	/**
	 * 绑定IP地址
	 */
	private String bindIp;
	/**
	 * 上次访问系统的IP
	 */
	private String lastVisitIp;
	/**
	 * 菜单图标(0-每个菜单使用不同图标,1-不显示菜单图标)
	 */
	private String menuImage;
	/**
	 * null
	 */
	private String weatherCity;
	
	/**
	 *备注
	 */
	private String remark;
	/**
	 * 默认展开菜单
	 */
	private String menuExpand;
	/**
	 * 个性签名
	 */
	private String myStatus;
	/**
	 * 登录次数限制
	 */
	private String limitLogin;
	/**
	 * 用户名片图片
	 */
	private String photo;
	/**
	 * 即时通讯使用权限(1-允许使用,2-禁止使用)
	 */
	private Byte imRange;
	/**
	 * 早退时间
	 */
	private Date leaveTime;
	/**
	 * 邮件密级类型(1-非涉密,2-秘密[一般],3-机密[重要],4-绝密[非常重要])
	 */
	private Integer secretLevel;
	
	/**
	 * 禁止登录OA系统手机客户端(1-禁止,0-不禁止)
	 */
	private String notMobileLogin;
	/**
	 * 用户管理的模块
	 */
	private String manageModuleType;
	/**
	 * 用户角色类型
	 */
	private Byte userPrivType;
	/**
	 * 用户管理的分支机构ID串
	 */
	private String userManageOrgs;
	
	/**
	 * 快捷菜单ID串
	 */
	private String shortcut;
	/**
	 * 今日资讯中的网址设置
	 */
	private String myRss;
	/**
	 * 用户参数
	 */
	private String userPara;
	
	private String showRss;
	
	private Department dep;
	
	private String deptName; 
	
	private String companyName;
   
	private  SysPara para; 
	
	private String name;

     private String funcIdStr;
     //辅助角色名字
     private  String  roleAuxiliaryName;

	 public String getRoleAuxiliaryName() {
		 return roleAuxiliaryName;
	 }

	 public void setRoleAuxiliaryName(String roleAuxiliaryName) {
		 this.roleAuxiliaryName = roleAuxiliaryName;
	 }

	 public String getFuncIdStr() {
         return funcIdStr;
     }

     public void setFuncIdStr(String funcIdStr) {
         this.funcIdStr = funcIdStr;
     }

     public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShowRss() {
		return showRss;
	}

	public void setShowRss(String showRss) {
		this.showRss = showRss;
	}

	public SysPara getPara() {
		return para;
	}

	public void setPara(SysPara para) {
		this.para = para;
	}
	
	

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	private Role role;
	
	public Department getDep() {
		return dep;
	}
	/**
	 * 
	 * @param dep
	 */
	public void setDep(Department dep) {
		this.dep = dep;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNameIndex() {
		return userNameIndex;
	}
	public void setUserNameIndex(String userNameIndex) {
		this.userNameIndex = userNameIndex;
	}
	public String getByname() {
		return byname;
	}
	public void setByname(String byname) {
		this.byname = byname;
	}
	public String getUseingKey() {
		return useingKey;
	}
	public void setUseingKey(String useingKey) {
		this.useingKey = useingKey;
	}
	public String getUsingFinger() {
		return usingFinger;
	}
	public void setUsingFinger(String usingFinger) {
		this.usingFinger = usingFinger;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKeySn() {
		return keySn;
	}
	public void setKeySn(String keySn) {
		this.keySn = keySn;
	}
	public String getSecureKeySn() {
		return secureKeySn;
	}
	public void setSecureKeySn(String secureKeySn) {
		this.secureKeySn = secureKeySn;
	}
	public Integer getUserPriv() {
		return userPriv;
	}
	public void setUserPriv(Integer userPriv) {
		this.userPriv = userPriv;
	}
	public Short getUserPrivNo() {
		return userPrivNo;
	}
	public void setUserPrivNo(Short userPrivNo) {
		this.userPrivNo = userPrivNo;
	}
	public String getUserPrivName() {
		return userPrivName;
	}
	public void setUserPrivName(String userPrivName) {
		this.userPrivName = userPrivName;
	}
	public String getPostPriv() {
		return postPriv;
	}
	public void setPostPriv(String postPriv) {
		this.postPriv = postPriv;
	}
	public String getPostDept() {
		return postDept;
	}
	public void setPostDept(String postDept) {
		this.postDept = postDept;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptIdOther() {
		return deptIdOther;
	}
	public void setDeptIdOther(String deptIdOther) {
		this.deptIdOther = deptIdOther;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIsLunar() {
		return isLunar;
	}
	public void setIsLunar(String isLunar) {
		this.isLunar = isLunar;
	}
	public String getTelNoDept() {
		return telNoDept;
	}
	public void setTelNoDept(String telNoDept) {
		this.telNoDept = telNoDept;
	}
	public String getFaxNoDept() {
		return faxNoDept;
	}
	public void setFaxNoDept(String faxNoDept) {
		this.faxNoDept = faxNoDept;
	}
	public String getAddHome() {
		return addHome;
	}
	public void setAddHome(String addHome) {
		this.addHome = addHome;
	}
	public String getPostNoHome() {
		return postNoHome;
	}
	public void setPostNoHome(String postNoHome) {
		this.postNoHome = postNoHome;
	}
	public String getTelNoHome() {
		return telNoHome;
	}
	public void setTelNoHome(String telNoHome) {
		this.telNoHome = telNoHome;
	}
	public String getMobilNo() {
		return mobilNo;
	}
	public void setMobilNo(String mobilNo) {
		this.mobilNo = mobilNo;
	}
	public String getBpNo() {
		return bpNo;
	}
	public void setBpNo(String bpNo) {
		this.bpNo = bpNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOicqNo() {
		return oicqNo;
	}
	public void setOicqNo(String oicqNo) {
		this.oicqNo = oicqNo;
	}
	public String getIcqNo() {
		return icqNo;
	}
	public void setIcqNo(String icqNo) {
		this.icqNo = icqNo;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getCallSound() {
		return callSound;
	}
	public void setCallSound(String callSound) {
		this.callSound = callSound;
	}
	public Date getLastVisitTime() {
		return lastVisitTime;
	}
	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}
	public String getSmsOn() {
		return smsOn;
	}
	public void setSmsOn(String smsOn) {
		this.smsOn = smsOn;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public Date getLastPassTime() {
		return lastPassTime;
	}
	public void setLastPassTime(Date lastPassTime) {
		this.lastPassTime = lastPassTime;
	}
	public Byte getTheme() {
		return theme;
	}
	public void setTheme(Byte theme) {
		this.theme = theme;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public String getPanel() {
		return panel;
	}
	public void setPanel(String panel) {
		this.panel = panel;
	}
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	public String getOnStatus() {
		return onStatus;
	}
	public void setOnStatus(String onStatus) {
		this.onStatus = onStatus;
	}
	public String getAttendStatus() {
		return attendStatus;
	}
	public void setAttendStatus(String attendStatus) {
		this.attendStatus = attendStatus;
	}
	public String getMobilNoHidden() {
		return mobilNoHidden;
	}
	public void setMobilNoHidden(String mobilNoHidden) {
		this.mobilNoHidden = mobilNoHidden;
	}
	public String getMytableLeft() {
		return mytableLeft;
	}
	public void setMytableLeft(String mytableLeft) {
		this.mytableLeft = mytableLeft;
	}
	public String getMytableRight() {
		return mytableRight;
	}
	public void setMytableRight(String mytableRight) {
		this.mytableRight = mytableRight;
	}
	public String getUserPrivOther() {
		return userPrivOther;
	}
	public void setUserPrivOther(String userPrivOther) {
		this.userPrivOther = userPrivOther;
	}
	public Short getUserNo() {
		return userNo;
	}
	public void setUserNo(Short userNo) {
		this.userNo = userNo;
	}
	public Byte getNotLogin() {
		return notLogin;
	}
	public void setNotLogin(Byte notLogin) {
		this.notLogin = notLogin;
	}
	public String getNotViewUser() {
		return notViewUser;
	}
	public void setNotViewUser(String notViewUser) {
		this.notViewUser = notViewUser;
	}
	public String getNotViewTable() {
		return notViewTable;
	}
	public void setNotViewTable(String notViewTable) {
		this.notViewTable = notViewTable;
	}
	public String getNotSearch() {
		return notSearch;
	}
	public void setNotSearch(String notSearch) {
		this.notSearch = notSearch;
	}
	public String getBkground() {
		return bkground;
	}
	public void setBkground(String bkground) {
		this.bkground = bkground;
	}
	public String getBindIp() {
		return bindIp;
	}
	public void setBindIp(String bindIp) {
		this.bindIp = bindIp;
	}
	public String getLastVisitIp() {
		return lastVisitIp;
	}
	public void setLastVisitIp(String lastVisitIp) {
		this.lastVisitIp = lastVisitIp;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public String getWeatherCity() {
		return weatherCity;
	}
	public void setWeatherCity(String weatherCity) {
		this.weatherCity = weatherCity;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMenuExpand() {
		return menuExpand;
	}
	public void setMenuExpand(String menuExpand) {
		this.menuExpand = menuExpand;
	}
	public String getMyStatus() {
		return myStatus;
	}
	public void setMyStatus(String myStatus) {
		this.myStatus = myStatus;
	}
	public String getLimitLogin() {
		return limitLogin;
	}
	public void setLimitLogin(String limitLogin) {
		this.limitLogin = limitLogin;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Byte getImRange() {
		return imRange;
	}
	public void setImRange(Byte imRange) {
		this.imRange = imRange;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Integer getSecretLevel() {
		return secretLevel;
	}
	public void setSecretLevel(Integer secretLevel) {
		this.secretLevel = secretLevel;
	}
	public String getNotMobileLogin() {
		return notMobileLogin;
	}
	public void setNotMobileLogin(String notMobileLogin) {
		this.notMobileLogin = notMobileLogin;
	}
	public String getManageModuleType() {
		return manageModuleType;
	}
	public void setManageModuleType(String manageModuleType) {
		this.manageModuleType = manageModuleType;
	}
	public Byte getUserPrivType() {
		return userPrivType;
	}
	public void setUserPrivType(Byte userPrivType) {
		this.userPrivType = userPrivType;
	}
	public String getUserManageOrgs() {
		return userManageOrgs;
	}
	public void setUserManageOrgs(String userManageOrgs) {
		this.userManageOrgs = userManageOrgs;
	}
	public String getShortcut() {
		return shortcut;
	}
	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}
	public String getMyRss() {
		return myRss;
	}
	public void setMyRss(String myRss) {
		this.myRss = myRss;
	}
	public String getUserPara() {
		return userPara;
	}
	public void setUserPara(String userPara) {
		this.userPara = userPara;
	}

}
