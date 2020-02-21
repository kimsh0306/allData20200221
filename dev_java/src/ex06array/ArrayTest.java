package ex06array;

public class ArrayTest {
	
	int korTot=0;
	int engTot=0;
	int mathTot=0;
	
	String name[] = {"강호동","유재석","감강찬","김유신","김충식"};
	int array[][] = {
			{100,80,90},
			{60,70,90},
			{80,70,70},
			{90,90,90},
			{80,80,80}
	};
	
	int total[] =new int[5];
	int rank[] = new int[5];

	//학생 총점 구하는 메소드
	void total() {		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[1].length; j++) {
				total[i]+=array[i][j];
			}
		}
	}
	
	void subTot() {	
		for(int i=0; i<array.length; i++) {
			korTot+=array[i][0];
			engTot+=array[i][1];
			mathTot+=array[i][2];
		}
	}
	void rank() {
		
		for(int i=0; i<5; i++) {
			for(int j=1; j<5; j++) {
				if(total[i]<total[j]) {
					rank[i]+=1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
			ArrayTest at=new ArrayTest();
			at.total();
			at.rank();
			
			for(int i=0; i<at.array.length; i++) {
				System.out.print(at.name[i]);
				for(int j=0; j<at.array[i].length; j++) {
					System.out.printf("%5d",at.array[i][j]);
				}
				
				System.out.printf("%5d %5.1f  %d",at.total[i],at.total[i]/3.0,(at.rank[i]+1));
				System.out.println();
			}
			at.subTot();
			System.out.println("총점 :"+at.korTot+" "+at.engTot+" "+at.mathTot);
			
			
	}
	

	
}
