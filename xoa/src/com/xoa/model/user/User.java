package com.xoa.model.user;

import java.util.Date;

public class User {
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
	private Date birthday;
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
	private Byte notMobileLogin;
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



	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserNameIndex() {
		return userNameIndex;
	}

	public void setUserNameIndex(String userNameIndex) {
		this.userNameIndex = userNameIndex == null ? null : userNameIndex.trim();
	}

	public String getByname() {
		return byname;
	}

	public void setByname(String byname) {
		this.byname = byname == null ? null : byname.trim();
	}

	public String getUseingKey() {
		return useingKey;
	}

	public void setUseingKey(String useingKey) {
		this.useingKey = useingKey == null ? null : useingKey.trim();
	}

	public String getUsingFinger() {
		return usingFinger;
	}

	public void setUsingFinger(String usingFinger) {
		this.usingFinger = usingFinger == null ? null : usingFinger.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getKeySn() {
		return keySn;
	}

	public void setKeySn(String keySn) {
		this.keySn = keySn == null ? null : keySn.trim();
	}

	public String getSecureKeySn() {
		return secureKeySn;
	}

	public void setSecureKeySn(String secureKeySn) {
		this.secureKeySn = secureKeySn == null ? null : secureKeySn.trim();
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
		this.userPrivName = userPrivName == null ? null : userPrivName.trim();
	}

	public String getPostPriv() {
		return postPriv;
	}

	public void setPostPriv(String postPriv) {
		this.postPriv = postPriv == null ? null : postPriv.trim();
	}

	public String getPostDept() {
		return postDept;
	}

	public void setPostDept(String postDept) {
		this.postDept = postDept == null ? null : postDept.trim();
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
		this.deptIdOther = deptIdOther == null ? null : deptIdOther.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIsLunar() {
		return isLunar;
	}

	public void setIsLunar(String isLunar) {
		this.isLunar = isLunar == null ? null : isLunar.trim();
	}

	public String getTelNoDept() {
		return telNoDept;
	}

	public void setTelNoDept(String telNoDept) {
		this.telNoDept = telNoDept == null ? null : telNoDept.trim();
	}

	public String getFaxNoDept() {
		return faxNoDept;
	}

	public void setFaxNoDept(String faxNoDept) {
		this.faxNoDept = faxNoDept == null ? null : faxNoDept.trim();
	}

	public String getAddHome() {
		return addHome;
	}

	public void setAddHome(String addHome) {
		this.addHome = addHome == null ? null : addHome.trim();
	}

	public String getPostNoHome() {
		return postNoHome;
	}

	public void setPostNoHome(String postNoHome) {
		this.postNoHome = postNoHome == null ? null : postNoHome.trim();
	}

	public String getTelNoHome() {
		return telNoHome;
	}

	public void setTelNoHome(String telNoHome) {
		this.telNoHome = telNoHome == null ? null : telNoHome.trim();
	}

	public String getMobilNo() {
		return mobilNo;
	}

	public void setMobilNo(String mobilNo) {
		this.mobilNo = mobilNo == null ? null : mobilNo.trim();
	}

	public String getBpNo() {
		return bpNo;
	}

	public void setBpNo(String bpNo) {
		this.bpNo = bpNo == null ? null : bpNo.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getOicqNo() {
		return oicqNo;
	}

	public void setOicqNo(String oicqNo) {
		this.oicqNo = oicqNo == null ? null : oicqNo.trim();
	}

	public String getIcqNo() {
		return icqNo;
	}

	public void setIcqNo(String icqNo) {
		this.icqNo = icqNo == null ? null : icqNo.trim();
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn == null ? null : msn.trim();
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	public String getCallSound() {
		return callSound;
	}

	public void setCallSound(String callSound) {
		this.callSound = callSound == null ? null : callSound.trim();
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
		this.smsOn = smsOn == null ? null : smsOn.trim();
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType == null ? null : menuType.trim();
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
		this.portal = portal == null ? null : portal.trim();
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel == null ? null : panel.trim();
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
		this.onStatus = onStatus == null ? null : onStatus.trim();
	}

	public String getAttendStatus() {
		return attendStatus;
	}

	public void setAttendStatus(String attendStatus) {
		this.attendStatus = attendStatus == null ? null : attendStatus.trim();
	}

	public String getMobilNoHidden() {
		return mobilNoHidden;
	}

	public void setMobilNoHidden(String mobilNoHidden) {
		this.mobilNoHidden = mobilNoHidden == null ? null : mobilNoHidden.trim();
	}

	public String getMytableLeft() {
		return mytableLeft;
	}

	public void setMytableLeft(String mytableLeft) {
		this.mytableLeft = mytableLeft == null ? null : mytableLeft.trim();
	}

	public String getMytableRight() {
		return mytableRight;
	}

	public void setMytableRight(String mytableRight) {
		this.mytableRight = mytableRight == null ? null : mytableRight.trim();
	}

	public String getUserPrivOther() {
		return userPrivOther;
	}

	public void setUserPrivOther(String userPrivOther) {
		this.userPrivOther = userPrivOther == null ? null : userPrivOther.trim();
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
		this.notViewUser = notViewUser == null ? null : notViewUser.trim();
	}

	public String getNotViewTable() {
		return notViewTable;
	}

	public void setNotViewTable(String notViewTable) {
		this.notViewTable = notViewTable == null ? null : notViewTable.trim();
	}

	public String getNotSearch() {
		return notSearch;
	}

	public void setNotSearch(String notSearch) {
		this.notSearch = notSearch == null ? null : notSearch.trim();
	}

	public String getBkground() {
		return bkground;
	}

	public void setBkground(String bkground) {
		this.bkground = bkground == null ? null : bkground.trim();
	}

	public String getBindIp() {
		return bindIp;
	}

	public void setBindIp(String bindIp) {
		this.bindIp = bindIp == null ? null : bindIp.trim();
	}

	public String getLastVisitIp() {
		return lastVisitIp;
	}

	public void setLastVisitIp(String lastVisitIp) {
		this.lastVisitIp = lastVisitIp == null ? null : lastVisitIp.trim();
	}

	public String getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage == null ? null : menuImage.trim();
	}

	public String getWeatherCity() {
		return weatherCity;
	}

	public void setWeatherCity(String weatherCity) {
		this.weatherCity = weatherCity == null ? null : weatherCity.trim();
	}


	public String getMenuExpand() {
		return menuExpand;
	}

	public void setMenuExpand(String menuExpand) {
		this.menuExpand = menuExpand == null ? null : menuExpand.trim();
	}

	public String getMyStatus() {
		return myStatus;
	}

	public void setMyStatus(String myStatus) {
		this.myStatus = myStatus == null ? null : myStatus.trim();
	}

	public String getLimitLogin() {
		return limitLogin;
	}

	public void setLimitLogin(String limitLogin) {
		this.limitLogin = limitLogin == null ? null : limitLogin.trim();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
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

	public Byte getNotMobileLogin() {
		return notMobileLogin;
	}

	public void setNotMobileLogin(Byte notMobileLogin) {
		this.notMobileLogin = notMobileLogin;
	}

	public String getManageModuleType() {
		return manageModuleType;
	}

	public void setManageModuleType(String manageModuleType) {
		this.manageModuleType = manageModuleType == null ? null : manageModuleType.trim();
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
		this.userManageOrgs = userManageOrgs == null ? null : userManageOrgs.trim();
	}
}