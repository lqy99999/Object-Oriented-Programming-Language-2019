import java.net.*;
import java.io.*;
import java.util.*;
import java.security.*;
import java.math.BigInteger;

public class Server {
	private HotelManager hotelManager;
	
	public static void main(String[] args) {
		new Server().run();
	}
	
	private void run() {
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(
			new FileInputStream("./ServerConfig.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Not found server configuration");
			System.exit(0);
		}

		String dataSource = null;
		String port = null;

		while (inputStream.hasNext()) {
			String key = inputStream.next();
			switch (key) {
				default:
					break;
				case "Data":
					inputStream.next();
					dataSource = inputStream.next();
					break;
				case "Port":
					inputStream.next();
					port = inputStream.next();
			}
		}
		
		if (dataSource == null || port == null) {
			System.out.println("Unknown server configuration");
			System.exit(0);
		}

		hotelManager = new HotelManager(dataSource);
		Socket socket = null;
		ServerSocket serverSocket = null;

		System.out.println("Server listening......");
		try {
			serverSocket = new ServerSocket(Integer.parseInt(port));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Server start up error");
		}

		while (true) {
			try {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				System.out.println("Connection with " +
					serverThread.getName() + " established");
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Connection error");
			}
		}
	}
	
	private class ServerThread extends Thread {
		private Socket socket;
		private ObjectInputStream inputObject;
		private ObjectOutputStream outputObject;
		private Query query;
		private Response response;
		private String userName;
		private boolean hasLogin;

		public ServerThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
		try {
			inputObject = new ObjectInputStream(socket.getInputStream());
			outputObject = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("IO error in server thread");
		}

		try {
			query = (Query)inputObject.readObject();
			printQuery(query);
			
			while (!query.quit()) {
				if (hasLogin){
					response = hotelManager.handleQuery(userName, query);
				} else {
					if (query.getType() == QueryType.SIGNUP) {
						userName = hotelManager.signUp(query, response);
						if (response.getIsSuccess())
							hasLogin = true;
					} else if (query.getType() == QueryType.LOGIN) {
						userName = hotelManager.logIn(query, response);
						if (response.getIsSuccess())
							hasLogin = true;
					} else {
						response.setErrorMessage("Has not logged in");
					}
				}
				printReponse(response);
				outputObject.writeObject(response);
				outputObject.flush();
				query = (Query)inputObject.readObject();
				printQuery(query);
			}   
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.print("IO error/ Client " + this.getName());
			System.out.println(" terminated abruptly");
		} catch (NullPointerException e) {
			System.out.println("Client " + this.getName() + " closed");
		} catch (ClassNotFoundException e) {
			System.out.println("Unknown class type");
		} finally {    
			try {
				if (inputObject != null) {
					inputObject.close(); 
				}
				if(outputObject != null) {
					outputObject.close();
				}
				if (socket != null){
					socket.close();
				}
			} catch (IOException ie) {
				System.out.println("Socket close error");
			}
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
	
	private void printQuery(Query query) {
		System.err.print("[type] " + query.getType().toString());
		
		System.err.print(" [hotelID] " + query.getHotelID());
		
		if (query.getCheckin() != null)
			System.err.print(" [checkin] " + query.getCheckin());
		
		if (query.getCheckout() != null)
			System.err.print(" [checkout] " + query.getCheckout());
		
		System.err.print(" [typeOfRoom] " + query.getTypeOfRoom());
		
		System.err.print(" [numOfRoom] " + query.getNumOfRoom());
		
		if (query.getBookID() != null)
			System.err.print(" [bookID] " + query.getBookID());
		
		System.err.print("\n");	
	}		
		
	private void printReponse(Response response) {
		System.err.print("[isSuccess] " + response.getIsSuccess());
		
		if (!response.getIsSuccess()) {
			System.err.print(" [errorMessage] " + response.getErrorMessage());
		}
		
		System.err.print("\n");
	}
}
