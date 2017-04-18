package com.xoa.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName (类名):  ToJson
 * @Description(简述): 存储json对象
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:58:14
 *
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
     * @Title:        ToJson
     * @author(作者):   zy
     * @Description:    构造方法
     * @param:    @param flag 0 是 true 1 是 false
     * @param:    @param msg
     * @throws
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
     * 
     * @Title: getObj
     * @Description: 需转换json对象集合
     * @author(作者):      zy
     * @param: @return   
     * @return: List<T>   对象集合
     * @throws
     */
    public List<T> getObj() {
        return obj;
    }

    /**
     * 
     * @Title: setObj
     * @Description: 需转换json对象集合
     * @author(作者):      zy
     * @param: @param obj   设置对象集合
     * @return: void   
     * @throws
     */
    public void setObj(List<T> obj) {
        this.obj = obj;
    }

    /**
     * 
     * @Title: getMsg
     * @Description: 返回消息提示
     * @author(作者):      zy
     * @param: @return   
     * @return: String   
     * @throws
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 
     * @Title: setMsg
     * @Description: 返回消息提示
     * @author(作者):      zy
     * @param: @param msg   
     * @return: void   
     * @throws
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 
     * @Title: getObject
     * @Description: 单个对象
     * @author(作者):      zy
     * @param: @return   
     * @return: Object   对象
     * @throws
     */
    public Object getObject() {
        return object;
    }

    /**
     * 
     * @Title: setObject
     * @Description: 单个对象
     * @author(作者):      zy
     * @param: @param object   设置单个对象
     * @return: void   
     * @throws
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 
     * @Title: isFlag
     * @Description: 返回信息结果标识布尔值
     * @author(作者):      zy
     * @param: @return   
     * @return: boolean   true/false
     * @throws
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * 
     * @Title: setFlag
     * @Description: 返回信息结果标识布尔值
     * @author(作者):      zy
     * @param: @param flag   true/fasle
     * @return: void   
     * @throws
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
