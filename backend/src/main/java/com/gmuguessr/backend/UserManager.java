package com.gmuguessr.backend;

import java.util.ArrayList;

/**
 * Responsible for managing multiple users at once.
 */
public class UserManager {

	private ArrayList<User> users;
	private int id;
	
	/**
	 * Default constructor - initializes fields respectively and randomizes ID.
	 */
	public UserManager() {
		this.users = new ArrayList<>();
		this.id = (int)Math.random() * 100;
	}
	
	/**
	 * Parameterized constructor - Adds its own ID respectively
	 * @param id - New id to set.
	 */
	public UserManager(int id) {
		this();
		this.setId(id);
	}

	/**
	 * Main getter for the list of users.
	 * @return - List of registered users.
	 */
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User getUser(User user) {
		for (User e : this.users) {
			if(e.equals(user)) {
				return user;
			}
		}
		
		return null;
	}

	/**
	 * Getter for the id field of the UserManager instance.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for the id field of the UserManager instance
	 * @param id - New id value for updating.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public RegistrationResult registerUser(User user) {
		
		if (this.getUser(user) != null) {
			return new RegistrationResult();
		}
		
		this.users.add(user);
		return new RegistrationResult(true, user.getUserID());
	}
	
	public RegistrationResult registerUser(String name, String pass, String email, UserType type) {
		int res = 0;
		
		for (int i = 0; i < 3; i++) {
			res += (int)(pass.charAt(i)) + (int)(email.charAt(i));
		}
		
		User user = new User(name, type, res);
		
		return registerUser(user);
	}

	/**
	 * Searches for a certain user based on inputed parameters and returns a 
	 * boolean indicating if the user is registered to this UserManager.
	 * 
	 * @param name - Username of the target user.
	 * @param type - Type of target user.
	 * @param userid - ID of target user.
	 * @return True if the user is registered; false otherwise
	 */
	public boolean loginUser(String name, UserType type, int userid) {
		
		for (User e : users) {
			if (e.getName().equals(name)) {
				if ((e.getUserID() == userid) && (e.getUserType() == type)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
}
