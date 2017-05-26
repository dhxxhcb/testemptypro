package com.xoa.model.workflow;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class FlowPrintTpl {
    private Integer tId;

    private Integer flowId;

    private String tType;

    private String tName;

    private Date createTime;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType == null ? null : tType.trim();
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}