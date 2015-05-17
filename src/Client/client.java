package Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class client 
{
	int [] portNumber = {1270,1271,1272,1273,1274,1275,1276,1277,1278,1279};    //1270-1279
	ObjectInputStream input;
	String HostName = "127.0.0.1";
	Socket clientSocket;
	PrintWriter out;
	boolean loggedIn = false;
	BufferedReader in;
	BufferedReader stdIn;
	
	/**
	 * creates an input stream which will get data from the server
	 */
	
	public void connect()
	{
		try
		{
			
			clientSocket = new Socket(HostName ,portNumber[0]);
		}
		catch(IOException io)
		{
			System.out.println("Error: Creating Connection");
			System.out.println(io);
		}
		
	}
	
	public boolean requestLogin(user ur) throws IOException
	{
		this.out = new PrintWriter(clientSocket.getOutputStream(), true);
		this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		this.stdIn = new BufferedReader(new InputStreamReader(System.in)); //gets the responce of the server socket
		
		out.println("LOGIN" + "\n" +ur.getID() + "\n" + ur.getPassword());
		String response = in.readLine();
		if(response.equals("SUCCESS"))
		{
			loggedIn = true;
			return true;
		}
		else if(response.equals("FAIL"))
		{
			
			return false;
		}
		return false;
	}
	
	/**
	 *Creates an input for the stream of data to get to the client from the server
	 * 
	 */
	public void createStreams()
	{
		try
		{
			if(clientSocket.isConnected())
			{
				this.out = new PrintWriter(clientSocket.getOutputStream(), true);
			    this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			    this.stdIn = new BufferedReader(new InputStreamReader(System.in)); //gets the responce of the server socket
			}
		}
		catch(IOException io)
		{
			System.out.println("Error: Input Stream");
			System.out.println(io);
		}
	
		try
		{
			String userInput; //Will store the input from the stream
			
			while ((userInput = in.readLine()) != null)
			{
				out.println(userInput);
			    System.out.println("echo: " + userInput);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

/**
method signup
creates a new user and sends it to the server
*/
	public  void signup()
	{
	//sends requerst to the list of users in the server
	}

	/**
	 * closes the connection of the clientSocket
	 */
	public void close()
	{
		try 
		{
			System.out.println("Closing Connection -- Client");
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Error: Closing connection");
			e.printStackTrace();
		}
	}
}

