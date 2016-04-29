package com.adanac.demo.bootstrap.service.picupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.demo.bootstrap.dao.picupload.PubNumBaseService;
import com.adanac.demo.bootstrap.entity.common.BaseDto;
import com.adanac.demo.bootstrap.entity.constant.CodeConst;
import com.adanac.demo.bootstrap.entity.picupload.PubNum;
import com.adanac.demo.bootstrap.entity.picupload.PubNumDto;
import com.adanac.demo.bootstrap.utils.BeanUtil;
import com.adanac.demo.bootstrap.utils.DtoUtil;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.alibaba.fastjson.JSONObject;

@Service
public class PubNumberServiceImpl implements PubNumberService {

	@Autowired
	private PubNumBaseService pubNumBaseService;

	MyLogger log = MyLoggerFactory.getLogger(PubNumberServiceImpl.class);

	/**
	 * 新增微信公众号设置
	 * 
	 * @param pubNum
	 * @return
	 */
	public BaseDto addPubNum(PubNumDto pubNumDto) {
		log.info("PubnumServiceImpl-->addPubNum,params-->pubNumDto:" + JSONObject.toJSONString(pubNumDto));
		try {
			PubNum pubNum = new PubNum();
			BeanUtil.copyProperties(pubNum, pubNumDto);
			Long result = pubNumBaseService.addPubNum(pubNum);
			return DtoUtil.instanceBaseDto(result > 0, CodeConst.CODE_FAIL, "新增微信公众号设置失败", String.valueOf(result));
		} catch (Exception e) {
			return DtoUtil.instanceBaseDto(false, CodeConst.CODE_ERROR, "未知异常");
		}
	}

	/**
	 * 查询微信公众号设置
	 * 
	 * @param companyId
	 * @return
	 */
	public PubNumDto getPubNum(Long companyId) {
		log.info("PubnumServiceImpl-->getPubNum,params-->companyId:" + companyId);
		try {
			PubNumDto pubNumDto = new PubNumDto();
			PubNum pubNum = pubNumBaseService.getPubNum(companyId);
			BeanUtil.copyProperties(pubNumDto, pubNum);
			return pubNumDto;
		} catch (Exception e) {
			log.error("PubnumServiceImpl-->getPubNum: " + e);
			return null;
		}
	}

	/**
	 * 修改微信公众号设置
	 * 
	 * @param pubNum
	 * @return
	 */
	public BaseDto modPubNum(PubNumDto pubNumDto) {
		log.info("PubnumServiceImpl-->modPubNum,params-->pubNumDto:" + JSONObject.toJSONString(pubNumDto));
		try {
			PubNum pubNum = new PubNum();
			BeanUtil.copyProperties(pubNum, pubNumDto);
			int result = pubNumBaseService.modPubNum(pubNum);
			return DtoUtil.instanceBaseDto(result > 0, CodeConst.CODE_FAIL, "修改微信公众号设置失败");
		} catch (Exception e) {
			return DtoUtil.instanceBaseDto(false, CodeConst.CODE_ERROR, "未知异常");
		}
	}

}
