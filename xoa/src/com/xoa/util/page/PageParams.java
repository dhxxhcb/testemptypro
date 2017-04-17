package com.xoa.util.page;

/**
 * 
 * @ClassName (类名):  PageParams
 * @Description(简述): 分页插件工具
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:44:17
 *
 */
public class PageParams {
	/**
	 * 当前页
	 */
	private Integer page;
	
	/**
	 * 每页限制条数
	 */
	private Integer pageSize;
	/**
	 * 是否启动插件，如果不启动，则不作分页
	 */
	private Boolean useFlag;
	/**
	 * 是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常 默认为false
	 */
	private Boolean checkFlag;
	/**
	 * 是否清除最后order by 后面的语句
	 */
	private Boolean cleanOrderBy;
	/**
	 *  总条数
	 */
	private Integer total; 
	/**
	 * 总页数
	 */
	private Integer totalPage; 

	/**
	 * 
	 * @Title: getPage
	 * @Description: 当前页
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: Integer   
	 * @throws
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 
	 * @Title: setPage
	 * @Description: 当前页
	 * @author(作者):      zy
	 * @param: @param page   
	 * @return: void   
	 * @throws
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 
	 * @Title: getPageSize
	 * @Description: 每页限制条数
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: Integer   
	 * @throws
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @Title: setPageSize
	 * @Description: 每页限制条数
	 * @author(作者):      zy
	 * @param: @param pageSize   
	 * @return: void   
	 * @throws
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * @Title: getUseFlag
	 * @Description: 是否启动插件，如果不启动，则不作分页
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: Boolean   
	 * @throws
	 */
	public Boolean getUseFlag() {
		return useFlag;
	}

	/**
	 * 
	 * @Title: setUseFlag
	 * @Description: 是否启动插件，如果不启动，则不作分页
	 * @author(作者):      zy
	 * @param: @param useFlag   
	 * @return: void   
	 * @throws
	 */
	public void setUseFlag(Boolean useFlag) {
		this.useFlag = useFlag;
	}

	/**
	 * 
	 * @Title: getCheckFlag
	 * @Description: 是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: Boolean   
	 * @throws
	 */
	public Boolean getCheckFlag() {
		return checkFlag;
	}

	/**
	 * 
	 * @Title: setCheckFlag
	 * @Description: 是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
	 * @author(作者):      zy
	 * @param: @param checkFlag   
	 * @return: void   
	 * @throws
	 */
	public void setCheckFlag(Boolean checkFlag) {
		if(checkFlag == null){
			this.checkFlag = false;
		}else{
		this.checkFlag = checkFlag;
		}
	}

	/**
	 * 
	 * @Title: getCleanOrderBy
	 * @Description: 是否清除最后order by 后面的语句
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: Boolean   
	 * @throws
	 */
	public Boolean getCleanOrderBy() {
		return cleanOrderBy;
	}

	/**
	 * 
	 * @Title: setCleanOrderBy
	 * @Description: 是否清除最后order by 后面的语句
	 * @author(作者):      zy
	 * @param: @param cleanOrderBy   
	 * @return: void   
	 * @throws
	 */
	public void setCleanOrderBy(Boolean cleanOrderBy) {
		this.cleanOrderBy = cleanOrderBy;
	}

	/**
	 * 
	 * @Title: getTotal
	 * @Description: 总条数
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: Integer   
	 * @throws
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 
	 * @Title: setTotal
	 * @Description: 总条数
	 * @author(作者):      zy
	 * @param: @param total   
	 * @return: void   
	 * @throws
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * 
	 * @Title: getTotalPage
	 * @Description: 总页数
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: Integer   
	 * @throws
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 
	 * @Title: setTotalPage
	 * @Description: 总页数
	 * @author(作者):      zy
	 * @param: @param totalPage   
	 * @return: void   
	 * @throws
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}
