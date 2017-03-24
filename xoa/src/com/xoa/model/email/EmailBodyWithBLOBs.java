package com.xoa.model.email;

public class EmailBodyWithBLOBs extends EmailBody {
    private String toId2;

    private String copyToId;

    private String secretToId;

    private String content;

    private String attachmentId;

    private String attachmentName;

    private String toWebmail;

    private byte[] compressContent;

    private byte[] webmailContent;

    private String auditRemark;

    private String copyToWebmail;

    private String secretToWebmail;

    private String praise;

    public String getToId2() {
        return toId2;
    }

    public void setToId2(String toId2) {
        this.toId2 = toId2 == null ? null : toId2.trim();
    }

    public String getCopyToId() {
        return copyToId;
    }

    public void setCopyToId(String copyToId) {
        this.copyToId = copyToId == null ? null : copyToId.trim();
    }

    public String getSecretToId() {
        return secretToId;
    }

    public void setSecretToId(String secretToId) {
        this.secretToId = secretToId == null ? null : secretToId.trim();
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

    public String getToWebmail() {
        return toWebmail;
    }

    public void setToWebmail(String toWebmail) {
        this.toWebmail = toWebmail == null ? null : toWebmail.trim();
    }

    public byte[] getCompressContent() {
        return compressContent;
    }

    public void setCompressContent(byte[] compressContent) {
        this.compressContent = compressContent;
    }

    public byte[] getWebmailContent() {
        return webmailContent;
    }

    public void setWebmailContent(byte[] webmailContent) {
        this.webmailContent = webmailContent;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    public String getCopyToWebmail() {
        return copyToWebmail;
    }

    public void setCopyToWebmail(String copyToWebmail) {
        this.copyToWebmail = copyToWebmail == null ? null : copyToWebmail.trim();
    }

    public String getSecretToWebmail() {
        return secretToWebmail;
    }

    public void setSecretToWebmail(String secretToWebmail) {
        this.secretToWebmail = secretToWebmail == null ? null : secretToWebmail.trim();
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise == null ? null : praise.trim();
    }
}