package com.xoa.model;

public class EmailBody {
    private Integer bodyId;

    private String fromId;

    private String subject;

    private Integer sendTime;

    private String sendFlag;

    private String smsRemind;

    private String important;

    private Long size;

    private Integer fromWebmailId;

    private String fromWebmail;

    private String webmailFlag;

    private String recvFromName;

    private String recvFrom;

    private Integer recvToId;

    private String recvTo;

    private String isWebmail;

    private String isWf;

    private String keyword;

    private Integer secretLevel;

    private String auditMan;

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag == null ? null : sendFlag.trim();
    }

    public String getSmsRemind() {
        return smsRemind;
    }

    public void setSmsRemind(String smsRemind) {
        this.smsRemind = smsRemind == null ? null : smsRemind.trim();
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important == null ? null : important.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getFromWebmailId() {
        return fromWebmailId;
    }

    public void setFromWebmailId(Integer fromWebmailId) {
        this.fromWebmailId = fromWebmailId;
    }

    public String getFromWebmail() {
        return fromWebmail;
    }

    public void setFromWebmail(String fromWebmail) {
        this.fromWebmail = fromWebmail == null ? null : fromWebmail.trim();
    }

    public String getWebmailFlag() {
        return webmailFlag;
    }

    public void setWebmailFlag(String webmailFlag) {
        this.webmailFlag = webmailFlag == null ? null : webmailFlag.trim();
    }

    public String getRecvFromName() {
        return recvFromName;
    }

    public void setRecvFromName(String recvFromName) {
        this.recvFromName = recvFromName == null ? null : recvFromName.trim();
    }

    public String getRecvFrom() {
        return recvFrom;
    }

    public void setRecvFrom(String recvFrom) {
        this.recvFrom = recvFrom == null ? null : recvFrom.trim();
    }

    public Integer getRecvToId() {
        return recvToId;
    }

    public void setRecvToId(Integer recvToId) {
        this.recvToId = recvToId;
    }

    public String getRecvTo() {
        return recvTo;
    }

    public void setRecvTo(String recvTo) {
        this.recvTo = recvTo == null ? null : recvTo.trim();
    }

    public String getIsWebmail() {
        return isWebmail;
    }

    public void setIsWebmail(String isWebmail) {
        this.isWebmail = isWebmail == null ? null : isWebmail.trim();
    }

    public String getIsWf() {
        return isWf;
    }

    public void setIsWf(String isWf) {
        this.isWf = isWf == null ? null : isWf.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(Integer secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String getAuditMan() {
        return auditMan;
    }

    public void setAuditMan(String auditMan) {
        this.auditMan = auditMan == null ? null : auditMan.trim();
    }
}