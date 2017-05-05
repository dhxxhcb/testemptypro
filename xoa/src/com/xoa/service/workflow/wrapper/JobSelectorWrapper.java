package com.xoa.service.workflow.wrapper;

import com.xoa.model.workflow.FormSort;
import com.xoa.util.common.wrapper.BaseWrapper;
import com.xoa.util.common.wrapper.BaseWrappers;

import java.util.List;

/**
 * Created by 王曰岐 on 2017/5/4.
 */
public class JobSelectorWrapper extends BaseWrappers {
    List<FormSort> datasStr;

    public List<FormSort> getDatasStr() {
        return datasStr;
    }

    public void setDatasStr(List<FormSort> datasStr) {
        this.datasStr = datasStr;
    }
}
