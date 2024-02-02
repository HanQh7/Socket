package gg;
import java.net.*;
import java.io.*;

public class server_BYE {
	 private ServerSocket serverSocket;
	    private Socket clientSocket;
	    private PrintWriter out;
	    private BufferedReader in;

	    public void start(int port) {
	        try {
	            serverSocket = new ServerSocket(port);
	            clientSocket = serverSocket.accept();

	            out = new PrintWriter(clientSocket.getOutputStream(), true);
	            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

	            String message;
	            while ((message = in.readLine()) != null) {
	                System.out.println("Server: " + message);
	                if (message.equals("BYE")) {
	                	 System.out.println("Dissconnected");
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                in.close();
	                out.close();
	                clientSocket.close();
	                serverSocket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static void main(String[] args) {
	    	server_BYE server = new server_BYE();
	        server.start(1111);
	    }
	}