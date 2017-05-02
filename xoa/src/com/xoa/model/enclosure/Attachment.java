package com.xoa.model.enclosure;
/**
 * 附件信息表
 */
public class Attachment {
	/**
	 * 自增唯一Id
	 */
    private Integer aid;
    /**
	 * 位置
	 */
    private Byte position;
    /**
	 * 对应attachment_module表中模块的module_id号
	 */
    private Byte module;
    /**
	 * 年月
	 */
    private String ym;
    /**
  	 * 附件id
  	 */
    private Integer attachId;
    /**
  	 * 附件文件
  	 */
    private String attachFile;
    /**
  	 * 附件名称
  	 */
    private String attachName;
    /**
  	 * 标记
  	 */
    private Long attachSign;
    /**
  	 * 删除标记(0-未删除,1-已删除)
  	 */
    private Byte delFlag;
    
    private String attUrl;
    
    private String url;
    
    

    public String getAttUrl() {
		return attUrl;
	}

	public void setAttUrl(String attUrl) {
		this.attUrl = attUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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