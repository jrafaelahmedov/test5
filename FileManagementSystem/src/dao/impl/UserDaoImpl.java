package dao.impl;

import config.Initializer;
import bean.User;
import dao.inter.UserDaoInter;
import service.impl.DI;
import service.inter.FileManagerServiceInter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDaoInter {

    FileManagerServiceInter fms = DI.fileManagerService();

    @Override
    public boolean add(User user) {
        List<User> list = getAllUsers();
        list.add(user);
        return fms.refreshConfig();
    }

    @Override
    public boolean save(User user) {
        return fms.refreshConfig();
    }

    @Override
    public List<User> getAllUsers() {
        //must select all users from file
        return Initializer.config.getAllUsers();
    }


    @Override
    public List<User> getAllActiveUsers(){
        List<User> allUsers = getAllUsers();
        if(allUsers==null || allUsers.size()==0){
            return Collections.emptyList();
        }

        List<User> activeUsers = new ArrayList<>();

        for(User u: allUsers){
            if(u.getStatus()==1){
                activeUsers.add(u);
            }
        }
        return activeUsers;
    }

    @Override
    public List<User> getAllInActiveUsers(){
        List<User> allUsers = getAllUsers();
        if(allUsers==null || allUsers.size()==0){
            return Collections.emptyList();
        }

        List<User> inactiveUsers = new ArrayList<>();

        for(User u: allUsers){
            if(u.getStatus()==0){
                inactiveUsers.add(u);
            }
        }
        return inactiveUsers;
    }


}
