package dao;

import java.util.ArrayList;
import java.util.List;

public class FriendDAO {

	public List<String> friendList(){
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("박길동");
		list.add("이길동");
		list.add("김길동");
		
		return list;
	}
	
}
