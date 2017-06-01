package com.xoa.model.netdisk;

import java.util.List;

/**
 * Created by gsb on 2017/6/1.
 */
public class MyNetdisk {
    private String  type;
    private String neName;//文件名字
    private String size;//字节数
    private  String path;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNeName() {
        return neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
