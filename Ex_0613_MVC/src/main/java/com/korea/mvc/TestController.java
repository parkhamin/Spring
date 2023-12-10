package com.korea.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.GreetDAO;

@Controller
public class TestController {

	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	GreetDAO gd;
	public void setGd(GreetDAO gd) {
		this.gd = gd;
	}
	
	public TestController() {
		System.out.println("테스트 컨트롤러의 기본 생성자");
	}

	@RequestMapping(value = {"/", "/test.do"} )
	public String test(HttpServletRequest request) {
		
		List<String> list = gd.greetList();
		
		//접속자의 ip를 구하자
		String ip = request.getRemoteAddr();
		
		//바인딩
		request.setAttribute("ip", ip);
		request.setAttribute("list", list);
		
		return VIEW_PATH + "test.jsp";//포워딩
	}
}
