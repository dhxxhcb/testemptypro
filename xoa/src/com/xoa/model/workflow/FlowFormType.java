package com.xoa.model.workflow;

import java.io.Serializable;
   /**
    * 
    * 创建作者:   王曰岐
    * 创建日期:   2017-5-8 上午11:18:22
    * 类介绍  :    
    * 构造参数:   
    *
    */
public class FlowFormType implements Serializable {
	
	protected static final long serialVersionUID = 1L;
    /**
     * 表单ID
     */
	protected Integer formId;
	/**
     * 表单名称
     */
    protected String formName;  
    /**
     * 表单所属部门
     */
    protected Integer deptId;
    /**
     * 最大的项目编号
     */
    protected Integer itemMax;
    /**
     * 表单所属分类
     */
    protected Integer formSort;
    /**
     * 表单类型 1 - 新表单 0 - 老表单
     */
    protected Integer isNew;
    /**
     * 表单设计信息
     */
    protected String printModel;
    /**
     * 精简后的表单设计信息
     */
    protected String printModelShort;
    /**
     * 表单拓展脚本
     */
    protected String script;
    /**
     * 表单扩展样式
     */
    protected String css;

       /**
        *  部门名称
        */
    protected String depName;

       /**
        * 分类名称
        */
    protected String sortName;
       public String getSortName() {
           return sortName==null?"未分类":sortName;
       }

       public void setSortName(String sortName) {
           this.sortName = sortName;
       }

       public String getDepName() {
           if(depName==null){
               depName="全部部门";
           }
           return depName;
       }

       public void setDepName(String depName) {
           this.depName = depName;
       }

       /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:21:31
     * 方法介绍:   表单设计信息
     * 参数说明:   @return
     * @return     String
     */
    
    public String getPrintModel() {

        return printModel==null?"":printModel;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:21:43
     * 方法介绍:   表单ID
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getFormId() {
        return formId;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:21:54
     * 方法介绍:   表单ID
     * 参数说明:   @param formId
     * @return     void
     */
    public void setFormId(Integer formId) {
        this.formId = formId;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:22:13
     * 方法介绍:   表单名称
     * 参数说明:   @return
     * @return     String
     */
    public String getFormName() {
        return formName;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:22:24
     * 方法介绍:   表单名称
     * 参数说明:   @param formName
     * @return     void
     */
    public void setFormName(String formName) {
        this.formName = formName == null ? "" : formName.trim();
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:22:33
     * 方法介绍:   表单所属部门
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getDeptId() {
        return deptId==null?0:deptId;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:22:42
     * 方法介绍:   表单所属部门
     * 参数说明:   @param deptId
     * @return     void
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:22:52
     * 方法介绍:   最大的项目编号
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getItemMax() {
        return itemMax==null?0:itemMax;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:23:02
     * 方法介绍:   最大的项目编号
     * 参数说明:   @param itemMax
     * @return     void
     */
    public void setItemMax(Integer itemMax) {
        this.itemMax = itemMax;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:23:09
     * 方法介绍:   表单所属分类
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getFormSort() {
        return formSort==null?0:formSort;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:23:18
     * 方法介绍:   表单所属分类
     * 参数说明:   @param formSort
     * @return     void
     */
    public void setFormSort(Integer formSort) {
        this.formSort = formSort;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:23:26
     * 方法介绍:   表单类型 1 - 新表单 0 - 老表单
     * 参数说明:   @return
     * @return     Integer
     */
    public Integer getIsNew() {
        return isNew==null?0:isNew;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:23:35
     * 方法介绍:   表单类型 1 - 新表单 0 - 老表单
     * 参数说明:   @param isNew
     * @return     void
     */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:23:50
     * 方法介绍:   表单设计信息
     * 参数说明:   @param printModel
     * @return     void
     */
    public void setPrintModel(String printModel) {
        this.printModel = printModel == null ? "" : printModel.trim();
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:23:58
     * 方法介绍:   表单设计信息
     * 参数说明:   @return
     * @return     String
     */
    public String getPrintModelShort() {
        return printModelShort==null?"":printModelShort;
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:24:10
     * 方法介绍:   精简后的表单设计信息
     * 参数说明:   @param printModelShort
     * @return     void
     */
    public void setPrintModelShort(String printModelShort) {
        this.printModelShort = printModelShort == null ? "" : printModelShort.trim();
    }
     /**
      * 
      * 创建作者:   王曰岐
      * 创建日期:   2017-5-8 上午11:24:19
      * 方法介绍:   表单拓展脚本
      * 参数说明:   @return
      * @return     String
      */
    public String getScript() {
        return script == null ? "" : script.trim();
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:24:27
     * 方法介绍:   表单拓展脚本
     * 参数说明:   @param script
     * @return     void
     */
    public void setScript(String script) {
        this.script = script == null ? "" : script.trim();
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:24:37
     * 方法介绍:   表单扩展样式
     * 参数说明:   @return
     * @return     String
     */
    public String getCss() {
        return css== null ? "" : css.trim();
    }
    /**
     * 
     * 创建作者:   王曰岐
     * 创建日期:   2017-5-8 上午11:24:45
     * 方法介绍:   表单扩展样式
     * 参数说明:   @param css
     * @return     void
     */
    public void setCss(String css) {
        this.css = css == null ? "" : css.trim();
    }
}