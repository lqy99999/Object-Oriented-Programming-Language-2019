import java.util.*;

/*
 Implement synchronization
*/
/**
This class generate room object full of all kinds of operation about room under the hotel framework to meet the user's reservation.
Ex: determine the legitimacy of the String value whether correspond to the correct Date form or not.
 */
public class Room 
{
	private List<Reservation> reservationList;
	/**
	General constructor 
	 */
	public Room() {
		reservationList = new Vector<>();
	}
	/**
	determine the date that user asks is available or not.
	return a boolean type parameter.
	 */
	public boolean isAvailable(Date checkin, Date checkout) {
		int result = 0;
		Reservation query = new Reservation(checkin, checkout);
		
		for (Reservation reservation : reservationList) {
			result = query.compareTo(reservation);
			
			if (result < 0)
				continue;
			else
				return result != 0;
		}
		return true;
	}
	/**
	this synchronized class is dealing with the book request from user,to check the date interval is available or not.
	If it is available ,then add the bookID, checkin, checkout into the Reservation List.
	Otherwise will throw a RoomActionFailException("Reservation not available").
	 */
	public synchronized void book(String bookID, Date checkin, Date checkout)
		throws RoomActionFailException {
		int result = 0;
		int size = reservationList.size();
		Reservation reservation = new Reservation(bookID, checkin, checkout);
		
		for (int i = 0; i < size; i++) {
			result = reservation.compareTo(reservationList.get(i));
			
			if (result < 0)
				continue;
			else if (result > 0)
				reservationList.add(i, reservation);
			else
				throw new RoomActionFailException("Reservation not available");
		}
	}
	/**
	this synchronized class is dealing with the cancel request from user.
	If the order doesn't exist will throw a RoomActionFailException("Reservation not found").
	 */
	public synchronized void cancel(String bookID)
		throws RoomActionFailException {
		if (reservationList.remove(new Reservation(bookID)) == false)
			throw new RoomActionFailException("Reservation not found");
	}
	/**
	this synchronized class is dealing with the shorten reserve interval request from user according to parameter bookID,checkin,checkout.
	If the order doesn't exist will throw a RoomActionFailException("Reservation not found").
	 */
	public synchronized void shorten(String bookID, Date checkin, Date checkout)
		throws RoomActionFailException {
		Reservation reservation = new Reservation(bookID, checkin, checkout);
		Reservation originalReservation = null;
		int reservationID = reservationList.indexOf(reservation);
		
		if (reservationID == -1) {
			throw new RoomActionFailException("Reservation not found");
		}
		
		originalReservation = reservationList.get(reservationID);
		
		if (checkin.isBefore(originalReservation.checkin)
			|| checkout.isAfter(originalReservation.checkout)) {
			throw new RoomActionFailException("Can only shorten the reservation");
		} else {
			reservationList.set(reservationID, reservation);
		}
	}
	/**
	 * @param bookID
	 * @return
	 */
	public boolean hasBookID(String bookID) {
		return reservationList.contains(new Reservation(bookID));
	}
	/**
	this inner class contain the key feature of a reservation:bookID, checkin, checkout,and will determine whether a date interval request from
	user is available or not.
	 */
	private class Reservation {
		private String bookID;
		private Date checkin;
		private Date checkout;
		/**
		 * @param bookID
		 * @param checkin
		 * @param checkout
		 */
		public Reservation(String bookID, Date checkin, Date checkout) {	
			this.bookID = bookID;
			this.checkin = checkin;
			this.checkout = checkout;
		}
		/**
		 * @param checkin
		 * @param checkout
		 */
		public Reservation(Date checkin, Date checkout) {	
			this.checkin = checkin;
			this.checkout = checkout;
		}
		/**
		 * @param bookID
		 */
		public Reservation(String bookID) {	
			this.bookID = bookID;
		}
		/**
		this method is going to check the request reservation date interval whether overlap with other already exist reservation date interval
		or not.If it is not overlap,then return 0,that's mean request from user is available.Else return -1 or 1 each means request interval is 
		overlap,the request is not available.
		 */
		public int compareTo(Reservation otherReservation) {
			if (checkin.isAfter(otherReservation.checkout))
				return 1;
			else if (checkout.isBefore(otherReservation.checkin))
				return -1;
			else
				return 0;
		}
		/**
		 this method is going to check a request from user going to modify the reservation that this user whether already have a reservation or
		 not.
		 */
		public boolean equals(Object otherReservation) {
			if (otherReservation == null) {
				return false;
			} else {
				return bookID == ((Reservation)otherReservation).bookID;
			}
		}
		/**
		java require an correspond hashCode method as long as an equals method override.
		 */
		public int hashCode() {
			return bookID.hashCode();
		}
	}
}
