import java.net.*;
import java.io.*;
import java.util.*;

public class Client
{
	public static void main(String args[]) throws IOException {
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(
			new FileInputStream("./Client/ClientConfig.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Not found client configuration");
			System.exit(0);
		}
		
		User user = new User();
		String serverAddress = null;
		String port = null;

		while (inputStream.hasNext()) {
			String key = inputStream.next();
			switch (key) {
				default:
					break;
				case "ServerAddress":
					inputStream.next();
					serverAddress = inputStream.next();
					break;
				case "Port":
					inputStream.next();
					port = inputStream.next();
				}
		}

		if (serverAddress == null || port == null) {
			System.out.println("Unknown client configuration");
			System.exit(0);
		}
		
		Socket socket = null;
		ObjectInputStream inputObject = null;
		ObjectOutputStream outputObject = null;
		Query query = null;
		Response response = null;
		
		try {
			socket = new Socket(serverAddress, Integer.parseInt(port));
			outputObject = new ObjectOutputStream(socket.getOutputStream());
			inputObject = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e){
			System.out.println(e.getMessage());
			System.err.print("IO exception");
		}
		
		try{
			while (true) {
				query = user.getQuery();
				if (query == null) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// Do nothing
					}
					continue;
				}

				outputObject.writeObject(query);
				outputObject.flush();
				
				if (query.getType() == QueryType.QUIT) {
					break;
				}
				
				response = (Response)inputObject.readObject();
				user.setResponse(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
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
				System.out.println("Connection closed");
			} catch (IOException ie) {
				System.out.println("Socket close error");
			}
		}
	}
}
