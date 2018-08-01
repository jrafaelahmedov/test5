package service.inter;

import bean.User;

import java.util.List;

public interface UserServiceInter {

        public List<User> getAllUsers();

        public User getLoggedInUser();

        public boolean register(); // this method will write user object to file

        public boolean approveUser();// this method will approve User, set User status to 1 from 0; user.setStatus(1);

        public void printAllUsers();//must print all users

        public void printAllActiveUsers();//must print all active users

        public void printAllInActiveUsers();//must print all active users

        public void printMySelf();//must print all active users

        public User askAllFieldsToClient();//must print all active users

        public User askUsernameAndPassword();

        public List<User> getAllInActiveUsers();//must print all inactive users

        public List<User> getAllActiveUsers();//must print all active users

        public User login();


}
