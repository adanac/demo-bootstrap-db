package com.adanac.demo.bootstrap.entity.pubapply;

import com.adanac.framework.page.PagerParam;

public class PubApplyQueryDto extends PagerParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7137788831863143148L;
	private String applyName;

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

}
