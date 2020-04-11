package Falcon;

class Point1 {
	int nX = 10;
	int nY = 20;
	
	public void print() {
		System.out.println(nX);
		System.out.println(nY);
	}
}

class Point2 {
	int num = 100;
	
	public void Add(Point1 pp) { //생성된 Point1의 주소값을 pp에 넣었다. 
		pp.nX += num;			 //pp = point1(주소값)
	}
}

public class F18 {
	public static void main(String[] args) {
		Point1 point1 = new Point1();
		Point2 point2 = new Point2();
		
		//point2에 point1을 넣었다.객체끼리도 복사 가능.
		point2.Add(point1);
		
		point1.print();
	}

}
