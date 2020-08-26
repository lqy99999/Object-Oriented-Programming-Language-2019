import java.util.*;
import java.io.*;
import java.security.*;
import java.math.BigInteger;

import org.json.simple.*;
import org.json.simple.parser.*;

public class HotelManager
{
	private List<Hotel> hotelList;
	private List<Customer> memberList;
	
	public HotelManager(String dataSource) {
		hotelList = new ArrayList<>();
		memberList = new ArrayList<>();
		
		try {
			readJSON(dataSource);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public String signUp(Query query, Response response) {
		Customer customer = null;
		String userName = null;
		String hashedPassword = null;
		String membership = null;
		StringTokenizer tokens = new StringTokenizer(query.getBookID(), "/");
		
		if (tokens.countTokens() != 3) {
			response.setErrorMessage("Unknown sign up format");
			return null;
		}
		
		userName = tokens.nextToken();
		hashedPassword = encrypt(tokens.nextToken());
		membership = tokens.nextToken();
		for (Customer member : memberList) {
			if (userName.equals(member.getUserName())) {
				response.setErrorMessage("This username has been used");
				return null; 
			}
		}
		
		switch (membership) {
			case "MEMBER":
				customer = new Member(userName, hashedPassword);
				break;
			case "VIP":
				customer = new VIP(userName, hashedPassword);
				break;
			default:
				response.setErrorMessage("Unknown membership");
				return null;
		}
		
		memberList.add(customer);
		response.setResult(null);
		return userName;
	}
	
	public String logIn(Query query, Response response) {
		String userName = null;
		String hashedPassword = null;
		StringTokenizer tokens = new StringTokenizer(query.getBookID(), "/");
		
		switch (tokens.countTokens()) {
			case 1:
				userName = tokens.nextToken();
				if (userName.equals("GUEST")) {
					response.setResult(null);
					return userName;
				}
				response.setErrorMessage("Unknown log in format");
				break;
			case 2:
				userName = tokens.nextToken();
				hashedPassword = encrypt(tokens.nextToken());
				for (Customer member : memberList) {
					if (member.verifyIdentity(userName, hashedPassword) == true) {
						response.setResult(null);
						return userName;
					}
				}
				response.setErrorMessage("User name not found");
				break;
			default:
				response.setErrorMessage("Unknown log in format");
		}
		
		return null;
	}
	
	public Response handleQuery(String userName, Query query) {
		boolean finishedService = false;
		Service service = new Service();
		Response response = new Response();
		
		try {
			if (userName.equals("GUEST")) {
				service.doService(new Customer(), query, response);
			} else {
				for (Customer member : memberList) {
					if (userName == member.getUserName()) {
						if (member.isVIP)
							service.doService((VIP)member, query, response);
						else
							service.doService((Member)member, query, response);
						finishedService = true;
						break;
					}
				}
				if (!finishedService)
					response.setErrorMessage("Unknown user name");
			}
		} catch (Exception e) {
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	interface Visitable {
		void accept(Visitor visitor);
	}

	interface Visitor {
		void visit(Member member);
		void visit(VIP vip);
	}

	private class Customer implements Visitable {
		protected boolean isMember;
		protected boolean isVIP;

		private String userName;
		private String hashedPassword;
		private List<Order> orderList;

		public Customer() {
			// This is for GUEST type customer
		}

		public Customer(String userName, String hashedPassword) {
			this.userName = userName;
			this.hashedPassword = hashedPassword;
			orderList = new ArrayList<>();
		}

		public String getUserName() {
			return userName;
		}

		public boolean verifyIdentity(String userName, String checksum) {
			return (this.userName == userName) &&
				(checksum.equals(hashedPassword));
		}

		public void queryIsAvailable(Query query, Response response)
			throws CustomerActionFailException {
			if (hotelList.get(query.getHotelID()).isAvailable(
				query.getCheckin(), query.getCheckout(), query.getTypeOfRoom(), query.getNumOfRoom())) {
				query.setPrice(calculatePrice(query));
				response.setResult(query);
			}
			throw new CustomerActionFailException("Reservation is not available");
		}

		public void makeOrder(Query query, Response response)
			throws CustomerActionFailException {
			if (!isMember) {
				throw new CustomerActionFailException("Permission denied");
			}
			
			Order order = new Order(query);
			
			try {
				hotelList.get(query.getHotelID()).book(order.bookID,
					query.getCheckin(), query.getCheckout(), query.getTypeOfRoom(), query.getNumOfRoom());
			} catch (Exception e) {
				order.cancel();
				throw new CustomerActionFailException(e.getMessage());
			}
			
			orderList.add(order);
			response.setResult(order.getOrder());
		}

		public void cancelOrder(Query query, Response response)
			throws CustomerActionFailException {
			if (!isMember) {
				throw new CustomerActionFailException("Permission denied");
			}
			
			int orderIDToCancel = orderList.indexOf(query);
			
			if (orderIDToCancel == -1) {
				throw new CustomerActionFailException("Order not found");
			}
			
			try {
				hotelList.get(query.getHotelID()).cancel(
					query.getBookID(), query.getTypeOfRoom(), query.getNumOfRoom());
				query.setPrice(orderList.get(orderIDToCancel).cancel());
				response.setResult(query);
				return;
			} catch (Exception e) {
				throw new CustomerActionFailException(e.getMessage());
			}
		}

		public void modifyRoomNumber(Query query, Response response)
			throws CustomerActionFailException {
			if (!isVIP) {
				throw new CustomerActionFailException("Permission denied");
			}
			
			int orderIDToModify = orderList.indexOf(query);
			
			if (orderIDToModify == -1) {
				throw new CustomerActionFailException("Order not found");
			}
			
			try {
				hotelList.get(query.getHotelID()).cancel(
					query.getBookID(), query.getTypeOfRoom(), query.getNumOfRoom());
				query.setPrice(orderList.get(orderIDToModify).modify(query));
				response.setResult(query);
				return;
			} catch (Exception e) {
				throw new CustomerActionFailException(e.getMessage());
			}
		}
		
		public void modifyDate(Query query, Response response)
			throws CustomerActionFailException {
			if (!isVIP) {
				throw new CustomerActionFailException("Permission denied");
			}
			
			int orderIDToModify = orderList.indexOf(query);
			
			if (orderIDToModify == -1) {
				throw new CustomerActionFailException("Order not found");
			}
			
			try {
				hotelList.get(query.getHotelID()).shorten(query.getBookID(),
					query.getCheckin(), query.getCheckout(), query.getTypeOfRoom(), query.getNumOfRoom());
				query.setPrice(orderList.get(orderIDToModify).modify(query));
				response.setResult(query);
					return;
			} catch (Exception e) {
				throw new CustomerActionFailException(e.getMessage());
			}
		}
		
		public void checkOrder(Query query, Response response) throws CustomerActionFailException {
			int orderIDToQuery = orderList.indexOf(query);
			
			if (orderIDToQuery == -1) {
				throw new CustomerActionFailException("Order not found");
			}
			
			response.setResult(orderList.get(orderIDToQuery).getOrder());
		}        
		
		public void checkOrderList(Query query, Response response) throws CustomerActionFailException {
			List<Query> queryList = new ArrayList<>();
			
			for (Order order : orderList) {
				if (order.isCancelled)
					continue;
				queryList.add(order.getOrder());
			}
			
			response.setOrderList(queryList);
		}
		
		public void listHotel(Query query, Response response) throws CustomerActionFailException {
			List<HotelInfo> hotelInfoList = new ArrayList<>();
			
			for (Hotel hotel : hotelList) {
				if (hotel.isAvailable(query.getCheckin(), query.getCheckout(),
					query.getTypeOfRoom(), query.getNumOfRoom())) {
					hotelInfoList.add(new HotelInfo(hotel.getHotelID(),
						hotel.getStar(), hotel.getCity(), hotel.getAddress(), calculatePrice(query, hotel)));
				}
			}
			
			response.setHotelInfoList(hotelInfoList);
		}
		
		public int calculatePrice(Query query) {
			return hotelList.get(query.getHotelID()).getPrice(query.getTypeOfRoom())
				* query.getNumOfRoom() * (Date.difference(query.getCheckin(), query.getCheckout()) + 1);
		}
		
		public int calculatePrice(Query query, Hotel hotel) {
			return hotel.getPrice(query.getTypeOfRoom()) * query.getNumOfRoom()
				* (Date.difference(query.getCheckin(), query.getCheckout()) + 1);
		}

		private class Order {
			private int orderNumber;
			private String bookID;
			private boolean isCancelled;

			private int hotelID;
			private Date checkin;
			private Date checkout;
			private int typeOfRoom;
			private int numOfRoom;
			private int price;

			public Order(Query query) {
				orderNumber = orderList.size() + 1;
				bookID = encrypt(userName + orderNumber);
				isCancelled = false;
				hotelID = query.getHotelID();
				checkin = query.getCheckin();
				checkout = query.getCheckout();
				typeOfRoom = query.getTypeOfRoom();
				numOfRoom = query.getNumOfRoom();
				price = calculatePrice(query);
			}
			
			public String getBookID() {
				return bookID;
			}
			
			public boolean equals(Object otherObject) {
				if (otherObject == null)
					return false;
				else
					if (otherObject instanceof Query)
						return bookID == ((Query)otherObject).getBookID();
					else if (otherObject instanceof Order)
						return bookID == ((Order)otherObject).bookID;
					else
						return false;
			}
			
			public int hashCode() {
				return bookID.hashCode();
			}
			
			public Query getOrder() {
				return new Query(null, hotelID, checkin,
					checkout, typeOfRoom, numOfRoom, bookID, price);
			}

			public int cancel() {
				isCancelled = true;
				return price;
			}
			
			public int modify(Query query) {
				int temp = price;
				checkin = query.getCheckin();
				checkout = query.getCheckout();
				numOfRoom -= query.getNumOfRoom();
				price = calculatePrice(query);
				return temp - price;
			}
		}

		public void accept(Visitor visitor) {}
	}

	private class Member extends Customer {
		public Member(String userName, String hashedPassword) {
			super(userName, hashedPassword);
		}

		public void doMember() {
			isMember = true;
		}

		public void accept(Visitor visitor) {
			visitor.visit(this);
		}   
	}

	private class VIP extends Customer {
		public VIP(String userName, String hashedPassword) {
			super(userName, hashedPassword);
		}

		public void doVIP() {
			isMember = true;
			isVIP = true;
		}

		public void accept(Visitor visitor) {
			visitor.visit(this);
		}    
	}

	private class VisitorImpl implements Visitor {
		public void visit(Member member) {
			member.doMember();
		}

		public void visit(VIP vip) {
			vip.doVIP();
		}
	}

	private class Service {
		private Visitor visitor = new VisitorImpl();

		public void doService(Customer customer, Query query, Response response)
			throws CustomerActionFailException {
			((Visitable)customer).accept(visitor);

			switch (query.getType()) {
				case BOOK:
					customer.makeOrder(query, response);
					break;
				case CANCEL:
					customer.cancelOrder(query, response);
					break;
				case MODIFYROOMNUM:
					customer.modifyRoomNumber(query, response);
					break;
				case MODIFYDATE:
					customer.modifyDate(query, response);
					break;
				case CHECKORDER:
					customer.checkOrder(query, response);
					break;
				case CHECKORDERLIST:
					customer.checkOrderList(query, response);
					break;
				case LISTHOTEL:
					customer.listHotel(query, response);
					break;
				default:
					throw new CustomerActionFailException("Unknown query");
			}
		}
	}
	
	private String encrypt(String strToEncrypt) {
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			
			byte[] messageDigest = md.digest(strToEncrypt.getBytes()); 
			
			BigInteger no = new BigInteger(1, messageDigest); 
			
			String encryptText = no.toString(16); 
			
			while (encryptText.length() < 32) { 
				encryptText = "0" + encryptText; 
			}
			
			return encryptText;
		} catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		}
	}
	
	private void readJSON(String dataSource) throws Exception {
		JSONParser parser = new JSONParser();
		
		FileInputStream in = new FileInputStream(dataSource);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		
		JSONArray a = (JSONArray)parser.parse(reader);
		
		int roomPrices[] = new int[3];
		int roomNumbers[] = new int[3];
		
		for (Object o : a) {
			JSONObject hotel = (JSONObject)o;

			int ID = Integer.valueOf(String.valueOf(hotel.get("HotelID")));
			int star = Integer.valueOf(String.valueOf(hotel.get("HotelStar")));
			String locality = (String)hotel.get("Locality");
			String address = (String)hotel.get("Street-Address");

			JSONArray Rooms = (JSONArray)hotel.get("Rooms");
			
			int i = 0;
			for (Object c : Rooms) {
				JSONObject roomobject = (JSONObject)c;
				String RoomType = (String)roomobject.get("RoomType");
				roomPrices[i]= Integer.valueOf(String.valueOf(roomobject.get("RoomPrice")));
				roomNumbers[i] = Integer.valueOf(String.valueOf(roomobject.get("Number")));
				i++;
			}
			
			hotelList.add(
				new Hotel(ID, star, locality, address,
					roomPrices[0], roomNumbers[0],
					roomPrices[1], roomNumbers[1],
					roomPrices[2], roomNumbers[2]));
					
		}
	}
}
