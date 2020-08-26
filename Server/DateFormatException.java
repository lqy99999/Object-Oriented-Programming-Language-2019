public class DateFormatException
	extends Exception implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	public DateFormatException() {
		super("Date Format Exception");
	}

	public DateFormatException(String message) {
		super(message);
	}
}
