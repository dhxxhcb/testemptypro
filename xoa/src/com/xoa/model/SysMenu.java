package com.xoa.model;

public class SysMenu {
    private String menuId;

    private String menuName;

    private String image;

    private String menuExt;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getMenuExt() {
        return menuExt;
    }

    public void setMenuExt(String menuExt) {
        this.menuExt = menuExt == null ? null : menuExt.trim();
    }
}