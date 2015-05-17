package Client;

import java.util.ArrayList;



public class user
{
	int ID; 
	String	password;
	ArrayList<user> following = new ArrayList<user>();
	ArrayList<user> followers = new ArrayList<user>();
	
	/**
	 * @param ID the user's id -> His username
	 * @param password the user's password
	 */
	public user(int ID , String password)
	{
		this.ID = ID;
		this.password = password;
	}
	
	/**
	 * default constructor
	 */
	public user()
	{
		//does nothing
	}
	
	/**
	 * sets the id
	 * @param ID new username to be set
	 */
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	/**
	 * set the password
	 * @param password new password to be used
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * returns the id , the username of the user
	 * @return id of user
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * returns the password of the user
	 * @return password of user
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	*follow method:sends request to server so that the user can follow user to be followed 
	*@param tofl user to be followed 
	*/
	public void follow(user tofl)
	{
		
	}
	
	/**
	unfollow method:sends request to the server so that the user can unfollow user not to be followed
	@param notfl , user not to be followed
	*/
	public void unfollow(user notfl)
	{
		
	}
}