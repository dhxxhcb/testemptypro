package com.xoa.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据无分页转换json
 * Created by 34910 on 2017/3/25.
 */
public class ToJson<T> {
    /**
     * 需转换json对象集合
     */
    private List<T> obj = new ArrayList<T>();

    /**
     * 单个对象
     */
    private Object object;

    /**
     * 返回信息结果标识布尔值
     */
    private boolean flag;

    /**
     * 返回消息提示
     */
    private String msg;

    /**
     *
     * @param flag 0 是 true 1 是 false
     * @param msg
     */
    public ToJson(int flag,String msg){
        if(flag==0){
            this.flag = true;
        }else{
            this.flag = false;
        }
        this.msg = msg;
    }

    /**
     *  需转换json对象集合
     * @return
     */
    public List<T> getObj() {
        return obj;
    }

    /**
     *  需转换json对象集合
     * @param obj
     */
    public void setObj(List<T> obj) {
        this.obj = obj;
    }

    /**
     * 返回消息提示
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 返回消息提示
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 单个对象
     * @return
     */
    public Object getObject() {
        return object;
    }

    /**
     * 单个对象
     * @param object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 返回信息结果标识布尔值
     * @return
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * 返回信息结果标识布尔值
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
