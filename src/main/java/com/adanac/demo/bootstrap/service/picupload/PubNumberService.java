package com.adanac.demo.bootstrap.service.picupload;

import com.adanac.demo.bootstrap.entity.common.BaseDto;
import com.adanac.demo.bootstrap.entity.picupload.PubNumDto;

public interface PubNumberService {

	/**
	 * 新增微信公众号设置
	 * 
	 * @param pubNumDto
	 * @return
	 */
	BaseDto addPubNum(PubNumDto pubNumDto);

	/**
	 * 修改微信公众号设置
	 * 
	 * @param pubNumDto
	 * @return
	 */
	BaseDto modPubNum(PubNumDto pubNumDto);

	/**
	 * 查询微信公众号设置
	 * 
	 * @param companyId
	 * @return
	 */
	PubNumDto getPubNum(Long companyId);
}
