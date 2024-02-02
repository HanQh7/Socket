package socket_clint;
import java.net.*;
import java.io.*;
public class client_BYE {
	 private Socket socket;
     private PrintWriter out;
     private BufferedReader in;
     private BufferedReader stdIn;

     public void startConnection(String ip, int port) {
         try {
             socket = new Socket(ip, port);
             out = new PrintWriter(socket.getOutputStream(), true);
             in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             stdIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("enter your message: ");
             String userInput;
             while ((userInput = stdIn.readLine()) != null) {
                 out.println(userInput);
                 if (userInput.equals("BYE")) {
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
                 socket.close();
                 stdIn.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

     public static void main(String[] args) {
    	 client_BYE client = new client_BYE();
         client.startConnection("localhost", 1111);
     }
 }