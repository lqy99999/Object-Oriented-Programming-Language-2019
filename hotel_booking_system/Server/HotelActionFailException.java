public class HotelActionFailException
	extends Exception
{
	public HotelActionFailException() {
		super("Hotel Action Fail Exception");
	}

	public HotelActionFailException(String message) {
		super(message);
	}
}
