package service.impl;

import config.Initializer;
import bean.User;
import dao.inter.UserDaoInter;
import java.util.List;

public final class UserServiceImpl extends AbstractUserService {

    protected UserServiceImpl(){

    }

    private UserDaoInter userDaoInter = UserDaoInter.instance();

    //mushteriden user haqqinda her sheyi sorushub user obyekti qaytarirsiniz
    @Override
    public User askAllFieldsToClient() {
        return null;
    }

    //userin username ve parolunu sorushub user obyekti qaytarirsiniz
    @Override
    public User askUsernameAndPassword() {
        return null;
    }

    @Override
    public User getLoggedInUser(){
        return Initializer.config.getLoggedInUser();
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoInter.getAllUsers();
    }

    @Override
    public List<User> getAllInActiveUsers() {
        return userDaoInter.getAllInActiveUsers();
    }

    @Override
    public List<User> getAllActiveUsers() {
        return userDaoInter.getAllActiveUsers();
    }

    @Override
    public boolean register() {
        User user = askAllFieldsToClient();
        return userDaoInter.add(user);
    }

    @Override
    public boolean approveUser() {
        printAllInActiveUsers();
        String id = askForUserId();
        User user = getUserById(id);
        user.setStatus(1);
        return userDaoInter.save(user);
    }

}
