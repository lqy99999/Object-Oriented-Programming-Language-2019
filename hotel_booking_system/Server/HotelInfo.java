public class HotelInfo implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	public int ID;
	public int star;
	public String city;
	public String address;
	public int price;
	
	public HotelInfo(int ID, int star, String city, String address, int price) {
		this.ID = ID;
		this.star = star;
		this.city = city;
		this.address = address;
		this.price = price;
	}
}
