package com.xoa.model.im;

public class ImChatList {
	
	
    private String listId;//云办公用户UID
	
    private String fromUid;//云办公发消息人UID
	
    private String toUid;//云办公接收消息人UID
	
    private String ofFrom;//OF发消息人UID
	
    private String ofTo;//OF收消息人UID
	
    private String lastTime;//最后消息时间
	
    private String lastAtime;//入库时间
	
    private String lastFileId;
	
    private String lastFileName;
	
    private String lastThumbnailUrl;
	
    private String type;
	
    private String msgType;//会话类型（1单聊，2群聊）
	
	
    private String uuid;
	
    private String lastContent;//最后消息内容
	
	

	public String  getListId() {
        return listId;
    }

    public void setListId(String listId) {
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
    
}