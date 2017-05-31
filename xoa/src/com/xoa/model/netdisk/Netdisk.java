package com.xoa.model.netdisk;

public class Netdisk {
	/**
	 * 自增唯一ID
	 */
    private Integer diskId;
    /**
     * 网络硬盘排序号
     */
    private Integer diskNo;
    /**
     * 最大容量
     */
    private Integer spaceLimit;
    /**
     * 默认排序字段
     */
    private String orderBy;
    /**
     * 默认升序降序
     */
    private String ascDesc;
    /**
     * 网络硬盘名称
     */
    private String diskName;
    /**
     * 目录路径
     */
    private String diskPath;
    /**
     * 新建权限
     */
    private String newUser;
    /**
     * 管理权限
     */
    private String manageUser;
    /**
     * 访问权限
     */
    private String userId;
    /**
     * 下载打印权限
     */
    private String downUser;
    /**
     * 备注
     */
    private String remark;

    public Integer getDiskId() {
        return diskId==null?0:diskId;
    }

    public void setDiskId(Integer diskId) {
        this.diskId = diskId;
    }

    public Integer getDiskNo() {
        return diskNo;
    }

    public void setDiskNo(Integer diskNo) {
        this.diskNo = diskNo;
    }

    public Integer getSpaceLimit() {
        return spaceLimit==null?0:spaceLimit;
    }

    public void setSpaceLimit(Integer spaceLimit) {
        this.spaceLimit = spaceLimit;
    }

    public String getOrderBy() {
        return orderBy==null?"":orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getAscDesc() {
        return ascDesc==null?"":ascDesc;
    }

    public void setAscDesc(String ascDesc) {
        this.ascDesc = ascDesc;
    }

    public String getDiskName() {
        return diskName==null?"":diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public String getDiskPath() {
        return diskPath==null?"":diskPath;
    }

    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    public String getNewUser() {
        return newUser==null?"":newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser;
    }

    public String getManageUser() {
        return manageUser==null?"":manageUser;
    }

    public void setManageUser(String manageUser) {
        this.manageUser = manageUser;
    }

    public String getUserId() {
        return userId==null?"":userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDownUser() {
        return downUser==null?"":downUser;
    }

    public void setDownUser(String downUser) {
        this.downUser = downUser;
    }

    public String getRemark() {
        return remark==null?"":remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}