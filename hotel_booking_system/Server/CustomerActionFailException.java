public class CustomerActionFailException
	extends Exception
{
	public CustomerActionFailException() {
		super("Customer Action Fail Exception");
	}

	public CustomerActionFailException(String message) {
		super(message);
	}
}
