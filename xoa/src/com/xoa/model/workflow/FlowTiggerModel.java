package com.xoa.model.workflow;

import java.io.Serializable;

/**
 * 触发器实体类
 * Created by 张勇 on 2017/6/5.
 */
public class FlowTiggerModel implements Serializable {
    private  static final long serialVersionUID = 1L;

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

    /**
     * 自增ID
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增ID
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 触发器名称
     * @return
     */
    public String getName() {
        return name == null ? "" : name.trim();
    }

    /**
     * 触发器名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 流程ID
     * @return
     */
    public Integer getFlowId() {
        return flowId;
    }

    /**
     * 流程ID
     * @param flowId
     */
    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    /**
     *   步骤ID
     * @return
     */
    public Integer getFlowPrcs() {
        return flowPrcs;
    }

    /**
     * 步骤ID
     * @param flowPrcs
     */
    public void setFlowPrcs(Integer flowPrcs) {
        this.flowPrcs = flowPrcs;
    }

    /**
     * 触发节点
     * @return
     */
    public String getPluginType() {
        return pluginType == null ? "":pluginType.trim();
    }

    /**
     * 触发节点
     * @param pluginType
     */
    public void setPluginType(String pluginType) {
        this.pluginType = pluginType;
    }

    /**
     * 执行方式
     * @return
     */
    public String getPluginWay() {
        return pluginWay == null ?"":pluginWay.trim();
    }

    /**
     * 执行方式
     * @param pluginWay
     */
    public void setPluginWay(String pluginWay) {
        this.pluginWay = pluginWay;
    }

    /**
     * 已启用的插件，新插件为文件夹名，老插件为文件名
     * @return
     */
    public String getPlugin() {
        return plugin == null ? "" : plugin.trim();
    }

    /**
     * 已启用的插件，新插件为文件夹名，老插件为文件名
     * @param plugin
     */
    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    /**
     * 是否已启用：0未启用，1已启用
     * @return
     */
    public Integer getActived() {
        return actived;
    }

    /**
     * 是否已启用：0未启用，1已启用
     * @param actived
     */
    public void setActived(Integer actived) {
        this.actived = actived;
    }

    /**
     * 排序号
     * @return
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * 排序号
     * @param sortId
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /**
     * 描述
     * @return
     */
    public String getDescription() {
        return description == null ? "" : description.trim();
    }

    /**
     * 描述
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
