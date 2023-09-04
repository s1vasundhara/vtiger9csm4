package genericlibraries;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * this class contains reusable methods related to java operations
 * @author admin
 *
 */

public class JavaUtility {
	/**
	 * this method is used to generate and return the random number within specified limit 
	 * @parm limit
	 * @return
	 */
	public int geenrateRandomNumber(int limit)
	{
		Random random=new Random();
		return random.nextInt(limit);
	}
	/**
	 * thuis method returns current time
	 * @return
	 */
	public String getCurrenttime()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_sss");
		
		return sdf.format(date);
		
	}
	/**
	 * this method is used to convert String type month to integer
	 * @param month
	 * @return
	 */
	public int convertMonthToInt(String month)
	{
		return DateTimeFormatter
				.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(month)
				.get(ChronoField.MONTH_OF_YEAR);
	}
	public int generateRandomNum(int limit) {
		// TODO Auto-generated method stub
		Random random=new Random();
		return random.nextInt(limit);
	}

}
