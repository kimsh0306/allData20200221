package study.hyelim;

public class StudentVO {

	//생성자가 초기화를 해주니까 굳이 해줄 필요 없다. 근데 헷갈린다면 그냥 초기화 시켜주자.
//	///step1///
//	public String name;
//	public int age;
//	public double height;
//	///step1///
	
	
	
	///step2///
    private String name;
    private int age;
    private double height;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	///step2///
	
	
}
