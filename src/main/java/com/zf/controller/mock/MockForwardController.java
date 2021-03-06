package com.zf.controller.mock;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zf.utils.GlobalConstants;

@Controller
public class MockForwardController {
	
	@RequestMapping(value = "/**")
	public String main(HttpServletRequest request) throws IOException {
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		request.setAttribute(GlobalConstants.REQUEST_PATH_KEY, path);
		return "forward:/mock";
	}
	
}
