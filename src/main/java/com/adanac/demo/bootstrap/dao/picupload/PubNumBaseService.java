package com.adanac.demo.bootstrap.dao.picupload;

import com.adanac.demo.bootstrap.entity.picupload.PubNum;

public interface PubNumBaseService {
	/**
	 * 新增微信公众号设置
	 * 
	 * @param pubNumDto
	 * @return
	 */
	Long addPubNum(PubNum pubNum);

	/**
	 * 修改微信公众号设置
	 * 
	 * @param pubNumDto
	 * @return
	 */
	int modPubNum(PubNum pubNum);

	/**
	 * 查询微信公众号设置
	 * 
	 * @param companyId
	 * @return
	 */
	PubNum getPubNum(Long companyId);
}