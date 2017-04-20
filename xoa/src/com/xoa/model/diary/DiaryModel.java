package com.xoa.model.diary;

import java.util.Date;
/**
 * 
 * 创建作者:   杨 胜
 * 创建日期:   2017-4-19 上午10:58:29
 * 类介绍  :    工作日志表实体类 
 * 构造参数:   
 *
 */
public class DiaryModel {
	/**
	 * 唯一自增ID
	 */
    private Integer diaId;
    /**
     * 用户ID
     */
    private String userId;
   /**
    * 日志日期  '0000-00-00'
    */
    private String diaDate;
   /**
    * 最近一次的编辑时间
    */
    private String diaTime;
    /**
     * 日志类型(1-工作日志,2-个人日志)
     */
    private String diaType;
    /**
     * 日志标题
     */
    private String subject;
    /**
     * 日志内容
     */
    private String content;
    /**
     * 最近一次被点评的时间
     */
    private String lastCommentTime;
    /**
     * 是否全部共享(0-否,1-是)
     */
    private Integer toAll;
     /**
      * 是否CRM日志
      */
    private Integer crmDiary;
    /**
     * 附件ID串
     */
    private String attachmentId;
     /**
       * 附件名称串
       */
    private String attachmentName;
    /**
     * 共享用户ID串
     */
    private String toId;
    /**
     * 压缩后的日志内容
     */
    private String compressContent;
   /**
     * 阅读人员ID串
     */
    private String readers;

    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:36:20
     * 方法介绍:   日志日期 '0000-00-00'
     * 参数说明:   @return
     * @return     String
     */
    public String getDiaDate() {
		return diaDate;
	}
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:40:07
     * 方法介绍:   日志日期 '0000-00-00'
     * 参数说明:   @param diaDate
     * @return     void
     */
	public void setDiaDate(String diaDate) {
		this.diaDate = diaDate;
	}
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:40:23
     * 方法介绍:   最近一次的编辑时间
     * 参数说明:   @return
     * @return     String
     */
	public String getDiaTime() {
		return diaTime;
	}
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:40:36
     * 方法介绍:   最近一次的编辑时间
     * 参数说明:   @param diaTime
     * @return     void
     */
	public void setDiaTime(String diaTime) {
		this.diaTime = diaTime;
	}
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:40:49
     * 方法介绍:   最近一次的编辑时间
     * 参数说明:   @return
     * @return     String
     */
	public String getLastCommentTime() {
		return lastCommentTime;
	}
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:41:01
     * 方法介绍:   最近一次的编辑时间
     * 参数说明:   @param lastCommentTime
     * @return     void
     */
	public void setLastCommentTime(String lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:41:13
     * 方法介绍:   content
     * 参数说明:   @return
     * @return     String
     */
	public String getContent() {
        return content;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:41:21
     * 方法介绍:   日志内容
     * 参数说明:   @param content
     * @return     void
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:41:44
     * 方法介绍:   附件ID串
     * 参数说明:   @return
     * @return     String
     */
    public String getAttachmentId() {
        return attachmentId;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:42:06
     * 方法介绍:   附件ID串
     * 参数说明:   @param attachmentId
     * @return     void
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:42:19
     * 方法介绍:   附件名称串
     * 参数说明:   @return
     * @return     String
     */
    public String getAttachmentName() {
        return attachmentName;
    }
     /**
      * 
      * 创建作者:   杨 胜
      * 创建日期:   2017-4-19 上午10:42:32
      * 方法介绍:   附件名称串
      * 参数说明:   @param attachmentName
      * @return     void
      */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:42:45
     * 方法介绍:   共享用户ID串
     * 参数说明:   @return
     * @return     String
     */
    public String getToId() {
        return toId;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:42:56
     * 方法介绍:   共享用户ID串
     * 参数说明:   @param toId
     * @return     void
     */
    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:47:13
     * 方法介绍:   压缩后的日志内容
     * 参数说明:   @return
     * @return     byte[]
     */
    public String getCompressContent() {
        return compressContent;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:47:26
     * 方法介绍:   压缩后的日志内容
     * 参数说明:   @param compressContent
     * @return     void
     */
    public void setCompressContent(String compressContent) {
        this.compressContent = compressContent;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:47:46
     * 方法介绍:   阅读人员ID串
     * 参数说明:   @return
     * @return     String
     */
    public String getReaders() {
        return readers;
    }
     /**
      * 
      * 创建作者:   杨 胜
      * 创建日期:   2017-4-19 上午10:47:58
      * 方法介绍:   阅读人员ID串
      * 参数说明:   @param readers
      * @return     void
      */
    public void setReaders(String readers) {
        this.readers = readers == null ? null : readers.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:48:11
     * 方法介绍:   唯一自增ID
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getDiaId() {
        return diaId;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:48:24
     * 方法介绍:   唯一自增ID
     * 参数说明:   @param diaId
     * @return     void
     */
    public void setDiaId(Integer diaId) {
        this.diaId = diaId;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:48:38
     * 方法介绍:   用户ID
     * 参数说明:   @return
     * @return     String
     */
    public String getUserId() {
        return userId;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:48:50
     * 方法介绍:   用户ID
     * 参数说明:   @param userId
     * @return     void
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:49:04
     * 方法介绍:   日志类型(1-工作日志,2-个人日志)
     * 参数说明:   @return
     * @return     String
     */
    public String getDiaType() {
        return diaType;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:49:15
     * 方法介绍:   日志类型(1-工作日志,2-个人日志)
     * 参数说明:   @param diaType
     * @return     void
     */
    public void setDiaType(String diaType) {
        this.diaType = diaType == null ? null : diaType.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:56:05
     * 方法介绍:   日志类型(1-工作日志,2-个人日志)
     * 参数说明:   @return
     * @return     String
     */
    public String getSubject() {
        return subject;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:56:41
     * 方法介绍:   日志标题
     * 参数说明:   @param subject
     * @return     void
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:56:58
     * 方法介绍:   是否全部共享(0-否,1-是)
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getToAll() {
        return toAll;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:57:24
     * 方法介绍:   是否全部共享(0-否,1-是)
     * 参数说明:   @param toAll
     * @return     void
     */
    public void setToAll(Integer toAll) {
        this.toAll = toAll;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:57:47
     * 方法介绍:   是否CRM日志
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getCrmDiary() {
        return crmDiary;
    }
    /**
     * 
     * 创建作者:   杨 胜
     * 创建日期:   2017-4-19 上午10:58:00
     * 方法介绍:   是否CRM日志
     * 参数说明:   @param crmDiary
     * @return     void
     */
    public void setCrmDiary(Integer crmDiary) {
        this.crmDiary = crmDiary;
    }
}