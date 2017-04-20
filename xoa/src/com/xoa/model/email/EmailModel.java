package com.xoa.model.email;

import java.io.Serializable;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午10:46:22
 * 类介绍  :   收件人实体类
 * 构造参数:   
 *
 */
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1076969159692234636L;

	/**
	 * 自增唯一ID
	 */
	private Integer emailId;
	
	/**
	 * 收件人USER_ID
	 */
	private String toId;
	
	/**
	 * 邮件读取状态(0-未读,1-已读)
	 */
	private String readFlag;
	
	/**
	 * 邮件删除状态
	 */
	private String deleteFlag;
	
	/**
	 * 邮件箱分类ID
	 */
	private Integer boxId;

	/**
	 * 邮件体ID
	 */
	private Integer bodyId;

	/**
	 * 是否请求阅读收条(0-不请求,1-请求)
	 */
	private String receipt;
	
	/**
	 * 是否转发(0-未转发,1-已转发)
	 */
	private String isF;
	
	/**
	 * 是否回复(0-未回复,1-已回复)
	 */
	private String isR;
	
	/**
	 * 星标标记(0-无,1-灰,2-绿,3-黄,4-红)
	 */
	private String sign;
	
	/**
	 * 一对多关联 EmailBody
	 */
	private EmailBodyModel emailBody;

	/**
	 * 一对多关联 EmailBody
	 * @return
	 */
	public EmailBodyModel getEmailBody() {
		return emailBody;
	}
	
	/**
	 * 一对多关联 EmailBody
	 * @param emailBody
	 */
	public void setEmailBody(EmailBodyModel emailBody) {
		this.emailBody = emailBody;
	}
	
	/**
	 * 自增唯一ID
	 * @return
	 */
	public Integer getEmailId() {
		return emailId;
	}
	
	/**
	 * 自增唯一ID
	 * @param emailId
	 */
	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * 收件人USER_ID
	 * @return
	 */
	public String getToId() {
		return toId;
	}
	
	/**
	 * 收件人USER_ID
	 * @param toId
	 */
	public void setToId(String toId) {
		this.toId = toId == null ? null : toId.trim();
	}
	
	/**
	 * 邮件读取状态(0-未读,1-已读)
	 * @return
	 */
	public String getReadFlag() {
		return readFlag;
	}

	/**
	 * 邮件读取状态(0-未读,1-已读)
	 * @param readFlag
	 */
	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag == null ? null : readFlag.trim();
	}
	
	/**
	 * 邮件删除状态
	 * @return
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 邮件删除状态
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
	}

	/**
	 * 邮件箱分类ID
	 * @return
	 */
	public Integer getBoxId() {
		return boxId;
	}

	/**
	 * 邮件箱分类ID
	 * @param boxId
	 */
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}

	/**
	 * 邮件体ID
	 * @return
	 */
	public Integer getBodyId() {
		return bodyId;
	}
	
	/**
	 * 邮件体ID
	 * @param bodyId
	 */
	public void setBodyId(Integer bodyId) {
		this.bodyId = bodyId;
	}

	/**
	 * 是否请求阅读收条(0-不请求,1-请求)
	 * @return
	 */
	public String getReceipt() {
		return receipt;
	}

	/**
	 * 是否请求阅读收条(0-不请求,1-请求)
	 * @param receipt
	 */
	public void setReceipt(String receipt) {
		this.receipt = receipt == null ? null : receipt.trim();
	}

	/**
	 * 是否转发(0-未转发,1-已转发)
	 * @return
	 */
	public String getIsF() {
		return isF;
	}
	
	/**
	 * 是否转发(0-未转发,1-已转发)
	 * @param isF
	 */
	public void setIsF(String isF) {
		this.isF = isF == null ? null : isF.trim();
	}

	/**
	 * 是否回复(0-未回复,1-已回复)
	 * @return
	 */
	public String getIsR() {
		return isR;
	}

	/**
	 * 是否回复(0-未回复,1-已回复)
	 * @param isR
	 */
	public void setIsR(String isR) {
		this.isR = isR == null ? null : isR.trim();
	}

	/**
	 * 星标标记(0-无,1-灰,2-绿,3-黄,4-红)
	 * @return
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 星标标记(0-无,1-灰,2-绿,3-黄,4-红)
	 * @param sign
	 */
	public void setSign(String sign) {
		this.sign = sign == null ? null : sign.trim();
	}
}