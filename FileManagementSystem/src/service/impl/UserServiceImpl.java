package service.impl;

import config.Initializer;
import bean.User;
import dao.inter.UserDaoInter;
import java.util.List;
import java.util.Scanner;

public final class UserServiceImpl extends AbstractUserService {

    private UserDaoInter userDaoInter;//impl polymorphyzim  loosely coupling

    protected UserServiceImpl(){//
        userDaoInter = DI.userDao();
    }


    @Override
    public boolean checkUserAccessToFile(String fileOrFolderPath) {
        User user =  getLoggedInUser();
        List<String> nonAccessibleFileOrFolders = user.getNonAccessableFilesOrFolders();
        boolean hasAccess = !nonAccessibleFileOrFolders.contains(fileOrFolderPath);
        return hasAccess;
    }

    @Override
    public void setNonAccessibleFileOrFoldersForUser() {
        //sechilen userin idsine gore useri tapib hemin userin daxil ola bilmeyeceyi file ve ya folderleri admin daxil ede bilmesi lazimdir

    }

    //mushteriden user haqqinda her sheyi sorushub user obyekti qaytarirsiniz
    @Override
    public User askAllFieldsToClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("name:");
        String name = sc.nextLine();

        System.out.println("surname:");
        String surname = sc.nextLine();

        System.out.println("username:");
        String username = sc.nextLine();

        System.out.println("password");
        String password = sc.nextLine();
        return new User(name,surname, username,password);
    }

    //userin username ve parolunu sorushub user obyekti qaytarirsiniz
    @Override
    public User askUsernameAndPassword() {
        Scanner sc = new Scanner(System.in);

        System.out.println("username:");
        String username = sc.nextLine();

        System.out.println("password");
        String password = sc.nextLine();
        return new User(username,password);
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
        List<User> users = getAllInActiveUsers();
        if(users.size()==0){
            System.out.println("there is not any inactive users");
            return false;
        }
        printAllInActiveUsers();//
        String id = askForUserId();
        User user = getUserById(id);
        user.setStatus(1);
        return userDaoInter.save(user);
    }

}
