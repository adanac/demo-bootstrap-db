package com.adanac.demo.bootstrap.action.pubapply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.adanac.demo.bootstrap.entity.common.BootstrapTable;
import com.adanac.demo.bootstrap.entity.pubapply.PubApplyDto;
import com.adanac.demo.bootstrap.entity.pubapply.PubApplyQueryDto;
import com.adanac.demo.bootstrap.service.pubapply.PubApplyService;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.page.Pager;
import com.adanac.framework.page.PagerParam;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/pubapply", produces = "text/html;charset=UTF-8")
public class PubApplyAction {

	@Autowired
	private PubApplyService pubApplyService;

	private static final MyLogger logger = MyLoggerFactory.getLogger(PubApplyAction.class);

	/**
	 * 跳转到服务申请查询
	 */
	@RequestMapping(value = "/toPubapply")
	public ModelAndView toPubapply() {
		return new ModelAndView("pages/pubapply/Public_apply.ftl");
	}

	/**
	 * 查询服务申请列表
	 */
	@ResponseBody
	@RequestMapping(value = "pubApplyList")
	public String pubApplyList(HttpServletRequest request, HttpServletResponse response, PubApplyQueryDto query,
			Integer page, Integer paging) {
		logger.info(
				"pubApplyList====queryAttr====>pubApply:" + query.toString() + ",page:" + page + ",paging:" + paging);
		PagerParam param = new PagerParam();
		Pager<PubApplyDto> pubApplies = pubApplyService.queryPubApplyPage(query, param.getPageNumber(),
				param.getPageSize());
		List<PubApplyDto> pubApplyList = pubApplies.getDatas();
		BootstrapTable<PubApplyDto> bootstrapTab = new BootstrapTable<>();
		bootstrapTab.setRows(pubApplyList);
		bootstrapTab.setTotal(pubApplies.getTotalDataCount());
		return JSONObject.fromObject(bootstrapTab).toString();
	}

	/**
	 * 跳转到服务申请页面
	 */
	@RequestMapping(value = "/toReg")
	public String toReg(HttpServletRequest request, ModelMap model) {
		String id = request.getParameter("id");
		model.put("id", id);
		return "pages/pubapply/Wechat-register.ftl";
	}

}
