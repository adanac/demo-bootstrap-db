package com.adanac.demo.bootstrap.entity.common;

public class BootstrapPage {

	private int offset = 1;// 当前第几页
	private int limit = 10;// 每页记录数

	public int getPageNumber() {
		int pageIndex = 0;
		if (offset != 0) {
			pageIndex = offset / limit;
		}
		pageIndex += 1;// 第几页<
		return pageIndex;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
