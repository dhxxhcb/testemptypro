package com.xoa.model.enclosure;

public class AttachmentModule {
    private Byte moduleId;

    private String moduleName;

    private String moduleCode;

    public Byte getModuleId() {
        return moduleId;
    }

    public void setModuleId(Byte moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }
}