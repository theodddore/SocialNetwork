package Server;
import java.net.*;
import java.util.ArrayList;
import java.io.*;

import Client.user;

/**
 * 
 * @author Theodoros Mavrikis , Haroula Velisarakou , Sotiria Louka
 * implements the server
 */
public class server
{
	int [] portNumber = {1270,1271,1272,1273,1274,1275,1276,1277,1278,1279};    //1270-1279
	
	String HostName = "127.0.0.1"; //local host ip
	
	ArrayList<user> activeUsers = new ArrayList<user>();
	ArrayList<user> loggedUsers = new ArrayList<user>();
	
	ServerSocket serv = null;
		
 	Socket clnt = null;
	
 	BufferedReader in;
 	
 	PrintWriter out;
 	
 	File f;
 	
 	/**
 	 * Starts the server
 	 * uses default ip 0.0.0.0/0.0.0.0
 	 */
	public void startServer()
	{
		activeUsers.add(new user(1 , "123"));//test code SHOULD BE ERASED WHEN LOAD IS IMPLEMENTED
		
		try
		{
			//creates the server socket
				 serv = new ServerSocket(portNumber[0]);
				 System.out.println(serv.getInetAddress());
		}	
		catch(IOException io)
		{
			System.out.println(" Error: Creating a server socket");
			System.out.println(io);
		}	
		try
		{
			//accept a  connection from the client
			clnt = serv.accept();
			System.out.println("CONNECTION ACHIEVED!");
			clnt.isConnected();
		
			
		}
		catch(IOException io)
		{
			System.out.println(" Error: Accepting a connection");
			System.out.println(io);
		}
	}
	/**
	 * Creates streams to communicate with client
	 * still doesn't work
	 */
	public void listen()
	{
		
		try
		{
			this.out =  new PrintWriter(clnt.getOutputStream(), true);
			this.in = new BufferedReader( new InputStreamReader(clnt.getInputStream()));
		}
		catch(IOException io)
		{
			System.out.println(" Error: Creating outputStream");
			System.out.println(io);
		}	
		
		try
		{
			String userInput; //Will store the input from the stream
			userInput  = in.readLine();
			
			if(userInput.equals("LOGIN"))
			{
				userInput = in.readLine();
				
				int id = Integer.parseInt(userInput);
				System.out.println("echo: " + id);
				String password = in.readLine();
				if(validateUser(id , password))
				{
					out.println("SUCCESS");
				}
				else
				{
					out.println("FAIL");
				}
			}
		}
		 catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//out.println("hello!");
		//out.close();
		
	}
		
	
	/**
	 * Loads the users from a file saved to the server side
	 */
	public void LoadUsers()
	{
		   String line="";
			
	        try
	        {
	        	f = new File("../UsersData.txt");
			}
	        catch(NullPointerException e)
	        {
				System.out.println("File not found!");
				System.exit(1);
	        }
			
	        try 
	        { 
	        	in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));               
	        }
	        catch (FileNotFoundException e)
	        {
	        	System.out.println("Error Opening File!");
	        }
	        
	        try
	        {
	            line = in.readLine();
	        	while (line != null) {
						user user = new user(); 
						String[] parts = line.split(" ");
						user.setID(Integer.parseInt(parts[0]));  
						user.setPassword(parts[1]);  
						line = in.readLine();    //reads the next User
				}
	        }
	        catch (IOException e) 
	        {
	        	System.out.println("Sudden End!");
	        }
	        
	        try {
	        	in.close();
	        }
	        catch (IOException e)
	        {
	        	System.out.println("Error Closing File!.");
	        }
	}
	
	public boolean validateUser(int id , String password)
	{
		for(user u : activeUsers)
		{
			if(u.getID() == id)
			{
				
				System.out.println("ID confirmed");
				if(password.equals(u.getPassword()))
				{
					loggedUsers.add(u);
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	*Close(): Closes the connection of the server
	*/
	public void close()
	{
		try {
			System.out.println("Closing Connection -- Server");
			serv.close();
		}
		catch(IOException io)
		{
			System.out.println(" Error: closing connection");
			System.out.println(io);
		}
	}
}