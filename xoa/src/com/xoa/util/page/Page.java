package com.xoa.util.page;
import java.io.Serializable;
import java.util.ArrayList;  
import java.util.List;  
  
/**
 * 分页公共类
  * @author 作者:  张勇 
  * @version 版本： 1.0 
  * @parameter 
  * @since 
  * @return 
  */
public class Page<T> implements Serializable{  
	private static final long serialVersionUID = 5883950427027760135L;
	
	/**
     *  当前页数  
     */
    private int currentPage;  
    /**
     * 记录偏移量  
     */
    private int offset;  
    /**
     * 总页数  
     */
    private int totalsPage;  
    /**
     *  每页显示记录条数  
     */
    private int pageSize;  
    /**
     *  总记录条数  
     */
    private int totalsCount;  
    /**
     *  查询返回结果  
     */
    private List<T> result = new ArrayList<T>();  
    /**
     *  分页链接  
     */
    private String uri;  
    
    /**
	 *  总页数，插件会回填这个值.
	 */
	private Integer totalPage;
    
	 /**
	  *  是否启动插件，如果不启动，则不作分页
	  */
	private Boolean useFlag;
	
	/**
	 *  是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
	 */
	private Boolean checkFlag;
	
	/**
	 * 是否清除最后order by 后面的语句
	 */
	private Boolean cleanOrderBy;
	
	
      
    public Page(){}  
      
    public Page(int currentPage, int pageSize) {  
        this.currentPage = currentPage;  
        this.pageSize = pageSize;  
        this.offset = (currentPage-1)*pageSize;  
    }  
  
    /**
     * 分页链接 
     * @return
     */
    public String getUri() {  
        return uri;  
    }  
  
    /**
     * 分页链接 
     * @param uri
     */
    public void setUri(String uri) {  
        this.uri = uri;  
    }  
  
    /**
     * 当前页数 
     * @return
     */
    public int getCurrentPage() {  
        return currentPage;  
    }  
  
    /**
     * 当前页数 
     * @param currentPage
     * @throws Exception
     */
    public void setCurrentPage(int currentPage) throws Exception {  
        if (currentPage < 1) {  
            currentPage = 1;  
        }
        this.currentPage = currentPage;  
    }  
  
    
    /**
     * 总页数 
     * @return
     */
    public int getTotalsPage() {  
        try {  
            if (totalsCount % pageSize == 0) {  
                totalsPage = totalsCount / pageSize;  
            } else {  
                totalsPage = (totalsCount / pageSize) + 1;  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return totalsPage;  
    }  
  
    /**
     * 总页数 
     * @param totalsPage
     */
    public void setTotalsPage(int totalsPage) {  
        if (totalsPage < 0) {  
            totalsPage = 0;  
        }  
        this.totalsPage = totalsPage;  
    }  
  
    /**
     * 每页显示记录条数 
     * @return
     */
    public int getPageSize() {  
        return pageSize;  
    }  
  
    /**
     * 每页显示记录条数 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {  
        if (pageSize <= 0) {  
            pageSize = 20;  
        }  
        this.pageSize = pageSize;  
    }  
  
    /**
     * 总记录条数 
     * @return
     */
    public int getTotalsCount() {  
        return totalsCount;  
    }  
  
    /**
     * 总记录条数 
     * @param totalsCount
     */
    public void setTotalsCount(int totalsCount) {  
        if (totalsCount < 0) {  
            totalsCount = 0;  
        }  
        this.totalsCount = totalsCount;  
    }  
  
    /**
     * 查询返回结果 对象
     * @return
     */
    public List<T> getResult() {  
        return result;  
    }  
  
    /**
     * 查询返回结果 对象
     * @param result
     */
    public void setResult(List<T> result) {  
        this.result = result;  
    }  
  
    /**
     * 记录偏移量 
     * @return
     */
    public int getOffset() {  
        return offset;  
    }  
  
    /**
     * 记录偏移量 
     * @param offset
     */
    public void setOffset(int offset) {  
        this.offset = offset;  
    }

    /**
     * 总页数，插件会回填这个值.
     * @return
     */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * 总页数，插件会回填这个值.
	 * @param totalPage
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
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
}  