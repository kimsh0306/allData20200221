package ocjp.basic;

public class Test {
	public static void replaceJ(String text) {
		text.replace('j', 'l');  //j를 l로 변경
	}
	public static String replaceJ2(String text) {
		String imsi = null;
		imsi = text.replace('j', 'l');
		return imsi;
	}
	public static void main(String args[]) {
		String text = new String("java");
		replaceJ(text); //원본이 바뀌지 않는다.
		String s_text=replaceJ2(text);
		System.out.println(text);
		System.out.println(s_text);
	}
}
