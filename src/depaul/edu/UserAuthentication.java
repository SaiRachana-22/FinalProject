package depaul.edu;

import java.util.HashMap;
import java.util.Map;


public class UserAuthentication {
	
	private Map<String, String> users;
	private String currentUser; 

	public UserAuthentication() {
		this.users = new HashMap<>();
	    // Simulated database or external source
	    this.users.put("user1", "password1");
	    this.users.put("user2", "password2");
	}

    public boolean authenticateUser(String username, String password) {
    	String storedPassword = this.users.get(username);
        if(storedPassword != null && storedPassword.equals(password)) {
        	currentUser = username;
        	System.out.println("Authentication successful for user: " + username + "\n Logged in as: " + username);
        	return true;
        } else {
            System.out.println("Authentication failed for user: " + username + "!!\n Please use correct credentials to login");
            return false;
        }
    }
    
    public String getCurrentUser() {
        return currentUser;
    }
    
}