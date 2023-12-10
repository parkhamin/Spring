package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.FriendDAO;

@Controller
public class FriendController {

	FriendDAO fdao;

	public FriendController(FriendDAO fdao) {
		this.fdao = fdao;
	}
	
	@RequestMapping("/flist.do")
	public String list(Model model) {
		List<String> flist = fdao.friendList();
		//친구 목록을 바인딩
		model.addAttribute("flist", flist);
		
		return "fruit_list";
	}
}
