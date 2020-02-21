package gogo;

import java.util.Scanner;

public class TvTest {

	int channel=2;
	int volume = 0;
	boolean power = false;

	boolean powerButton(boolean pw) {
		if(pw==false) {
			System.out.println("Tv 전원이  켜집니다.");
			return power=true;
		}else
		{
			System.out.println("Tv 전원이 꺼집니다.");
			return power=false;
		}
	}

	
	int channelUp(int ch) {
		return channel=ch+1;
	}
	
	int channelDown(int ch) {
		return channel=ch-1;
	}
	
	
	public static void main(String[] args) {

		TvTest tv=new TvTest();
		System.out.println("전원 버튼을 누릅니다.");
		tv.powerButton(tv.power);  //피티 켜기
		
		System.out.println("채널 ↑ 버튼을 누릅니다.");
		System.out.println("현재 채널 ==> "+ tv.channelUp(tv.channel));
	
		System.out.println("채널 ↑ 버튼을 누릅니다.");
		System.out.println("현재 채널 ==> "+  tv.channelUp(tv.channel));
		
		System.out.println("채널 ↓ 버튼을 누릅니다.");
		System.out.println("현재 채널 ==> "+ tv.channelDown(tv.channel));
		
		
		System.out.println("전원 버튼을 누릅니다.");
		tv.powerButton(tv.power); //티비 끄기
	}

}
