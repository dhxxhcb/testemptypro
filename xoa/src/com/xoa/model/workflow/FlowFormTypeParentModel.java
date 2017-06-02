package com.xoa.model.workflow;

import java.util.List;


/**
 * Created by eagle on 2017/6/2.
 */
public class FlowFormTypeParentModel {
    String sortName;
    List<FlowFormType> form;

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public List<FlowFormType> getForm() {
        return form;
    }

    public void setForm(List<FlowFormType> form) {
        this.form = form;
    }
}
