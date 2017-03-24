package com.xoa.model;

public class EmailBox {
    private Integer boxId;

    private Integer boxNo;

    private String boxName;

    private String userId;

    private String defaultCount;

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Integer getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(Integer boxNo) {
        this.boxNo = boxNo;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName == null ? null : boxName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(String defaultCount) {
        this.defaultCount = defaultCount == null ? null : defaultCount.trim();
    }
}