package com.adanac.demo.bootstrap.entity.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class BootstrapTable<T> implements Serializable {
	/**
	 */
	private static final long serialVersionUID = 6426292510680287894L;

	private long total = 0;// 总记录数
	private List<T> rows = Collections.emptyList();// 当前页数据
	private int page;// 页数

	public BootstrapTable() {
	}

	public BootstrapTable(List<T> rows, long total, int page) {
		super();
		this.rows = rows;
		this.total = total;
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
