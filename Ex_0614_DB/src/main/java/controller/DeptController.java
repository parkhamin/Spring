package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {
	
	public static final String PATH = "/WEB-INF/views/dept/";
	
	DeptDAO dept_dao;
	public void setDept_dao(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
	}
	
	@RequestMapping(value= {"/", "/list.do"})
	public String list(Model model) {
		
		//DAO가 가져다 준 데이터를 받는다
		List<DeptVO> list = dept_dao.select();
		
		//받은 데이터를 바인딩
		model.addAttribute("d_list", list);
		
		//바인딩 된 정보를 jsp로 포워딩
		return PATH + "dept_list.jsp";
	}
}
