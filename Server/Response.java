import java.util.*;

public class Response implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private boolean isSuccess;
	private String errorMessage;
	private Query result;
	private List<Query> orderList;
	private List<HotelInfo> hotelInfoList;
	
	public boolean getIsSuccess() {
		return isSuccess;
	}
	
	public void setErrorMessage(String errorMessage) {
		isSuccess = false;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setResult(Query result) {
		isSuccess = true;
		if (result != null)
			this.result = result.clone();
	}
	
	public Query getResult() {
		return result.clone();
	}
	
	public void setOrderList(List<Query> queryList) {
		isSuccess = true;
		orderList = queryList;
	}
	
	public List<Query> getOrderList() {
		return orderList;
	}
	
	public void setHotelInfoList(List<HotelInfo> hotelInfoList) {
		isSuccess = true;
		this.hotelInfoList = hotelInfoList;
	}
	
	public List<HotelInfo> getHotelInfoList() {
		return hotelInfoList;
	}
}
