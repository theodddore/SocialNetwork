package Server;

/**
 * 
 * @author Theodoros Mavrikis , Haroula Velisarakou , Sotiria Louka
 * Runs in the server side 
 * listens to requests made by the client
 */
public class server_main {
	/**
	 * Starts the server 
	 * Step 1 LOAD USERS
	 * Step 2 CREATE SOCKET
	 * Step 3 LISTEN FOR REQUESTS FROM THE CLIENTS
	 * @param args
	 */
	public static void main(String args[])
	{
		server svr = new server();
		//svr.LoadUsers();
		svr.startServer();
		svr.listen();
		
		//svr.close();
	}
}
