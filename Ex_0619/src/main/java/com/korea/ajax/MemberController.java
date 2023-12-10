package com.korea.ajax;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import vo.MemberVO;

@Controller
public class MemberController {

	public static final String PATH = "/WEB-INF/views/";
	
	MemberDAO member_dao;
	public MemberController(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	@RequestMapping(value={"/", "/list.do"})
	public String selectList(Model model) {
		List<MemberVO> list = member_dao.selectAll();
		
		//회원목록 바인딩
		model.addAttribute("list", list);
		return PATH + "member_list.jsp";//특정 jsp로 화면 전환(포워딩)
	}
	
	//회원가입 폼으로 이동
	@RequestMapping("/member_insert_form.do")
	public String moveInsertForm() {
		return PATH + "member_insert_form.jsp";
	}
	
	//회원가입
	@RequestMapping("/insert.do")
	public String insertUser(MemberVO vo) {
		
		int res = member_dao.insertUser(vo);
		return "redirect:list.do";
	}
	
	//아이디 중복체크를 위한 메서드
	@RequestMapping("/check_id.do")
	@ResponseBody //Ajax로 요청받은 url매핑은 작업완료후 콜백 메서드로 돌아가기 위해 어노테이션 사용
	public String check_id( String id ) {
		MemberVO vo = member_dao.checkId( id );
		
		String result = "no";
		if( vo != null ) {
			result = "yes";//아이디가 중복될 경우
		}
		
		return result;//result값을 가지고 콜백 메서드로 복귀
	}
	
	//회원삭제
	@RequestMapping("/member_del.do")
	@ResponseBody
	public String memberDel(int idx) {
		int res = member_dao.deleteMember(idx);
		return String.valueOf(res);//정수를 문자열로 바꿔서 콜백으로 전달
	}
}


















