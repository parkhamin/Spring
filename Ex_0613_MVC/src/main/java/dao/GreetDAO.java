package dao;

import java.util.ArrayList;
import java.util.List;

public class GreetDAO {
	
	public List<String> greetList() {
		
		List<String> list = new ArrayList<String>();
		list.add("하이");
		list.add("안녕");
		list.add("니하오");
		
		return list;
	}
}
