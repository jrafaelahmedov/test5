package bean;

import java.util.List;

public class Config extends AbstractConfig{

    private User loggedInUser;
    private List<User> allUsers;

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
