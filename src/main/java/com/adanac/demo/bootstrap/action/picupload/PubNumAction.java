package com.adanac.demo.bootstrap.action.picupload;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adanac.demo.bootstrap.entity.common.BaseDto;
import com.adanac.demo.bootstrap.entity.constant.CodeConst;
import com.adanac.demo.bootstrap.entity.picupload.PubNumDto;
import com.adanac.demo.bootstrap.service.picupload.PubNumberService;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.web.controller.BaseController;
import com.alibaba.dubbo.common.json.JSON;

import net.sf.json.JSONObject;

/**
 * 微信公众号绑定
 * @author adanac
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/picupload", produces = "text/html;charset=UTF-8")
public class PubNumAction extends BaseController {

	@Autowired
	private PubNumberService pubNumberService;

	MyLogger log = MyLoggerFactory.getLogger(PubNumAction.class);

	/**
	 * 跳转到微信公众号绑定
	 */
	@RequestMapping(value = "/toPubBinding")
	public ModelAndView toPubBinding() {
		return new ModelAndView("pages/settings/pubnum/Public_binding.ftl");
	}

	/**
	 * 保存微信公众号
	 */
	@RequestMapping(value = "/savePubNumber", produces = "text/html;charset=UTF-8")
	public void savePubNumber(@RequestParam String paramJson, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("PubnumServiceImpl-->addPubNum-->paramJson:" + paramJson);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			paramJson = java.net.URLDecoder.decode(paramJson, "utf-8");
			PubNumDto pubNumDto = JSON.parse(paramJson, PubNumDto.class);
			BaseDto baseDto = pubNumberService.addPubNum(pubNumDto);
			if (baseDto.getStatu().equalsIgnoreCase(CodeConst.CODE_SUCCESS)) {
				result.put(STATUS, SUCCESS);
				result.put(MESSAGE, "微信公众号绑定成功");
			} else {
				result.put(STATUS, ERROR);
				result.put(MESSAGE, "微信公众号绑定失败");
			}
		} catch (Exception e) {
			log.error("addPubnum fail", e);
		}
		ajaxJson(response, JSONObject.fromObject(result).toString());
	}
}
