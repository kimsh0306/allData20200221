package thread.bank;

import java.util.StringTokenizer;

public class MessageText {

	public static void main(String[] args) {
		String msg = "200#apple#test#오늘 스터디 할까?";
		StringTokenizer st = null;
		if(msg!=null) {
			st = new StringTokenizer(msg,"#");
		}
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
		if(msg!=null) {
			st = new StringTokenizer(msg,"#");
		}
		for(;st.hasMoreTokens();) {
			System.out.println(st.nextToken());
		}
	}
}