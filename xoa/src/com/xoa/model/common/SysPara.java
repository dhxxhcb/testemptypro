package com.xoa.model.common;

/**
 * 创建作者:   王曰岐
 * 创建日期:   2017-4-18 下午5:36:22
 * 类介绍   :    APP端
 * 构造参数:   无
 */
public class SysPara {
    /**
     * 参数名称
     */
    private String paraName;
    /**
     * 参数值
     */
    private String paraValue;

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午5:36:36
     * 方法介绍:   参数名称
     * 参数说明:   @return
     *
     * @return String  paraName(参数名称)
     */
    public String getParaName() {
        return paraName;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午5:43:52
     * 方法介绍:    参数名称
     * 参数说明:   @param paraName
     *
     * @return void
     */
    public void setParaName(String paraName) {
        this.paraName = paraName == null ? null : paraName.trim();
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午5:44:25
     * 方法介绍:   参数值
     * 参数说明:   @return
     *
     * @return String paraValue(参数值)
     */
    public String getParaValue() {
        return paraValue;
    }

    /**
     * 创建作者:   王曰岐
     * 创建日期:   2017-4-18 下午5:44:47
     * 方法介绍:   参数值
     * 参数说明:   @param paraValue
     *
     * @return void
     */
    public void setParaValue(String paraValue) {
        this.paraValue = paraValue == null ? null : paraValue.trim();
    }
}