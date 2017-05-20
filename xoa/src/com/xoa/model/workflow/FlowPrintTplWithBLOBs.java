package com.xoa.model.workflow;

public class FlowPrintTplWithBLOBs extends FlowPrintTpl {
    private String content;

    private String flowPrcs;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFlowPrcs() {
        return flowPrcs;
    }

    public void setFlowPrcs(String flowPrcs) {
        this.flowPrcs = flowPrcs == null ? null : flowPrcs.trim();
    }
}