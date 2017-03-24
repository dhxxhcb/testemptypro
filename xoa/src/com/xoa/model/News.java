package com.xoa.model;

import java.util.Date;

/**
 * 新闻实体类
 * @author zy
 * @version 1.0
 */
public class News {
	
	/**
	 * 主键ID
	 */
    private Integer newsId;

    /**
     * 新闻标题
     */
    private String subject;

    /**
     * 新闻内容
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

    public void setAnonymityYn(String anonymityYn) {
        this.anonymityYn = anonymityYn == null ? null : anonymityYn.trim();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }

    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor == null ? null : lastEditor.trim();
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getSubjectColor() {
        return subjectColor;
    }

    public void setSubjectColor(String subjectColor) {
        this.subjectColor = subjectColor == null ? null : subjectColor.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getTopDays() {
        return topDays;
    }

    public void setTopDays(String topDays) {
        this.topDays = topDays == null ? null : topDays.trim();
    }
}