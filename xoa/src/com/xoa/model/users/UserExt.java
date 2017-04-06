package com.xoa.model.users;

public class UserExt {
	/**
	 *对应user表的UID
	 */
    private Integer uid;
    /**
	 *对应user表的USER_ID
	 */
    private String userId;
    /**
	 *桌面图标ID串
	 */
    private String tableIcon;
    /**
	 *最近联系人
	 */
    private String emailRecentLinkman;
    /**
	 *昵称
	 */
    private String nickName;
    /**
	 *发表文章数
	 */
    private Integer bbsCounter;
    /**
	 *内部邮箱容量
	 */
    private Short emailCapacity;
    /**
	 *个人文件柜容量
	 */
    private Short folderCapacity;
    /**
	 *每个Internet邮箱容量
	 */
    private Short webmailCapacity;
    /**
	 *可使用Internet邮箱数量
	 */
    private Byte webmailNum;
    /**
	 *OA知道积分
	 */
    private Integer score;
    /**
	 *OA知道管理员标识
	 */
    private String tderFlag;
    /**
	 *考勤排班类型(1-正常班,2-全日班,99-轮班制)
	 */
    private Short dutyType;
    /**
	 *是否启用POP3功能(1-是,0-否)
	 */
    private Boolean usePop3;
    /**
	 *是否开启POP3功能(1-是,0-否)
	 */
    private Boolean isUsePop3;
    /**
	 *密码验证
	 */
    private Boolean pop3PassStyle;
    /**
	 *POP3密码
	 */
    private String pop3Pass;
    /**
	 *企业社区账号用户名
	 */
    private String ccUsername;
    /**
	 *密码
	 */
    private String ccPwd;
    /**
	 *null 无用
	 */
    private Boolean isUseEmailsend;
    /**
	 *null 无用
	 */
    private Boolean taskcenterOpenStart;
    /**
	 *null 无用
	 */
    private String emailGetbox;
    /**
	 *文件柜视图标志
	 */
    private Boolean folderViewModel;
    /**
	 *是否启用邮件发送限制
	 */
    private Boolean useEmail;
    /**
	 *讨论区签名档
	 */
    private String bbsSignature;
    /**
	 *我关注的用户ID串
	 */
    private String concernUser;
    /**
	 *用户菜单ID串
	 */
    private String uFuncIdStr;

    public String getBbsSignature() {
		return bbsSignature;
	}

	public void setBbsSignature(String bbsSignature) {
		this.bbsSignature = bbsSignature;
	}

	public String getConcernUser() {
		return concernUser;
	}

	public void setConcernUser(String concernUser) {
		this.concernUser = concernUser;
	}

	public String getuFuncIdStr() {
		return uFuncIdStr;
	}

	public void setuFuncIdStr(String uFuncIdStr) {
		this.uFuncIdStr = uFuncIdStr;
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

    public String getTableIcon() {
        return tableIcon;
    }

    public void setTableIcon(String tableIcon) {
        this.tableIcon = tableIcon == null ? null : tableIcon.trim();
    }

    public String getEmailRecentLinkman() {
        return emailRecentLinkman;
    }

    public void setEmailRecentLinkman(String emailRecentLinkman) {
        this.emailRecentLinkman = emailRecentLinkman == null ? null : emailRecentLinkman.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getBbsCounter() {
        return bbsCounter;
    }

    public void setBbsCounter(Integer bbsCounter) {
        this.bbsCounter = bbsCounter;
    }

    public Short getEmailCapacity() {
        return emailCapacity;
    }

    public void setEmailCapacity(Short emailCapacity) {
        this.emailCapacity = emailCapacity;
    }

    public Short getFolderCapacity() {
        return folderCapacity;
    }

    public void setFolderCapacity(Short folderCapacity) {
        this.folderCapacity = folderCapacity;
    }

    public Short getWebmailCapacity() {
        return webmailCapacity;
    }

    public void setWebmailCapacity(Short webmailCapacity) {
        this.webmailCapacity = webmailCapacity;
    }

    public Byte getWebmailNum() {
        return webmailNum;
    }

    public void setWebmailNum(Byte webmailNum) {
        this.webmailNum = webmailNum;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTderFlag() {
        return tderFlag;
    }

    public void setTderFlag(String tderFlag) {
        this.tderFlag = tderFlag == null ? null : tderFlag.trim();
    }

    public Short getDutyType() {
        return dutyType;
    }

    public void setDutyType(Short dutyType) {
        this.dutyType = dutyType;
    }

    public Boolean getUsePop3() {
        return usePop3;
    }

    public void setUsePop3(Boolean usePop3) {
        this.usePop3 = usePop3;
    }

    public Boolean getIsUsePop3() {
        return isUsePop3;
    }

    public void setIsUsePop3(Boolean isUsePop3) {
        this.isUsePop3 = isUsePop3;
    }

    public Boolean getPop3PassStyle() {
        return pop3PassStyle;
    }

    public void setPop3PassStyle(Boolean pop3PassStyle) {
        this.pop3PassStyle = pop3PassStyle;
    }

    public String getPop3Pass() {
        return pop3Pass;
    }

    public void setPop3Pass(String pop3Pass) {
        this.pop3Pass = pop3Pass == null ? null : pop3Pass.trim();
    }

    public String getCcUsername() {
        return ccUsername;
    }

    public void setCcUsername(String ccUsername) {
        this.ccUsername = ccUsername == null ? null : ccUsername.trim();
    }

    public String getCcPwd() {
        return ccPwd;
    }

    public void setCcPwd(String ccPwd) {
        this.ccPwd = ccPwd == null ? null : ccPwd.trim();
    }

    public Boolean getIsUseEmailsend() {
        return isUseEmailsend;
    }

    public void setIsUseEmailsend(Boolean isUseEmailsend) {
        this.isUseEmailsend = isUseEmailsend;
    }

    public Boolean getTaskcenterOpenStart() {
        return taskcenterOpenStart;
    }

    public void setTaskcenterOpenStart(Boolean taskcenterOpenStart) {
        this.taskcenterOpenStart = taskcenterOpenStart;
    }

    public String getEmailGetbox() {
        return emailGetbox;
    }

    public void setEmailGetbox(String emailGetbox) {
        this.emailGetbox = emailGetbox == null ? null : emailGetbox.trim();
    }

    public Boolean getFolderViewModel() {
        return folderViewModel;
    }

    public void setFolderViewModel(Boolean folderViewModel) {
        this.folderViewModel = folderViewModel;
    }

    public Boolean getUseEmail() {
        return useEmail;
    }

    public void setUseEmail(Boolean useEmail) {
        this.useEmail = useEmail;
    }
}