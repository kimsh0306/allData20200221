package athread.talk3;

import java.awt.Color;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TalkClientThread extends Thread {
	TalkClientVer2 tc = null;
	public TalkClientThread(TalkClientVer2 tc) {
		this.tc = tc;
	}
	public SimpleAttributeSet  makeAttribute(String fcolor) {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(fcolor)));
		return sas;
	}
	/*
	 * 서버에서 말한 내용을 들어봅시다.
	 */
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {

			} catch (Exception e) {
				// TODO: handle exception
			}
		}////////////////////end of while
	}////////////////////////end of run
}
























