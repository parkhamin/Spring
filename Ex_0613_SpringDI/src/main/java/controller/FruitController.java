package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.FruitDAO;

//@ - 어노테이션(프로그래밍 주석)
//@override처럼 JVM에게 오버라이딩 메서드임을 빠르게 캐치하도록 정보를 제공하거나
//@Controller처럼 특수한 기능으로써 동작하게 하기 위한 키워드
@Controller
public class FruitController {
	
	public FruitController() {
		System.out.println("FruitController 생성자");
	}
	
	FruitDAO fruitDao;
	public void setFruitDao(FruitDAO fruitDao) {
		this.fruitDao = fruitDao;
		System.out.println("나는 컨트롤러가 호출한 setter야!!");
	}
	
	//url 맵핑 : 사용자가 요청한 url을 실행할 수 있도록 하는 어노테이션
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		//DAO에서 가져온 과일 정보를 컨트롤러에서 받는다
		List<String> list = fruitDao.selectList();
		
		//list를 model객체에 저장(바인딩)
		model.addAttribute("fru", list);
		return "fruit_list"; //포워딩(해당 jsp로 전화하시오)
	}
}
