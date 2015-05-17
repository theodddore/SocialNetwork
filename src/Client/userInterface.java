package Client;

import java.io.IOException;
import java.util.Scanner;

public class userInterface{
	String password;
	boolean flag = true;
	Scanner in;
	boolean loggedIn = false;
	user localUser;
	client cl = new client();
	
	public void menu()
	{
		cl.connect();
		boolean flag = true;
		Scanner in;
		System.out.println("Welcome!"+
						   "\nWhat do you want to do?"+
						   "\n1. Sign Up"+
						   "\n2. Log In"+
						   "\n3. Exit");
		in = new Scanner(System.in);
		int reply = 0; //Default reply
		while(flag==true){ //While input is invalid
			try{
				reply = in.nextInt();
				if(reply== 1){ //Sign Up creates new account
					System.out.println("You are client ");
					//needs fixing TODO
					in.nextLine();//consumes "\n" that nextInt left
					System.out.print("Enter your personal password: ");
					String password = this.in.nextLine(); 
					System.out.println("Thank you for joining us!");
					flag=false;
				}else if (reply== 2){ //Log in
					System.out.println("ClientID: ");
					int id = in.nextInt(); //reads id
					in.nextLine();//consumes "\n" that nextInt left
					System.out.println("Password: ");
					password = in.nextLine(); //reads password
					localUser = new user(id, password); //creates localuser to request log in
					if(logIn())//sends log in request to server
					{
						System.out.println("Successfull log in");
						loggedIn = true;
						
					}
					else
					{
						System.out.println("Log in failed");
					}
					flag = false;
				}else if (reply== 3)
				{
					System.out.println("Exiting System...");
					System.exit(0);
				}
				else{
					System.out.println("Choose a valid action (1 , 2 or 3):");
				}
			}catch(Exception e){
				System.out.println("Error: Scanner cannot read");
				e.printStackTrace();
				System.exit(0); //Error Occured
			}
		}
		//in.close();
	}
	
	public boolean logIn()
	{
		try {
			return cl.requestLogin(localUser);
		} catch (IOException e) {
			System.out.println("Error: Requesting log in");
			e.printStackTrace();
		}
		return false;
	}
	
	public void servicesMenu()
	{
		if(loggedIn == false)
		{
			
			return;
		}
		/*
		 * Needs thought for the menu Iro will implement this
		 * TODO Iro -> Create a good menu that does exactly 
		 * what the instructions say about the clent interface
		 */
		System.out.println("Welcome!"+ localUser.ID +
				   "\n Services provided:"+
				   "\n1. Show Followers"+
				   "\n2. Log In"+
				   "\n3. Exit");
		in = new Scanner(System.in);
		int reply = 0; //Default reply
	}
	
}