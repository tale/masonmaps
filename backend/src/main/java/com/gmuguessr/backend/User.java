package com.gmuguessr.backend;

/**
 * The User class represents a user with a name, user type, and unique ID.
 * @author Saarthak Sethi
 */
public class User {
    /**
     * String instance variable for storing the user's name.
     */
    private String username;
    /**
     * Enum instance variable for storing the user's type.
     */
    private UserType userType;
    /**
     * Integer instance variable for storing the user's unique ID.
     */
    private int userID;
    
    /**
     * Parameterized constructor for Users.
     * @param name initial username.
     * @param type initial user type.
     * @param ID initial user ID.
     */
    public User(String name, UserType type, int ID) {
        this.username = name;
        this.userType = type;
        this.userID = ID;
    }
    
    /**
     * Alternate Constructor for Users, takes in only the name and 
     * provides default valued for all other fields.
     * 
     * @param name - Name of the user.
     */
    public User(String name) {
    	this(name, UserType.newOffCampusStudent, 1);
    }

    /**
     * Mutator for the user's name variable.
     * @param newName the user's new name.
     */
    public void setName(String newName) {
        this.username = newName;
    }
    /**
     * Accessor for the user's name variable.
     * @return the user's name.
     */
    public String getName() {
        return this.username;
    }

    /**
     * Mutator for the user's type variable.
     * @param newUserType the user's new type.
     */
    public void setUserType(UserType newUserType) {
        this.userType = newUserType;
    }
    /**
     * Accessor for the user's type variable.
     * @return the user's type Enum.
     */
    public UserType getUserType() {
        return this.userType;
    }

    /**
     * Mutator for the user's ID variable.
     * @param newID the user's new ID.
     */
    public void setUserID(int newID) {
        this.userID = newID;
    }
    /**
     * Accessor for the user's ID variable.
     * @return the user's ID.
     */
    public int getUserID() {
        return this.userID;
    }
}