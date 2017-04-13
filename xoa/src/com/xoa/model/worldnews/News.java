package com.xoa.model.worldnews;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻实体类
 * @author zy
 * @version 1.0
 */
public class News implements Serializable {
	
	private static final long serialVersionUID = 6368734497100640940L;

	/**
	 * 主键ID
	 */
    private Integer newsId;

    /**
     * 新闻标题
     */
    private String subject;

    /**
     * 发布者
     */
    private String provider;

    /**
     * 发布时间
     */
    private Date newsTime;

    /**
     * 点击数
     */
    private Integer clickCount;
    
    /**
     * 评论类型(0-实名评论,1-匿名评论,2-禁止评论)
     */
    private String anonymityYn;

    /**
     * 新闻格式(0-普通格式,1-MHT格式,2-超链接)
     */
    private String format;

    /**
     * 新闻类型
     */
    private String typeId;

    /**
     * 发布标识(0-未发布,1-已发布,2-已终止)
     */
    private String publish;
    
    /**
     * 是否置顶(0-否,1-是)
     */
    private String top;
    
    /**
     * 最后编辑人
     */
    private String lastEditor;

    /**
     * 最后编辑时间
     */
    private Date lastEditTime;

    /**
     * 新闻标题颜色
     */
    private String subjectColor;

    /**
     * 内容关键词
     */
    private String keyword;

    /**
     * 限制新闻置顶时间
     */
    private String topDays;
    
    /**
     * 新闻内容
     */
    private String content;

    /**
     * 附件ID串
     */
    private String attachmentId;

    /**
     * 附件名称串
     */
    private String attachmentName;

    /**
     * 发布部门
     */
    private String toId;

    /**
     * 发布角色
     */
    private String privId;

    /**
     * 发布人员
     */
    private String userId;
    
    /**
     * 阅读人员ID串
     */
    private String readers;

    /**
     * 压缩后的新闻内容
     */
    private byte[] compressContent;

    /**
     * 新闻内容简介
     */
    private String summary;
    
    private Integer read;
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     *  主键ID
     * @return
     */
    public Integer getNewsId() {
        return newsId;
    }
    
    /**
     *  主键ID
     * @param newsId
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }
    
    /**
     * 新闻标题
     * @return
     */
    public String getSubject() {
        return subject;
    }
    
    /**
     * 新闻标题
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }
    
    /**
     * 新闻内容
     * @return
     */
    public String getProvider() {
        return provider;
    }
    
    /**
     * 新闻内容
     * @param provider
     */
    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }
    
    /**
     * 发布时间
     * @return
     */
    public Date getNewsTime() {
        return newsTime;
    }
    
    /**
     * 发布时间
     * @param newsTime
     */
    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }
    
    /**
     * 点击数
     * @return
     */
    public Integer getClickCount() {
        return clickCount;
    }
    
    /**
     * 点击数
     * @param clickCount
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }
    
    /**
     * 评论类型(0-实名评论,1-匿名评论,2-禁止评论)
     * @return
     */
    public String getAnonymityYn() {
        return anonymityYn;
    }
    
    /**
     * 评论类型(0-实名评论,1-匿名评论,2-禁止评论)
     * @param anonymityYn
     */
    public void setAnonymityYn(String anonymityYn) {
        this.anonymityYn = anonymityYn == null ? null : anonymityYn.trim();
    }

    /**
     * 新闻格式(0-普通格式,1-MHT格式,2-超链接)
     * @return
     */
    public String getFormat() {
        return format;
    }
    
    /**
     * 新闻格式(0-普通格式,1-MHT格式,2-超链接)
     * @param format
     */
    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }
    
    /**
     * 新闻类型
     * @return
     */
    public String getTypeId() {
        return typeId;
    }
    
    /**
     * 新闻类型
     * @param typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
    
    /**
     * 发布标识(0-未发布,1-已发布,2-已终止)
     * @return
     */
    public String getPublish() {
        return publish;
    }
    
    /**
     * 发布标识(0-未发布,1-已发布,2-已终止)
     * @param publish
     */
    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }
    
    /**
     * 是否置顶(0-否,1-是)
     * @return
     */
    public String getTop() {
        return top;
    }
    
    /**
     * 是否置顶(0-否,1-是)
     * @param top
     */
    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }
    
    /**
     * 最后编辑人
     * @return
     */
    public String getLastEditor() {
        return lastEditor;
    }
    
    /**
     * 最后编辑人
     * @param lastEditor
     */
    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor == null ? null : lastEditor.trim();
    }
    
    /**
     * 最后编辑时间
     * @return
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }
    
    /**
     * 最后编辑时间
     * @param lastEditTime
     */
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
    
    /**
     * 新闻标题颜色
     * @return
     */
    public String getSubjectColor() {
        return subjectColor;
    }
    
    /**
     * 新闻标题颜色
     * @param subjectColor
     */
    public void setSubjectColor(String subjectColor) {
        this.subjectColor = subjectColor == null ? null : subjectColor.trim();
    }

    /**
     * 内容关键词
     * @return
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 内容关键词
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
    
    /**
     * 限制新闻置顶时间
     * @return
     */
    public String getTopDays() {
        return topDays;
    }
    
    /**
     * 限制新闻置顶时间
     * @param topDays
     */
    public void setTopDays(String topDays) {
        this.topDays = topDays == null ? null : topDays.trim();
    }

    /**
     * 新闻内容
     * @return
     */
	public String getContent() {
		return content;
	}
	
	/**
	 * 新闻内容
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 附件ID串
	 * @return
	 */
	public String getAttachmentId() {
		return attachmentId;
	}
	
	/**
	 * 附件ID串
	 * @param attachmentId
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * 附件名称串
	 * @return
	 */
	public String getAttachmentName() {
		return attachmentName;
	}
	
	/**
	 * 附件名称串
	 * @param attachmentName
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	
	/**
	 * 发布部门
	 * @return
	 */
	public String getToId() {
		return toId;
	}
	
	/**
	 * 发布部门
	 * @param toId
	 */
	public void setToId(String toId) {
		this.toId = toId;
	}
	
	/**
	 * 发布角色
	 * @return
	 */
	public String getPrivId() {
		return privId;
	}
	
	/**
	 * 发布角色
	 * @param privId
	 */
	public void setPrivId(String privId) {
		this.privId = privId;
	}
	
	/**
	 * 发布人员
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 发布人员
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 阅读人员ID串
	 * @return
	 */
	public String getReaders() {
		return readers;
	}
	
	/**
	 * 阅读人员ID串
	 * @param readers
	 */
	public void setReaders(String readers) {
		this.readers = readers;
	}
	
	/**
	 * 压缩后的新闻内容
	 * @return
	 */
	public byte[] getCompressContent() {
		return compressContent;
	}
	
	/**
	 * 压缩后的新闻内容
	 * @param compressContent
	 */
	public void setCompressContent(byte[] compressContent) {
		this.compressContent = compressContent;
	}
	
	/**
	 * 新闻内容简介
	 * @return
	 */
	public String getSummary() {
		return summary;
	}
	
	/**
	 * 新闻内容简介
	 * @param summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
    
	public Integer getRead() {
		return read;
	}

	public void setRead(Integer read) {
		this.read = read;
	}
    
}