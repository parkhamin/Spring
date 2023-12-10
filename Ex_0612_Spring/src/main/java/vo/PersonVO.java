package vo;

public class PersonVO {

	//VO(Value Object) : DB에서 가져온 low 정보를 저장하기 위한 클래스
	private String name, tel;
	private int age;
	
	public PersonVO() {
		System.out.println("PersonVO의 기본생성자");
	}
	
	public PersonVO(String name, int age, String tel) {
		System.out.println("PersonVO의 오버로딩 생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("나는 setName");
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
		System.out.println("나는 setTel");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("나는 setAge");
	}
	
	
}

