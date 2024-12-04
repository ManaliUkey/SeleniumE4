package Basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class DateFetching {
	@Test
public void main() {
	Date date = new Date();
	System.out.println(date);
	SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
	String currentdate = sim.format(date);
	System.out.println(currentdate);
	//date after some days
	Calendar  cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, 90);
	String afterDate = sim.format(cal.getTime());
	
	System.out.println(afterDate);
}
}
