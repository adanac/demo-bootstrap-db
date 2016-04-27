package com.adanac.demo.bootstrap.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class IndexAction {
	@RequestMapping("index")
	public String home(HttpServletRequest request, ModelMap model) {
		return "index.ftl";
	}
}
