package book.chap10;

public class ArrayStringName {
		public static void main(String[] args) {
			String nameList[] = {"허준호","이상현","김충식","김승현"};
			String nameList2[][] = {
					 {"허준호","이상현","김충식","김승현"}
					,{"25","26","27","28"}		
					};
			String nameList3[][] = {
					 {"허준호","이상현","김충식","김승현"}
					,{"25","26","27","28"}
					,{"iot","투자","골프","독서"}
					};
				
			for(int i=0; i<nameList3[2].length; i++) {
				System.out.print(nameList3[2][i]+" ");
			}
		
			
			System.out.println("\n===============");
			//nameList3은 배열의 이름이고 여기에 length이면 로우의 수이다.
			for(int i=0; i<nameList3.length; i++) {  //행
				for(int j=0; j<nameList3[0].length; j++) {  //열
					if(i==2) {//친구들의 취미니?
					System.out.print(nameList3[i][j]+" ");
				}
			}
		}
		}
}
