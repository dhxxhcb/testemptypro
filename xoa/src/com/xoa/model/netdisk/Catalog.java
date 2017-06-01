package com.xoa.model.netdisk;

import java.util.List;

/**
 * Created by gsb on 2017/6/1.
 */
public class Catalog {
    private String catalogName;
    private String catalogPath;
    private  String catalogSize;
    private int catalogcount;
    private List<MyNetdisk>  myNetdiskList;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogPath() {
        return catalogPath;
    }

    public void setCatalogPath(String catalogPath) {
        this.catalogPath = catalogPath;
    }

    public int getCatalogcount() {
        return catalogcount;
    }

    public void setCatalogcount(int catalogcount) {
        this.catalogcount = catalogcount;
    }

    public List<MyNetdisk> getMyNetdiskList() {
        return myNetdiskList;
    }

    public void setMyNetdiskList(List<MyNetdisk> myNetdiskList) {
        this.myNetdiskList = myNetdiskList;
    }

    public String getCatalogSize() {
        return catalogSize;
    }

    public void setCatalogSize(String catalogSize) {
        this.catalogSize = catalogSize;
    }
}
