package main;

import java.util.ArrayList;

public class Register {
    private boolean success;

    public Register(ArrayList<User> users, String name, String email, String password) {
        if (!isDuplicateEmail(users, email)) {
            users.add(new User(name, email, password));
            this.success = true;
        } else {
            this.success = false;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    private boolean isDuplicateEmail(ArrayList<User> users, String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
}
