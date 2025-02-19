package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UniqueGenerators {

	public static int getRandomNumber() {
		int randomNum = (int)(Math.random() * 10100);
		return randomNum;
	}
	

	public static String getUniqueString() {
		return "client"+getCurrentDateTime();
	}
	
	public static String getCurrentDateTime() {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());  
		  return date.replaceAll("[^0-9]", "");
	    
	}
}
