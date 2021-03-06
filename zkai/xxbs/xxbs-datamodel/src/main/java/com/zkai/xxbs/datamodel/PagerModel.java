package com.zkai.xxbs.datamodel;

import java.io.Serializable;
import java.util.List;


public class PagerModel implements Serializable {

	/**每页显示*/
	private int pageSize = 20;
	/**页码*/
	private int pageNo = 1;
	/**开始数*/
	private int start = 0;

	private List<?> result;
	/**总条数*/
	private int totalRows = 0;

	/**
	 * 排序方式 0 desc,1 asc
	 */
	private int orderBy = 0;

	private Object condition;

	public PagerModel(){

	}

	public PagerModel(int pageSize, int pageNo) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    /**
     * @param pageSize
     *          每页条数
     * @param pageNo
     *          页码（单前页码）
     * @param totalRows
     *          总条数
     * @param start
     *          开始条数
     * @param toUrl
     *          跳转的URL
     * @param result
     *          返回数据list
     */
	public PagerModel(int pageSize, int pageNo, int totalRows, int start, List<?> result){
		
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalRows = totalRows;
		this.start = start;
		this.result = result;
	}
	
    /**
     * <p>
     * 每一页的条数，默认20条
     * <p/>
     * @author LH
     */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getStart() {
		this.start = (pageNo - 1) * pageSize;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public Object getCondition() {
		return condition;
	}

	public void setCondition(Object condition) {
		this.condition = condition;
	}
	
	public int getPageCount(){
		return getTotalRows() % getPageSize() == 0 ? getTotalRows() / getPageSize() : getTotalRows() / getPageSize() + 1;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	
	/** 获取数据库名称 */
	public String getDbName() {
		return "mysql";
	}

	@Override
	public String toString() {
		return "Pager{" +
				"pageSize=" + pageSize +
				", pageNo=" + pageNo +
				", start=" + start +
				", result=" + result +
				", totalRows=" + totalRows +
				", orderBy=" + orderBy +
				", condition=" + condition +
				'}';
	}
}
