package com.xoa.model.im;

public class ImMessage {
    private Integer imid;

    private String fromUid;

    private String toUid;

    private String ofFrom;

    private String ofTo;

    private String thumbnailUrl;

    private String stime;

    private Integer atime;

    private String type;

    private String dflag;

    private String msgType;

    private String uuid;

    public Integer getImid() {
        return imid;
    }

    public void setImid(Integer imid) {
        this.imid = imid;
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

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl == null ? null : thumbnailUrl.trim();
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime == null ? null : stime.trim();
    }

    public Integer getAtime() {
        return atime;
    }

    public void setAtime(Integer atime) {
        this.atime = atime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDflag() {
        return dflag;
    }

    public void setDflag(String dflag) {
        this.dflag = dflag == null ? null : dflag.trim();
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
}