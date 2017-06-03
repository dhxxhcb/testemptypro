package com.xoa.service.file;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by eagle on 2017/6/3.
 */
public class FileSortResetAuth {

    public Map<String,String> param;

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }

    public FileSortResetAuth() {
        this.param = new HashedMap();
    }

    public FileSortResetAuth reset(String key, Map<String,String> mmp){
        if(mmp==null){
            return this;
        }
        StringBuffer stringBuffer =new StringBuffer();
        String deptstr,rolestr,userStr;
        //部门||角色||用户
        if(mmp.containsKey("dept")){
            deptstr=mmp.get("dept");
            stringBuffer.append(deptstr);
            stringBuffer.append("|");
        }else{
            stringBuffer.append("|");
        }
        if(mmp.containsKey("role")){
            rolestr=mmp.get("role");
            stringBuffer.append(rolestr);
            stringBuffer.append("|");
        }else{
            stringBuffer.append("|");
        }
        if(mmp.containsKey("user")){
            userStr=mmp.get("user");
            stringBuffer.append(userStr);
        }else{
        }
        param.put(key,stringBuffer.toString());
        return this;
    }
}
