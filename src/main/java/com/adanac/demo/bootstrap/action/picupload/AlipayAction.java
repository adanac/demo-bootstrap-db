package com.adanac.demo.bootstrap.action.picupload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adanac.demo.bootstrap.entity.common.BootstrapPage;
import com.adanac.demo.bootstrap.entity.common.BootstrapTable;
import com.adanac.demo.bootstrap.entity.picupload.AlipayDto;
import com.adanac.demo.bootstrap.service.picupload.AlipayService;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;
import com.adanac.framework.web.controller.BaseController;
import com.alibaba.dubbo.common.json.JSON;

import net.sf.json.JSONObject;

/**
 * 图片上传(绑定支付宝)
 * 
 * @author adanac
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/picupload", produces = "text/html;charset=UTF-8")
public class AlipayAction extends BaseController {
	@Autowired
	private AlipayService alipayService;

	/**
	 * 跳转到支付宝申请
	 */
	@RequestMapping(value = "/toAlipay")
	public String toAlipay(HttpServletRequest request, ModelMap model) {
		String flag = "0";
		model.addAttribute("flag", flag);
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		model.put("basePath", basePath);
		return "pages/picupload/Alipay-apply-step.ftl";
	}

	@RequestMapping(value = "addAlipay2", produces = "text/html;charset=UTF-8")
	public void addAlipay2(HttpServletRequest request, AlipayDto alipayDto, HttpServletResponse response) {
		// 获取参数
		System.out.println("alipay:" + alipayDto.toString());
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			// 调用服务
			Boolean res = alipayService.addAlipay(alipayDto);
			if (res) {
				result.put(STATUS, SUCCESS);
				result.put(MESSAGE, "支付宝申请成功");
			} else {
				result.put(STATUS, ERROR);
				result.put(MESSAGE, "支付宝申请失败");
			}
		} catch (Exception e) {
			System.out.println("addPayAlip fail");
			result.put(STATUS, ERROR);
			result.put(MESSAGE, "支付宝申请异常");
		}
		ajaxJson(response, JSONObject.fromObject(result).toString());
	}

	/**
	 * 支付宝申请
	 * 
	 * @param paramJson
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "addAlipay", produces = "text/html;charset=UTF-8")
	public void addAlipay(@RequestParam String paramJson, HttpServletRequest request, HttpServletResponse response) {
		// 获取参数
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			paramJson = java.net.URLDecoder.decode(paramJson, "utf-8");
			AlipayDto alipayDto = JSON.parse(paramJson, AlipayDto.class);

			// 调用服务
			Boolean res = alipayService.addAlipay(alipayDto);
			if (res) {
				result.put(STATUS, SUCCESS);
				result.put(MESSAGE, "支付宝申请成功");
			} else {
				result.put(STATUS, ERROR);
				result.put(MESSAGE, "支付宝申请失败");
			}
		} catch (Exception e) {
			System.out.println("addPayAlip fail");
			result.put(STATUS, ERROR);
			result.put(MESSAGE, "支付宝申请异常");
		}
		ajaxJson(response, JSONObject.fromObject(result).toString());
	}

	/**
	 * 跳转到支付宝申请详情页面
	 */
	@RequestMapping(value = "/toAlipayApplied")
	public String toAlipayApplied(HttpServletRequest request, ModelMap model) {
		try {
			findPayDetail(request, model);// 查询支付详情
			return "pages/settings/alipay/Alipay-applied.ftl";
		} catch (Exception e) {
			System.out.println("跳转到支付宝详情页面失败:" + e.toString());
			return "";
		}
	}

	/**
	 * 跳转到支付宝编辑页面（已审核）
	 */
	@RequestMapping(value = "/toAlipayEdit", produces = "text/html;charset=UTF-8")
	public String toAlipayEdit(HttpServletRequest request, ModelMap model) {
		try {
			findPayDetail(request, model);// 查询支付详情
			return "pages/settings/alipay/Alipay-examined-edit.ftl";
		} catch (Exception e) {
			System.out.println("跳转到支付宝编辑页面失败:" + e.toString());
			return "";
		}
	}

	/**
	 * 编辑支付申请信息
	 * 
	 * @param paramJson
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "modifyAlipay", produces = "text/html;charset=UTF-8")
	public String modifyAlipay(@RequestParam String paramJson, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 获取参数
		try {
			paramJson = java.net.URLDecoder.decode(paramJson, "utf-8");
			// AlipayDto AlipayDto = JSON.parse(paramJson,
			// AlipayDto.class);
			JSONObject obj = new JSONObject().fromObject(paramJson);
			AlipayDto AlipayDto = (AlipayDto) JSONObject.toBean(obj, AlipayDto.class);
			JSONObject jsonObj = JSONObject.fromObject(paramJson);
			AlipayDto.setId(Integer.parseInt((String) jsonObj.get("id")));

			// 调用服务
			Boolean res = alipayService.modifyPayAlip(AlipayDto);
			if (res) {
				result.put(STATUS, SUCCESS);
				result.put(MESSAGE, "修改支付宝申请成功");
			} else {
				result.put(STATUS, ERROR);
				result.put(MESSAGE, "修改支付宝申请失败,或PID已存在");
			}
		} catch (Exception e) {
			System.out.println("修改支付宝申请失败:" + e.toString());
		}
		return ajaxJson(response, JSONObject.fromObject(result).toString());
	}

	/**
	 * 跳转到支付宝编辑页面（被驳回）
	 */
	@RequestMapping(value = "/toAlipayReject", produces = "text/html;charset=UTF-8")
	public String toAlipayReject(HttpServletRequest request, ModelMap model) {
		try {
			findPayDetail(request, model);// 查询支付详情
			return "pages/settings/alipay/Alipay-rejected.ftl";
		} catch (Exception e) {
			System.out.println("跳转到支付宝驳回页面失败:" + e.toString());
			return "";
		}
	}

	/**
	 * 查询支付详情信息
	 */
	public void findPayDetail(HttpServletRequest request, ModelMap model) {
		try {
			// 参数封装
			String id = request.getParameter("id");
			// 根据id查询支付详情信息
			AlipayDto AlipayDto = alipayService.findAlipayById(id);
			if (null == AlipayDto || "".equals(AlipayDto)) {
				AlipayDto = new AlipayDto();
			}
			model.put("alip", AlipayDto);
		} catch (Exception e) {
			System.out.println("查询支付详情失败:" + e.toString());
		}
	}

	/**
	 * 查询支付宝列表
	 */
	@ResponseBody
	@RequestMapping(value = "alipayList")
	public String alipayList(HttpServletRequest request, HttpServletResponse response, AlipayDto alipay,
			BootstrapPage page) {
		try {
			PagerParam param = new PagerParam();
			param.setPageNumber(page.getPageNumber());
			param.setPageSize(page.getPageSize());
			// 参数封装
			AlipayDto condition = new AlipayDto();
			condition.setAccount("tb@tb.com");
			Pager<AlipayDto> pager = alipayService.findAlipayList(condition, param);
			List<AlipayDto> infoList = pager.getDatas();

			BootstrapTable<AlipayDto> data = new BootstrapTable<AlipayDto>(infoList,
					pager.getTotalDataCount() == null ? 0 : pager.getTotalDataCount(), pager.getPageNumber());

			return JSONObject.fromObject(data).toString();
		} catch (Exception e) {
			System.out.println("查询支付列表失败:" + e.toString());
			return "";
		}
	}

}
