package com.xoa.model.worldnews;

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
}