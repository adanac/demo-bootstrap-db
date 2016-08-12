package com.adanac.demo.bootstrap.action.excel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/excel")
public class ExcelController extends MultiActionController {

	@RequestMapping(value = "/toExcel", produces = "text/html;charset=UTF-8")
	public ModelAndView toExcel() {
		return new ModelAndView("pages/excel/excel.ftl");
	}

	/**
	 * 1、文件上传
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView uploadFiles(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得上传的文件（根据前台的name名称得到上传的文件）
		MultiValueMap<String, MultipartFile> multiValueMap = multipartRequest.getMultiFileMap();
		List<MultipartFile> file = multiValueMap.get("clientFile");
		// MultipartFile file = multipartRequest.getFile("clientFile");
		if (!file.isEmpty()) {
			// 在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹
			System.out.println("=================" + file.get(0).getName() + file.get(0).getSize());
		}

		return mav;
	}

	/**
	 *
	 * @param name
	 * @param file
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("fileName") String fileName,
			@RequestParam("clientFile") MultipartFile clientFile, HttpSession session) {
		if (!clientFile.isEmpty()) {
			// 在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹
			System.out.println("=================" + clientFile.getSize());
		}
		return "";
	}

}
