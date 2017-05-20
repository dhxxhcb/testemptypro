package com.xoa.model.workflow;

import java.util.Date;

public class FlowQueryTpl {
    private Integer seqId;

	private String tplName;

	private String userId;

	private Integer flowId;

	private String condFormula;

	private Date createTime;

	public Integer getSeqId() {
		return seqId;
	}

	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}

	public String getTplName() {
		return tplName;
	}

	public void setTplName(String tplName) {
		this.tplName = tplName == null ? null : tplName.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	public String getCondFormula() {
		return condFormula;
	}

	public void setCondFormula(String condFormula) {
		this.condFormula = condFormula == null ? null : condFormula.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}