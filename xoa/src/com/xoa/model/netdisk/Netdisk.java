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
    /**
     * 
     * @Title: getDiskName
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getDiskName() {
        return diskName;
    }
    /**
     * 
     * @Title: setDiskName
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param diskName   
     * @return: void   
     * @throws
     */
    public void setDiskName(String diskName) {
        this.diskName = diskName == null ? null : diskName.trim();
    }
    /**
     * 
     * @Title: getDiskPath
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getDiskPath() {
        return diskPath;
    }
    /**
     * 
     * @Title: setDiskPath
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param diskPath   
     * @return: void   
     * @throws
     */
    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath == null ? null : diskPath.trim();
    }
    /**
     * 
     * @Title: getNewUser
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getNewUser() {
        return newUser;
    }
    /**
     * 
     * @Title: setNewUser
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param newUser   
     * @return: void   
     * @throws
     */
    public void setNewUser(String newUser) {
        this.newUser = newUser == null ? null : newUser.trim();
    }
    /**
     * 
     * @Title: getManageUser
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getManageUser() {
        return manageUser;
    }
    /**
     * 
     * @Title: setManageUser
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param manageUser   
     * @return: void   
     * @throws
     */
    public void setManageUser(String manageUser) {
        this.manageUser = manageUser == null ? null : manageUser.trim();
    }
    /**
     * 
     * @Title: getUserId
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getUserId() {
        return userId;
    }
    /**
     * 
     * @Title: setUserId
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param userId   
     * @return: void   
     * @throws
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
    /**
     * 
     * @Title: getDownUser
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getDownUser() {
        return downUser;
    }
    /**
     * 
     * @Title: setDownUser
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param downUser   
     * @return: void   
     * @throws
     */
    public void setDownUser(String downUser) {
        this.downUser = downUser == null ? null : downUser.trim();
    }
    /**
     * 
     * @Title: getRemark
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 
     * @Title: setRemark
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param remark   
     * @return: void   
     * @throws
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    /**
     * 
     * @Title: getDiskId
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getDiskId() {
        return diskId;
    }
    /**
     * 
     * @Title: setDiskId
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param diskId   
     * @return: void   
     * @throws
     */
    public void setDiskId(Integer diskId) {
        this.diskId = diskId;
    }
    /**
     * 
     * @Title: getDiskNo
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getDiskNo() {
        return diskNo;
    }
    /**
     * 
     * @Title: setDiskNo
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param diskNo   
     * @return: void   
     * @throws
     */
    public void setDiskNo(Integer diskNo) {
        this.diskNo = diskNo;
    }
    /**
     * 
     * @Title: getSpaceLimit
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: Integer   
     * @throws
     */
    public Integer getSpaceLimit() {
        return spaceLimit;
    }
    /**
     * 
     * @Title: setSpaceLimit
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param spaceLimit   
     * @return: void   
     * @throws
     */
    public void setSpaceLimit(Integer spaceLimit) {
        this.spaceLimit = spaceLimit;
    }
    /**
     * 
     * @Title: getOrderBy
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getOrderBy() {
        return orderBy;
    }
    /**
     * 
     * @Title: setOrderBy
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param orderBy   
     * @return: void   
     * @throws
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy == null ? null : orderBy.trim();
    } 
    /**
     * 
     * @Title: getAscDesc
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getAscDesc() {
        return ascDesc;
    }
    /**
     * 
     * @Title: setAscDesc
     * @Description: TODO
     * @author(作者): 张丽军
     * @param: @param ascDesc   
     * @return: void   
     * @throws
     */
    public void setAscDesc(String ascDesc) {
        this.ascDesc = ascDesc == null ? null : ascDesc.trim();
    }
}