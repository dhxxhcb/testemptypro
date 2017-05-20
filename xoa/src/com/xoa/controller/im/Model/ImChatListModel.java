package com.xoa.controller.im.Model;


/**
 * im roominfo 返回模型
 * 创建作者:   杨 胜
 * 创建日期:   2017-5-20 上午9:31:40
 * 类介绍  :   
 * 构造参数:   
 *
 */
public class ImChatListModel {
    private Integer listId;

    private String fromUid;
 
    private String toUid;

    private String ofFrom;

    private String ofTo;

    private String lastTime;

    private String lastAtime;

    private String lastFileId;

    private String lastFileName;

    private String lastThumbnailUrl;

    private String type;

    private String msgType;

    private String uuid;

    private String lastContent;
    
    protected String orderByClause;

    protected boolean distinct;
    
    protected String  content;
    protected String  time;
    
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid == null ? null : fromUid.trim();
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid == null ? null : toUid.trim();
    }

    public String getOfFrom() {
        return ofFrom;
    }

    public void setOfFrom(String ofFrom) {
        this.ofFrom = ofFrom == null ? null : ofFrom.trim();
    }

    public String getOfTo() {
        return ofTo;
    }

    public void setOfTo(String ofTo) {
        this.ofTo = ofTo == null ? null : ofTo.trim();
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime == null ? null : lastTime.trim();
    }

    public String getLastAtime() {
        return lastAtime;
    }

    public void setLastAtime(String lastAtime) {
        this.lastAtime = lastAtime;
    }

    public String getLastFileId() {
        return lastFileId;
    }

    public void setLastFileId(String lastFileId) {
        this.lastFileId = lastFileId == null ? null : lastFileId.trim();
    }

    public String getLastFileName() {
        return lastFileName;
    }

    public void setLastFileName(String lastFileName) {
        this.lastFileName = lastFileName == null ? null : lastFileName.trim();
    }

    public String getLastThumbnailUrl() {
        return lastThumbnailUrl;
    }

    public void setLastThumbnailUrl(String lastThumbnailUrl) {
        this.lastThumbnailUrl = lastThumbnailUrl == null ? null : lastThumbnailUrl.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getLastContent() {
        return lastContent;
    }

    public void setLastContent(String lastContent) {
        this.lastContent = lastContent == null ? null : lastContent.trim();
    }
    
    
 
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }
}