package com.adanac.demo.bootstrap.service.picupload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adanac.demo.bootstrap.dao.common.BaseDao;
import com.adanac.demo.bootstrap.dao.picupload.AlipayBaseService;
import com.adanac.demo.bootstrap.entity.constant.CodeConst;
import com.adanac.demo.bootstrap.entity.picupload.AlipayDto;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;

@Service
public class AlipayServiceImpl implements AlipayService {

	@Autowired
	private AlipayBaseService alipayBaseService;
	@Autowired
	private BaseDao baseDao;

	/**
	 * 增加申请
	 */
	@Override
	@Transactional
	public Boolean addAlipay(AlipayDto alipayDto) {
		try {

			int result1 = alipayBaseService.addAlipay(alipayDto);
			if (result1 == CodeConst.RESUTL_SUCCESS) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new SysException(CodeConst.CODE_ERROR, e.getMessage());
		}
	}

	@Override
	public AlipayDto findAlipayById(String id) {
		return null;
	}

	@Override
	public Boolean modifyPayAlip(AlipayDto alipayDto) {
		return null;
	}

	@Override
	public Pager<AlipayDto> findAlipayList(AlipayDto condition, PagerParam param) {
		try {
			Pager<AlipayDto> pageAlipay = alipayBaseService.pageAlipay(condition, param);
			return pageAlipay;
		} catch (Exception ex) {
			throw new SysException(CodeConst.CODE_ERROR, ex.getMessage());
		}

	}

	@Override
	public Boolean accountExist(String account) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("account", account);
		List<AlipayDto> alipayList = baseDao.queryForList("PicUpload.findAlipayByAccount", paramMap, AlipayDto.class);
		if (alipayList != null && alipayList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
