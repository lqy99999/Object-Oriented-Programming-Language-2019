public class RoomActionFailException
	extends Exception
{
	public RoomActionFailException() {
		super("Room Action Fail Exception");
	}

	public RoomActionFailException(String message) {
		super(message);
	}
}
