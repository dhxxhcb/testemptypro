package com.xoa.model.worldnews;

public class NewsWithBLOBs extends News {
    private String content;

    private String attachmentId;

    private String attachmentName;

    private String toId;

    private String privId;

    private String userId;

    private String readers;

    private byte[] compressContent;

    private String summary;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getPrivId() {
        return privId;
    }

    public void setPrivId(String privId) {
        this.privId = privId == null ? null : privId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getReaders() {
        return readers;
    }

    public void setReaders(String readers) {
        this.readers = readers == null ? null : readers.trim();
    }

    public byte[] getCompressContent() {
        return compressContent;
    }

    public void setCompressContent(byte[] compressContent) {
        this.compressContent = compressContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}