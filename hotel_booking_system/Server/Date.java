import java.util.StringTokenizer;

/**
 Immutable class
 This class deal with all kinds of the operations according to Date type variable.
 Ex: determine the legitimacy of the String value whether correspond to the correct Date form or not.
 */
public class Date implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int year;
	private int month;
	private int day;
	private static int monthDays[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	/**
	 * @param year 
	 * @param month
	 * @param day
	 * @throws DateFormatException
	 */
	public Date(int year, int month, int day)
		throws DateFormatException {
		if (isValidDate(year, month, day)) {
			this.year = year;
			this.month = month;
			this.day = day;
		} else {
			throw new DateFormatException("Invalid Date value");
		}
	}
	/**
	precondition:the String type must be YYYY/MM/DD otherwise will throw a DateFormatException.
	after parsing the string will return the Date type parameter.
	 */
	public static Date parse(String stringToParse)
		throws DateFormatException {
		StringTokenizer tokens = new StringTokenizer(stringToParse, "/");
		if (tokens.countTokens() != 3) {
			throw new DateFormatException("Date format should be: YYYY/MM/DD");
		}
		return new Date(Integer.parseInt(tokens.nextToken()), 
				Integer.parseInt(tokens.nextToken()), 
				Integer.parseInt(tokens.nextToken()));
	}
	/**
	Determine two Date type parameter whether equal or not.
	then return a boolean parameter. 
	 */
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		} else {
			Date otherDate = (Date)otherObject;
			return (day == otherDate.day)
				&& (month == otherDate.month)
				&& (year == otherDate.year);
		}
	}
	/**
	java require an correspond hashCode method as long as an equals method override.
	 */
	public int hashCode() {
		return (year << 10) + (month << 5) + day;
	}
	/**
	Determine two Date type parameter's order.
	then return a boolean parameter. 
	 */
	public boolean isBefore(Date otherDate) {
		return (year < otherDate.year)
		|| (year == otherDate.year && month < otherDate.month)
		|| (year == otherDate.year && month == otherDate.month
			&& day < otherDate.day);
	}
	/**
	Determine two Date type parameter's order.
	then return a boolean parameter. 
	 */
	public boolean isAfter(Date otherDate) {
		return otherDate.isBefore(this);
	}
	/**
	 compute the total days of a user's reservation. 
	 * @param first
	 * @param second
	 * @return the exact number of days the user going to stay
	 */
	public static int difference(Date first, Date second) { 
		int diff = first.year * 365 + first.day
					+ countLeapYears(first);

		for (int i = 1; i < first.month; i++) { 
			diff += monthDays[i]; 
		} 

		diff -= second.year * 365 + second.day
					+ countLeapYears(second); 

		for (int i = 1; i < second.month; i++) { 
			diff -= monthDays[i]; 
		} 

		return Math.abs(diff); 
	}
	
	public String toString() {
		return year + "/" + month + "/" + day;
	}
	
	/**
	compute a Date type parameter. 
	 */
	private static int countLeapYears(Date date) { 
		int years = date.year; 

		if (date.month <= 2)
			years--; 

		return years / 4 - years / 100 + years / 400; 
	}
	/**
	determine the date that user asks is valid or not.
	 */
	private boolean isValidDate(int year, int month, int day) {
		if (year < 0 || month < 0 || month > 12 || day < 0)
			return false;
	
		if (month == 2)
			return day <= monthDays[2] + (isLeapYear(year) ? 1 : 0);
		
		return day <= monthDays[month];
	}
	/**
	determine the date that user asks whether leap year or not.
	*/
	private boolean isLeapYear(int year) {
		return  (year % 400 == 0)
			|| ((year % 4 == 0) && (year % 100 != 0));
	}
}
