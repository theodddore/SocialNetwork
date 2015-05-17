package Client;
import java.net.*;
import java.io.*;

/**
*main client class
*Runs in the client's terminal, communicates with server
*/
public class client_main
{
	 //local Host 127.0.0.1
	
	
	public static void main(String args[]) {
		//user test = new user( 1 , "123");
		//client cl = new client();
		userInterface uIn = new userInterface();
		uIn.menu();
		//cl.connect();
		//cl.close();
	}
}
