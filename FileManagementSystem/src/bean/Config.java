package bean;

import java.io.Serializable;
import java.util.List;

public class Config implements Serializable{

    private User loggedInUser;
    private List<User> allUsers;
    public static final String fileName = "fmsconfig.ser";

    public List<User> getAllUsers() {
        return allUsers;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
}
