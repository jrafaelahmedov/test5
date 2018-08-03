package service.impl;

import bean.MessageConstant;
import config.Initializer;
import bean.User;
import service.inter.UserServiceInter;

import java.util.List;
import java.util.Scanner;

abstract class AbstractUserService implements UserServiceInter {

    public String askForUserId() {
        System.out.println(MessageConstant.whichUserToApprove);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public User getUserById(String id) {
        List<User> allUsers = getAllUsers();
        if(allUsers==null || allUsers.size()==0){
            return null;
        }
        for(User user: allUsers){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User login() {
        User enteredUser = askUsernameAndPassword();
        List<User> allActiveUsers = getAllActiveUsers();
        for(User user:allActiveUsers){
            if(user.getUsername().equals(enteredUser.getUsername()) &&
                    user.getPassword().equals(enteredUser.getPassword())){
                Initializer.config.setLoggedInUser(user);
                return user;
            }
        }

        throw new IllegalArgumentException("Invalid username or password");
    }

    @Override
    public void printAllUsers() {
        List<User> users = getAllUsers();
        System.out.println(users);
    }

    @Override
    public void printAllActiveUsers() {
        List<User> users = getAllActiveUsers();
        System.out.println(users);
    }

    @Override
    public void printAllInActiveUsers() {
        System.out.println(MessageConstant.allInActiveUsers);
        List<User> users = getAllInActiveUsers();
        System.out.println(users);
    }

    @Override
    public void printMySelf() {
        User user = Initializer.config.getLoggedInUser();
        System.out.println(user);
    }

}
