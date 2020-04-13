package aTest0404;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class DateInfo {
	public static long getDiffernceDates(String sDate, String eDate, String pattern, char delim) {
		long diff = 0;
		try {
			SimpleDateFormat sd = new SimpleDateFormat(pattern);
			Date sdate = sd.parse(sDate);
			Date edate = sd.parse(eDate);
			long sTime = sdate.getTime();
			long eTime = edate.getTime();
			//abs를 씌웠다.
			diff = Math.abs(sTime-eTime);
			//System.out.println("diff:"+diff/(60*60*1000));
		} catch (ParseException e) {
			// TODO: handle exception
		}
		return diff;
	}
	public static void main(String[] args) {
		DateInfo di = new DateInfo();
		long diff = di.getDiffernceDates("2020,04,05"
							,"2020-04-05"
							,"yyyy-MM-dd"
							,'H');
		System.out.println();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd H");
		try {
			Date d = sd.parse("2020-04-06");
			System.out.println(d);
			String s = sd.format(Calendar.getInstance().getTime());
			System.out.println("s:"+s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
