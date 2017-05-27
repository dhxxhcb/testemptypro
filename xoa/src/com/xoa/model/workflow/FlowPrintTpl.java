package com.xoa.model.workflow;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class FlowPrintTpl {
    private Integer tId;

    private Integer flowId;

    private String tType;

    private String tName;

    private Date createTime;

    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getTType() {
        return tType;
    }

    public void setTType(String tType) {
        this.tType = tType;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName ;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}