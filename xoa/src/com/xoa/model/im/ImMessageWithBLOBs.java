package com.xoa.model.im;

public class ImMessageWithBLOBs extends ImMessage {
    private String content;

    private String fileId;

    private String fileName;

    public String getContent() {
        return content;
    }

     public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }
}