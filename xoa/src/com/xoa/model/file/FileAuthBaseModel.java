package com.xoa.model.file;

/**
 * Created by eagle on 2017/6/6.
 */
public class FileAuthBaseModel {
    FileAuthChildModel userId;
    FileAuthChildModel manageUser;
    FileAuthChildModel delUser;
    FileAuthChildModel downUser;
    FileAuthChildModel shareUser;
    FileAuthChildModel owner;
    FileAuthChildModel signUser;
    FileAuthChildModel review;
    FileAuthChildModel description;
    FileAuthChildModel newUser;
    Integer sortId;

    public FileAuthChildModel getUserId() {
        return userId;
    }

    public void setUserId(FileAuthChildModel userId) {
        this.userId = userId;
    }

    public FileAuthChildModel getManageUser() {
        return manageUser;
    }

    public void setManageUser(FileAuthChildModel manageUser) {
        this.manageUser = manageUser;
    }

    public FileAuthChildModel getDelUser() {
        return delUser;
    }

    public void setDelUser(FileAuthChildModel delUser) {
        this.delUser = delUser;
    }

    public FileAuthChildModel getDownUser() {
        return downUser;
    }

    public void setDownUser(FileAuthChildModel downUser) {
        this.downUser = downUser;
    }

    public FileAuthChildModel getShareUser() {
        return shareUser;
    }

    public void setShareUser(FileAuthChildModel shareUser) {
        this.shareUser = shareUser;
    }

    public FileAuthChildModel getOwner() {
        return owner;
    }

    public void setOwner(FileAuthChildModel owner) {
        this.owner = owner;
    }

    public FileAuthChildModel getSignUser() {
        return signUser;
    }

    public void setSignUser(FileAuthChildModel signUser) {
        this.signUser = signUser;
    }

    public FileAuthChildModel getReview() {
        return review;
    }

    public void setReview(FileAuthChildModel review) {
        this.review = review;
    }

    public FileAuthChildModel getDescription() {
        return description;
    }

    public void setDescription(FileAuthChildModel description) {
        this.description = description;
    }

    public FileAuthChildModel getNewUser() {
        return newUser;
    }

    public void setNewUser(FileAuthChildModel newUser) {
        this.newUser = newUser;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public class FileAuthChildModel{
        String user;
        String dept;
        String role;
        FileAuthGrandChildModel data;
        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public FileAuthGrandChildModel getData() {
            return data;
        }

        public void setData(FileAuthGrandChildModel data) {
            this.data = data;
        }
    }

    public class FileAuthGrandChildModel{
        String userStr;
        String deptStr;
        String roleStr;
        public String getUserStr() {
            return userStr;
        }

        public void setUserStr(String userStr) {
            this.userStr = userStr;
        }

        public String getDeptStr() {
            return deptStr;
        }

        public void setDeptStr(String deptStr) {
            this.deptStr = deptStr;
        }

        public String getRoleStr() {
            return roleStr;
        }

        public void setRoleStr(String roleStr) {
            this.roleStr = roleStr;
        }
    }
}
