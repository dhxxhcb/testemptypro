package com.xoa.model.diary;

import java.util.Date;

public class DiaryModel {
	/**
	 * 
	 */
    private Integer diaId;

    private String userId;

    private String diaDate;

    private String diaTime;

    private String diaType;

    private String subject;

    private String lastCommentTime;

    private Integer toAll;

    private Integer crmDiary;

    private String content;

    private String attachmentId;

    private String attachmentName;

    private String toId;

    private byte[] compressContent;

    private String readers;

  
    public String getDiaDate() {
		return diaDate;
	}

	public void setDiaDate(String diaDate) {
		this.diaDate = diaDate;
	}

	public String getDiaTime() {
		return diaTime;
	}

	public void setDiaTime(String diaTime) {
		this.diaTime = diaTime;
	}

	public String getLastCommentTime() {
		return lastCommentTime;
	}

	public void setLastCommentTime(String lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}

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

    public byte[] getCompressContent() {
        return compressContent;
    }

    public void setCompressContent(byte[] compressContent) {
        this.compressContent = compressContent;
    }

    public String getReaders() {
        return readers;
    }

    public void setReaders(String readers) {
        this.readers = readers == null ? null : readers.trim();
    }
    public Integer getDiaId() {
        return diaId;
    }

    public void setDiaId(Integer diaId) {
        this.diaId = diaId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDiaType() {
        return diaType;
    }

    public void setDiaType(String diaType) {
        this.diaType = diaType == null ? null : diaType.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Integer getToAll() {
        return toAll;
    }

    public void setToAll(Integer toAll) {
        this.toAll = toAll;
    }

    public Integer getCrmDiary() {
        return crmDiary;
    }

    public void setCrmDiary(Integer crmDiary) {
        this.crmDiary = crmDiary;
    }
}