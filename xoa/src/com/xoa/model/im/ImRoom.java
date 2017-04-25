package com.xoa.model.im;

import com.xoa.util.page.PageParams;

public class ImRoom extends PageParams{
    private Integer rid;

    private String rnamr;

    private String rsetUid;

    private String rsetOfid;

    private String rtime;

    private String rmemberUid;

    private String rmemberOfid;

    private String routUid;

    private String routOfid;

    private String rinvite;

    private String rchange;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRnamr() {
        return rnamr;
    }

    public void setRnamr(String rnamr) {
        this.rnamr = rnamr == null ? null : rnamr.trim();
    }

    public String getRsetUid() {
        return rsetUid;
    }

    public void setRsetUid(String rsetUid) {
        this.rsetUid = rsetUid == null ? null : rsetUid.trim();
    }

    public String getRsetOfid() {
        return rsetOfid;
    }

    public void setRsetOfid(String rsetOfid) {
        this.rsetOfid = rsetOfid == null ? null : rsetOfid.trim();
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime == null ? null : rtime.trim();
    }

    public String getRmemberUid() {
        return rmemberUid;
    }

    public void setRmemberUid(String rmemberUid) {
        this.rmemberUid = rmemberUid == null ? null : rmemberUid.trim();
    }

    public String getRmemberOfid() {
        return rmemberOfid;
    }

    public void setRmemberOfid(String rmemberOfid) {
        this.rmemberOfid = rmemberOfid == null ? null : rmemberOfid.trim();
    }

    public String getRoutUid() {
        return routUid;
    }

    public void setRoutUid(String routUid) {
        this.routUid = routUid == null ? null : routUid.trim();
    }

    public String getRoutOfid() {
        return routOfid;
    }

    public void setRoutOfid(String routOfid) {
        this.routOfid = routOfid == null ? null : routOfid.trim();
    }

    public String getRinvite() {
        return rinvite;
    }

    public void setRinvite(String rinvite) {
        this.rinvite = rinvite == null ? null : rinvite.trim();
    }

    public String getRchange() {
        return rchange;
    }

    public void setRchange(String rchange) {
        this.rchange = rchange == null ? null : rchange.trim();
    }
}