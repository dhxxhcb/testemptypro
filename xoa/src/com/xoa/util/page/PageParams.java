package com.xoa.util.page;

/**
 * 分页插件
 * @author 34910
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
	 * 是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
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
	 * 当前页
	 * @return
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 当前页
	 * @param page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 每页限制条数
	 * @return
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 每页限制条数
	 * @param pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 是否启动插件，如果不启动，则不作分页
	 * @return
	 */
	public Boolean getUseFlag() {
		return useFlag;
	}

	/**
	 * 是否启动插件，如果不启动，则不作分页
	 * @param useFlag
	 */
	public void setUseFlag(Boolean useFlag) {
		this.useFlag = useFlag;
	}

	/**
	 * 是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
	 * @return
	 */
	public Boolean getCheckFlag() {
		return checkFlag;
	}

	/**
	 * 是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
	 * @param checkFlag
	 */
	public void setCheckFlag(Boolean checkFlag) {
		this.checkFlag = checkFlag;
	}

	/**
	 * 是否清除最后order by 后面的语句
	 * @return
	 */
	public Boolean getCleanOrderBy() {
		return cleanOrderBy;
	}

	/**
	 * 是否清除最后order by 后面的语句
	 * @param cleanOrderBy
	 */
	public void setCleanOrderBy(Boolean cleanOrderBy) {
		this.cleanOrderBy = cleanOrderBy;
	}

	/**
	 * 总条数
	 * @return
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 总条数
	 * @param total
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * 总页数
	 * @return
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 总页数
	 * @param totalPage
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}
