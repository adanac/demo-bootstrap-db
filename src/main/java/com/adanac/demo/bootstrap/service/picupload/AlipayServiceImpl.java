package com.adanac.demo.bootstrap.service.picupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.demo.bootstrap.dao.picupload.AlipayBaseService;
import com.adanac.demo.bootstrap.entity.constant.ErrorCodeConst;
import com.adanac.demo.bootstrap.entity.picupload.AlipayDto;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;

@Service
public class AlipayServiceImpl implements AlipayService {

	@Autowired
	private AlipayBaseService alipayBaseService;

	public Boolean addAlipay(AlipayDto alipayDto) {
		int flag = alipayBaseService.addAlipay(alipayDto);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AlipayDto findAlipayById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean modifyPayAlip(AlipayDto alipayDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<AlipayDto> findAlipayList(AlipayDto condition, PagerParam param) {
		try {
			Pager<AlipayDto> pageAlipay = alipayBaseService.pageAlipay(condition, param);
			return pageAlipay;
		} catch (Exception ex) {
			throw new SysException(ErrorCodeConst.CODE_ERROR, ex.getMessage());
		}

	}

}
