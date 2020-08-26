import java.util.*;

public class Hotel
{
	private int ID;
	private int star;
	private String locality;
	private String address;
	private int[] prices;
	private Room[][] rooms;
	
	private static final int MAXCAPACITY = 4;
	
	public Hotel(int ID, int star,
		String locality, String address,
		int priceOfSingle, int numberOfSingle,
		int priceOfDouble, int numberOfDouble,
		int priceOfQuad, int numberOfQuad) {
		this.ID = ID;
		this.star = star;
		this.locality = locality;
		this.address = address;
		
		prices = new int[MAXCAPACITY+1];
		rooms = new Room[MAXCAPACITY+1][];
		
		for (int type = 1; type <= MAXCAPACITY; type++) {
			switch (type) {
				default:
			 		continue;
				case 1:
					prices[type] = priceOfSingle;
			 		rooms[type] = new Room[numberOfSingle];
			 		break;
			 	case 2:
					prices[type] = priceOfDouble;
			 		rooms[type] = new Room[numberOfDouble];
			 		break;
			 	case 4:
					prices[type] = priceOfQuad;
			 		rooms[type] = new Room[numberOfQuad];
			}
			
			for (int i = 0; i < rooms[type].length; i++) {
				rooms[type][i] = new Room();
			}
		}
		
	}
	
	public boolean isAvailable(Date checkin, Date checkout,
		int typeOfRoom, int numOfRoom) {
		int availableCount = 0;
		
		for (Room room : rooms[typeOfRoom]) {
			if (room.isAvailable(checkin, checkout))
				availableCount++;
			if (availableCount >= numOfRoom)
				return true;
		}

		return false;		
	}
	
	public void book(String bookID, Date checkin, Date checkout, int typeOfRoom, int numOfRoom)
		throws HotelActionFailException {
		List<Room> watchList = new ArrayList<>();
		
		for (Room room : rooms[typeOfRoom]) {
			if (room.isAvailable(checkin, checkout)) {
				watchList.add(room);
				if (watchList.size() >= numOfRoom) {
					for (Room roomToBook: watchList) {
						try {
							roomToBook.book(bookID, checkin, checkout);
						} catch (RoomActionFailException e) {
							watchList.remove(roomToBook);
							break;
						}
					}
					if (watchList.size() >= numOfRoom) {
						return;
					}
				}
			}
		}
		
		throw new HotelActionFailException("Reservation not available");
	}
	
	public void cancel(String bookID, int typeOfRoom, int numOfRoom)
		throws HotelActionFailException {
		int cancelledCount = 0;
		
		for (Room room : rooms[typeOfRoom]) {
			if (room.hasBookID(bookID)) {
				try {
					room.cancel(bookID);
				} catch (Exception e) {
					throw new HotelActionFailException(e.getMessage());
				}
				cancelledCount++;
			}
			if (cancelledCount >= numOfRoom) {
				return;
			}
		}
		throw new HotelActionFailException("Reservation not found");
	}
	
	public void shorten(String bookID, Date checkin, Date checkout, int typeOfRoom, int numOfRoom)
		throws HotelActionFailException {
		int modefiedCount = 0;
		
		for (Room room : rooms[typeOfRoom]) {
			if (room.hasBookID(bookID)) {
				try {
					room.shorten(bookID, checkin, checkout);
				} catch (Exception e) {
					throw new HotelActionFailException(e.getMessage());
				}
				modefiedCount++;
			}
			if (modefiedCount >= numOfRoom) {
				return;
			}
		}
		throw new HotelActionFailException("Reservation not found");
	}
	
	public int getHotelID() {
		return ID;
	}
	
	public int getStar(){
		return star;
	}

	public String getCity() {
		return locality;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getPrice(int typeOfRoom){
		return prices[typeOfRoom];
	}
}
