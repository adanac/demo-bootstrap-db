package com.adanac.demo.bootstrap.dao.picupload;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanac.demo.bootstrap.dao.common.BaseDao;
import com.adanac.demo.bootstrap.entity.constant.CodeConst;
import com.adanac.demo.bootstrap.entity.picupload.PubNum;
import com.adanac.framework.dac.util.DacUtils;
import com.adanac.framework.exception.SysException;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.alibaba.fastjson.JSONObject;

@Service
public class PubNumBaseServiceImpl implements PubNumBaseService {

	@Autowired
	private BaseDao baseDao;
	MyLogger log = MyLoggerFactory.getLogger(PubNumBaseServiceImpl.class);

	/**
	 * 查询微信公众号设置
	 */
	@Override
	public PubNum getPubNum(Long companyId) {
		log.info("PubNumBaseServiceImpl====>getPubNum====>params-->companyId:" + companyId);
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("companyId", companyId);
			return baseDao.queryForObject("PubNum.SelectPubNumList", map, PubNum.class);
		} catch (Exception e) {
			log.error("PubNumBaseServiceImpl====>getPubNum====>error:" + e);
			return null;
		}
	}

	/**
	 * 新增微信公众号设置
	 */
	@Override
	public Long addPubNum(PubNum pubNum) {
		log.info("PubNumBaseServiceImpl-->addPubNum,params-->pubNumDto:" + JSONObject.toJSONString(pubNum));
		try {
			Map<String, Object> paramMap = DacUtils.convertToMap(pubNum);
			return baseDao.execute4PrimaryKey("PubNum.AddPubNum", paramMap).longValue();
		} catch (Exception e) {
			log.error("PubNumBaseServiceImpl-->addPubNum: " + JSONObject.toJSONString(pubNum) + e);
			throw new SysException(CodeConst.CODE_ERROR, e.getMessage());
		}
	}

	/**
	 * 修改微信公众号设置
	 */
	@Override
	public int modPubNum(PubNum pubNum) {
		log.info("PubNumBaseServiceImpl-->modPubNum-->pubNum:" + JSONObject.toJSONString(pubNum));
		try {
			Map<String, Object> paramMap = DacUtils.convertToMap(pubNum);
			return baseDao.execute("PubNum.UpdatePubNum", paramMap);
		} catch (Exception e) {
			log.error("PubNumBaseServiceImpl-->modPubNum: " + JSONObject.toJSONString(pubNum) + e);
			throw new SysException(CodeConst.CODE_ERROR, e.getMessage());
		}
	}
}