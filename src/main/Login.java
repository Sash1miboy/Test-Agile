package main;

import java.util.ArrayList;

public class Login {
	private boolean success;

	public Login(ArrayList<User> users, String email, String password) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
				this.success = true;			
				break;
			}
			this.success = false;
		}
	}
	
	public boolean isSuccess() {
		return success;
	}
	
}
