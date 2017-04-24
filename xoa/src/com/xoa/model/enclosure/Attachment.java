package com.xoa.model.enclosure;
/**
 * 附件信息表
 */
public class Attachment {
    private Integer aid;

    private Byte position;

    private Byte module;

    private String ym;

    private Integer attachId;

    private String attachFile;

    private String attachName;

    private Long attachSign;

    private Byte delFlag;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Byte getPosition() {
        return position;
    }

    public void setPosition(Byte position) {
        this.position = position;
    }

    public Byte getModule() {
        return module;
    }

    public void setModule(Byte module) {
        this.module = module;
    }

    public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym == null ? null : ym.trim();
    }

    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public String getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(String attachFile) {
        this.attachFile = attachFile == null ? null : attachFile.trim();
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName == null ? null : attachName.trim();
    }

    public Long getAttachSign() {
        return attachSign;
    }

    public void setAttachSign(Long attachSign) {
        this.attachSign = attachSign;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}