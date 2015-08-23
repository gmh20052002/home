package com.gmh.wzz.api.entity;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<T> datas;
	private int pageIndex = 0;
	private int pageSize = 10;
	private long totalSize = 0;
	private int totalPage = -1;

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "Page [datas=" + datas + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + ", totalSize=" + totalSize
				+ ", totalPage=" + totalPage + "]";
	}
}
