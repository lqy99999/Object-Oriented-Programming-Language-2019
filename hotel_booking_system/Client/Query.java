public class Query implements java.io.Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	
	private QueryType type;
	private int hotelID;
	private Date checkin;
	private Date checkout;
	private int typeOfRoom;
	private int numOfRoom;
	private String bookID;
	private int price;
	
	
	public Query(QueryType type, int hotelID, Date checkin, Date checkout, int typeOfRoom, int numOfRoom, String bookID, int price) {
		this.type = type;
		this.hotelID = hotelID;
		this.checkin = checkin;
		this.checkout = checkout;
		this.typeOfRoom = typeOfRoom;
		this.numOfRoom = numOfRoom;
		this.bookID = bookID;
		this.price = price;
	}
	
	public Query clone() {
		try {
			return (Query)super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public QueryType getType() {
		return type;
	}
	
	public int getHotelID() {
		return hotelID;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}
	
	public int getTypeOfRoom() {
		return typeOfRoom;
	}
	
	public int getNumOfRoom() {
		return numOfRoom;
	}
	
	public String getBookID() {
		return bookID;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean quit() {
		return type == QueryType.QUIT;
	}
}
