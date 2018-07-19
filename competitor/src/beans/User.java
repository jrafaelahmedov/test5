package beans;

import config.Config;
import config.Intitialization;

import java.io.Serializable;

public class User implements Serializable{
    private String username;
    private String password;
    private int point;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
        Intitialization.refreshConfig();
    }

}
