package com.adanac.demo.bootstrap.service.picupload;

import com.adanac.demo.bootstrap.entity.picupload.AlipayDto;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;

public interface AlipayService {

	/**
	 * 支付宝申请
	 * 
	 * @param alipayDto
	 */
	public Boolean addAlipay(AlipayDto alipayDto);

	/**
	 * 分页查询支付宝信息列表
	 * 
	 * @param pageSize
	 * @param pageNumber
	 * @param merchantCode
	 * @return
	 */
	public Pager<AlipayDto> findAlipayList(AlipayDto alipayDto, PagerParam param);

	/**
	 * 查询支付详情信息
	 * 
	 * @param id
	 * @return
	 */
	public AlipayDto findAlipayById(String id);

	/**
	 * 修改支付申请信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public Boolean modifyPayAlip(AlipayDto alipayDto);

	/**
	 * 查询支付宝账号是否已存在
	 * 
	 * @param account
	 * @return
	 */
	public Boolean accountExist(String account);

}
