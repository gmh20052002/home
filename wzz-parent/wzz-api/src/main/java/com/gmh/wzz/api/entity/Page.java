package com.gmh.wzz.api.entity;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Page<T>-分页对象，用于分页查询返回值")
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分页结果集，<object>是泛型，比如：WzzWifiShopEntity")
	private List<T> datas;
	@ApiModelProperty(value = "起始页，当前页，默认值为1")
	private int pageIndex = 1;
	@ApiModelProperty(value = "每页最大记录数，默认值为10")
	private int pageSize = 10;
	@ApiModelProperty(value = "总记录数，默认值为0")
	private long totalSize = 0;
	@ApiModelProperty(value = "总页数，默认值为-1")
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
