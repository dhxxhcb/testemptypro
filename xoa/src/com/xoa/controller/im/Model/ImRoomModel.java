package com.xoa.controller.im.Model;

import org.codehaus.jackson.annotate.JsonProperty;



public class ImRoomModel{
  @JsonProperty("RNAME")
   String rname;//房间名称
   @JsonProperty("ROOM_OF") 
   String room_of;//房间openfireid
   @JsonProperty("RMEMBER_UID") 
   String rmember_uid;//群成员uid串
   @JsonProperty("ROUT_UID") 
   String rout_uid;//已离开或被踢出的uid串
   @JsonProperty("RSET_UID") 
   String rset_uid;//群主uid
   @JsonProperty("RSET_OFID") 
   String rset_ofid;//群主openfireid
   @JsonProperty("RTIME") 
   String rtime;//创建时间
   @JsonProperty("TYPE") 
   String type;//是否在群成员内        判断是属于RMEMBER_UID 还是ROUT_UID
   @JsonProperty("RCHANGE") 
   String rchang;//是否允许修改房间名称    
   @JsonProperty("RINVITE") 
   String rinvite;//是否开启成员邀请       1:开启  0:关闭
   
public ImRoomModel(String rNAME, String rOOM_OF, String rMEMBER_UID,
		String rOUT_UID, String rSET_UID, String rSET_OFID, String rTIME,
		String tYPE, String rCHANGE, String rINVITE) {
	super();
	rname = rNAME;
	room_of = rOOM_OF;
	rmember_uid = rMEMBER_UID;
	rout_uid = rOUT_UID;
	rset_uid = rSET_UID;
	rset_ofid = rSET_OFID;
	rtime = rTIME;
	type = tYPE;
	rchang = rCHANGE;
	rinvite = rINVITE;
}

public String getRname() {
	return rname;
}

public void setRname(String rname) {
	this.rname = rname;
}

public String getRoom_of() {
	return room_of;
}

public void setRoom_of(String room_of) {
	this.room_of = room_of;
}

public String getRmember_uid() {
	return rmember_uid;
}

public void setRmember_uid(String rmember_uid) {
	this.rmember_uid = rmember_uid;
}

public String getRout_uid() {
	return rout_uid;
}

public void setRout_uid(String rout_uid) {
	this.rout_uid = rout_uid;
}

public String getRset_uid() {
	return rset_uid;
}

public void setRset_uid(String rset_uid) {
	this.rset_uid = rset_uid;
}

public String getRset_ofid() {
	return rset_ofid;
}

public void setRset_ofid(String rset_ofid) {
	this.rset_ofid = rset_ofid;
}

public String getRtime() {
	return rtime;
}

public void setRtime(String rtime) {
	this.rtime = rtime;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getRchang() {
	return rchang;
}

public void setRchang(String rchang) {
	this.rchang = rchang;
}

public String getRinvite() {
	return rinvite;
}

public void setRinvite(String rinvite) {
	this.rinvite = rinvite;
}
}