package com.xoa.model.file;

import com.xoa.util.common.wrapper.BaseWrapper;

import java.util.List;

/**
 * Created by eagle on 2017/6/6.
 */
public class FileAuthWrapper extends BaseWrapper {
    List<String> used;
    List<FileSortModel> fileSorts;
    String nowFileSortName;

    public List<String> getUsed() {
        return used;
    }

    public void setUsed(List<String> used) {
        this.used = used;
    }

    public List<FileSortModel> getFileSorts() {
        return fileSorts;
    }

    public void setFileSorts(List<FileSortModel> fileSorts) {
        this.fileSorts = fileSorts;
    }

    public String getNowFileSortName() {
        return nowFileSortName;
    }

    public void setNowFileSortName(String nowFileSortName) {
        this.nowFileSortName = nowFileSortName;
    }
}
