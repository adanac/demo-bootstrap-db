package com.adanac.demo.bootstrap.dao.picupload;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.demo.bootstrap.dao.common.BaseDao;
import com.adanac.demo.bootstrap.entity.constant.CodeConst;
import com.adanac.demo.bootstrap.entity.picupload.AlipayDto;
import com.adanac.framework.dac.util.DacUtils;
//import com.adanac.framework.dac.util.DacUtils;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;

@Service
public class AlipayBaseServiceImpl implements AlipayBaseService {

	@Autowired
	private BaseDao baseDao;

	private MyLogger log = MyLoggerFactory.getLogger(AlipayBaseServiceImpl.class);

	/**
	 * 增加三方支付服务申请
	 * 
	 * @param paySerApp
	 * @return
	 */
	@Override
	public int addAlipay(AlipayDto alipayDto) {
		log.info("AlipayBaseServiceImpl==>addAlipay==>alipayDto {}" + alipayDto.toString());
		try {
			Map<String, Object> paramMap = DacUtils.convertToMap(alipayDto);
			return baseDao.execute("PicUpload.addAlipay", paramMap);
		} catch (Exception e) {
			log.error("AlipayBaseServiceImpl-->addAlipay: " + alipayDto.getId() + e);
			throw new SysException(CodeConst.CODE_ERROR, e.getMessage());
		}
	}

	/**
	 * 修改三方支付服务申请
	 * 
	 * @param paySerApp
	 * @return
	 */
	@Override
	public Boolean modAlipay(AlipayDto alipayDto) {
		log.info("AlipayBaseServiceImpl==>modAlipay==>alipayDto {}" + alipayDto.toString());
		try {
			Map<String, Object> paramMap = DacUtils.convertToMap(alipayDto);
			int tag = baseDao.execute("PicUpload.modAlipay", paramMap);
			if (tag > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			log.error("AlipayBaseServiceImpl-->modAlipay: " + alipayDto.getId() + e);
			throw new SysException(CodeConst.CODE_ERROR, e.getMessage());
		}
	}

	@Override
	public Pager<AlipayDto> pageAlipay(AlipayDto searchCondition, PagerParam param) {
		log.info("AlipayBaseServiceImpl==>pageAlipay==>searchCondition {}" + searchCondition.toString());
		try {
			Map<String, Object> map = DacUtils.convertToMap(searchCondition);
			return baseDao.queryForPage("PicUpload.pageAlipay", map, AlipayDto.class, param.getPageSize(),
					param.getPageNumber());
		} catch (Exception ex) {
			log.error("AlipayBaseServiceImpl-->pageAlipay: " + searchCondition);
			throw new SysException(CodeConst.CODE_ERROR, ex.getMessage());
		}
	}

}
