package com.xoa.model.users;

public class OrgManage {
	/**
	 * 唯一自增ID
	 */
    private Integer oid;
    /**
     * 单位名称
     */
    private String version;
    /**
     * 版本信息
     */
    private String isOrg;
    /**
     * 是否组织
     */
    private String name;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getIsOrg() {
        return isOrg;
    }

    public void setIsOrg(String isOrg) {
        this.isOrg = isOrg == null ? null : isOrg.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}