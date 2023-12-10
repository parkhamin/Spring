package com.korea.vs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDAO;
import vo.VisitVO;

@Controller
public class VisitController {
	
	public static final String PATH = "/WEB-INF/views/visit/";
	
	VisitDAO visit_dao;
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	//방명록 전체목록 보기
	@RequestMapping(value={"/", "/list.do"})
	public String vsList( Model model ) {
		
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list", list);
		return PATH + "visit_list.jsp";
		
	}
	
	//새 글 쓰기 폼으로 전환
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return PATH + "visit_insert_form.jsp";		
	}
	
	//새 글 쓰기
	@RequestMapping("/insert.do")
	public String insert(VisitVO vo, HttpServletRequest request) {
		//insert.do?name=홍길동&content=내용&pwd=1111
		//입력 form에서 넘겨준 세 개의 파라미터(name, content, pwd)가 자동으로
		//vo객체에 setter를 통해 추가
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		visit_dao.insertUser(vo);
		
		//Controller에서 url매핑을 호출해야 하는 경우
		//sendRedirect("list.do");
		return "redirect:list.do";
	}
	
	//게시글 삭제
	//스프링에서 Ajax를 사용하여 값을 콜백 메서드로 return할 경우
	//retrun되는 값이 한글일 경우 깨져서 전달되기 때문에
	//produces=... <-- 속성을 넣어줘야 한다
	@RequestMapping(value="/delete.do", produces="application/json;charset=UTF-8" )
	@ResponseBody //Ajax로 요청받은 url메서드는 반드시 @ResponseBody를 가지고 있어야 한다
	public String del(int idx) {
		
		//DAO에 idx에 해당하는 게시글 삭제하는 요청
		int res = visit_dao.delUser(idx);
		
		String result = "삭제 실패";
		
		if( res != 0 ) {//삭제 성공
			result = "삭제 성공";
		}
		
		String str = String.format("[{'result':'%s'}]", result);
		
		//JSON구조의 str을 콜백메서드로 전달
		return str;
	}
	
	//글 수정을 위한 페이지로 전환
	@RequestMapping("/modify_form.do")//modify_form.do?pwd=1111&idx=4&name=홍길동&content=내용
	public String modify_form(Model model, VisitVO vo) {
		
		model.addAttribute("vo", vo);
		return PATH + "visit_modify_form.jsp";	 
		
	}
	
	//글 수정
	@RequestMapping("/modify.do")
	public String modify( VisitVO vo, HttpServletRequest request) {
		//request로 ip를 찾는다
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = visit_dao.update_modify(vo);
		
		return "redirect:list.do";
	}
}



















