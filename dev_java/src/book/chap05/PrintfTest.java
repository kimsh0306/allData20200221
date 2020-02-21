package book.chap05;

public class PrintfTest {
	public static void main(String[] args) {
		int value = 123;
		System.out.printf("상품의 가격: %d원\n",value);
		System.out.printf("상품의 가격: %6d원\n",value);
		System.out.printf("상품의 가격: %-6d원\n",value);
		System.out.printf("상품의 가격: %06d원\n",value);
	
	
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n",1,name,job); //스페이스바5 후 1출력 | 홍길동   |          도적
	}//양수는 오른쪽 정렬  음수는 왼쪽정렬
}
