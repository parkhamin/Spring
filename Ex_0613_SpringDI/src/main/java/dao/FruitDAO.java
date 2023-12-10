package dao;

import java.util.ArrayList;
import java.util.List;

public class FruitDAO {
	
	public FruitDAO() {
		System.out.println("DAO의 생성자");
	}
	
	//DAO(Date Access Object) : 데이터(DB) 접근을 목표로 하는 객체
	public List<String> selectList(){
		
		//다섯개의 데이터를 DB에서 가져와 list에 담아뒀다고 가정
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("참외");
		list.add("복숭아");
		list.add("바나나");
		
		return list;
	}
}
