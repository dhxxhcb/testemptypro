package com.xoa.model.workflow;

import java.io.Serializable;

/**
 * Created by 张勇 on 2017/6/5.
 */
public class FlowTiggerModel implements Serializable {
//    private  static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    private  Integer id;

    /**
     * 触发器名称
     */
    private String name;

    /**
     * 流程ID
     */
    private Integer flowId;

    /**
     * 步骤ID
     */
    private Integer flowPrcs;

    /**
     * 触发节点
     */
    private String pluginType;

    /**
     * 执行方式
     */
    private String pluginWay;

    /**
     * 已启用的插件，新插件为文件夹名，老插件为文件名
     */
    private String plugin;

    /**
     * 是否已启用：0未启用，1已启用
     */
    private Integer actived;

    /**
     * 排序号
     */
    private Integer sortId;

    /**
     * 描述
     */
    private  String  description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getFlowPrcs() {
        return flowPrcs;
    }

    public void setFlowPrcs(Integer flowPrcs) {
        this.flowPrcs = flowPrcs;
    }

    public String getPluginType() {
        return pluginType;
    }

    public void setPluginType(String pluginType) {
        this.pluginType = pluginType;
    }

    public String getPluginWay() {
        return pluginWay;
    }

    public void setPluginWay(String pluginWay) {
        this.pluginWay = pluginWay;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public Integer getActived() {
        return actived;
    }

    public void setActived(Integer actived) {
        this.actived = actived;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
