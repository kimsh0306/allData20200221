package book.chap05;
/*
 * 같은 이름의 생성자를 여러 개 가질 수 있다. 리턴타입 없음. 인스턴스화 하면 바로 실행.
 * 단 파라미터의 갯수가 반드시 달라야 한다.
 * 단 파라미터의 타입이 반드시 달라야 한다.
 * 변수의 이름이 다른 건 인정 못한다. 생성자를 중복 정의했다라고 생각함.
 * 
 */
public class Person {
	//전역변수입니다.
	//초기화를 생략할 수 있어요. 왜냐면 생성자가 대신 해주니까...
	String name;//성명
	float height;//그 사람의 키
	float weight;//그 사람의 몸무게
	//디폴트 생성자는 생략할 수 있어요.
	//왜냐하면 jvm이 만들어 줄 수 있기 때문이죠.
	//그러나 파라미터를 갖는 생성자는 만들어줄 수 없어요.
	//왜냐면 그 사람 생각을 내가 알 수 없기 때문이죠.
	/*
	Person(){
	
		System.out.println("Person 디폴트 생성자 호출 성공");
		//name = null;
		//height = 0.0f;
		//weight = 0.0f;
	}
	*/
	Person(String name){
		//this.name = name;
	}
	//생성자는 여러 개 선언하기가 된다.(같은 이름의 생성자를 가질 수 있다) - 단 타입은 반드시 달라야 한다.
	Person(float Height) {
		this.height = height;
	}
	Person(float height, float weight) {
		this.height = height;
		this.weight = weight;
	}
	Person(double Height) {
		this.height = height;
	}
//	Person(float Height2) {
//		this.height2 = height2;
//	}
	Person(String name, float height, float weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
}
