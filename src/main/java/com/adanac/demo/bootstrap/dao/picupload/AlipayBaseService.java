package com.adanac.demo.bootstrap.dao.picupload;

import com.adanac.demo.bootstrap.entity.picupload.AlipayDto;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;

public interface AlipayBaseService {
	/**
	 * 增加三方支付服务申请
	 * 
	 * @param alipayDto
	 * @return
	 */
	int addAlipay(AlipayDto alipayDto);

	/**
	 * 修改三方支付服务申请
	 * 
	 * @param AlipayDto
	 * @return
	 */
	Boolean modAlipay(AlipayDto AlipayDto);

	/**
	 * 分页查询支付宝申请
	 * 
	 * @param searchCondition
	 * @param param
	 * @return
	 */
	Pager<AlipayDto> pageAlipay(AlipayDto condition, PagerParam param);

}
