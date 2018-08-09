package service.impl;

import config.Initializer;
import bean.User;
import dao.inter.UserDaoInter;
import service.inter.FileManagerServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class UserServiceImpl extends AbstractUserService {

    private UserDaoInter userDaoInter;//impl polymorphyzim  loosely coupling

    protected UserServiceImpl() {//
        userDaoInter = DI.userDao();
    }


    @Override
    public boolean checkUserAccessToFile(String fileOrFolderPath) {
        User user = getLoggedInUser();
        List<String> nonAccessibleFileOrFolders = user.getNonAccessableFilesOrFolders();
        boolean hasAccess = !nonAccessibleFileOrFolders.contains(fileOrFolderPath);
        return hasAccess;
    }

    @Override
    public void setNonAccessibleFileOrFoldersForUser() {
        String userId = askForUserId();
        User user = getUserById(userId);
        List<String> naf = getAllNonAccessibeFileOrFolders();
        user.setNonAccessableFilesOrFolders(naf);
        userDaoInter.save(user);
    }


    @Override
    public List<String> getAllNonAccessibeFileOrFolders() {
        //burada adminden accessi olmayan file ve folderlerin listini return edirsiniz scanner ile alib return edirsiniz.
        Scanner scan = new Scanner(System.in);
        System.out.println("How many file or folder you want to ignore?");
        int count = scan.nextInt();
        System.out.println("Please insert non access files or folders directory: ");
        scan.nextLine();
        String nonAccesFileOrFolders = scan.nextLine();
        List<String> nonAccesFileslist = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            nonAccesFileslist.add(i, nonAccesFileOrFolders);
        }
        return nonAccesFileslist;
    }

    @Override
    public List<String> getAllFileOrFolders() {
        User user = getUserById("admin");
        List<String> fileslist = user.getAdminFilesOrFolders();
        System.out.println(fileslist.toString());
        return fileslist;
    }

    @Override
    public void setAllFileOrFolders() {
        //Scanner scan = new Scanner(System.in);
        User user = getUserById("admin");
        List<String> fileslist = getAdminFileOrFolders();
        user.setAdminFilesOrFolders(fileslist);
        userDaoInter.save(user);
    }


    private static List<String> getAdminFileOrFolders() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many file or folder you want to insert?");
        int count = scan.nextInt();
        List<String> adminFileslist = new ArrayList<>();
        System.out.println("Please insert files or folders directory: ");
        for (int i = 0; i < count; i++) {
            String fileOrFolders = scan.nextLine();
            adminFileslist.add(i, fileOrFolders);
        }
        return adminFileslist;
    }


    FileManagerServiceInter fms = DI.fileManagerService();


    @Override
    public String askForPath() {
        //mushteriden daxil olmasini istediyi file ve ya folderin adini isteyeceksiniz
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter File or Folder name: ");
        String path = scan.nextLine();
        return path;
    }

    @Override
    public void printAllSubFilesAndFolders() {
        String path = askForPath();
        boolean hasAccess = checkUserAccessToFile(path);
        if (hasAccess) {
            fms.printAllSubFilesAndFolders(path);
        } else {
            System.out.println("You don't have an access");
        }
    }

    //mushteriden user haqqinda her sheyi sorushub user obyekti qaytarirsiniz
    @Override
    public User askAllFieldsToClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please insert your name:");
        String name = sc.nextLine();

        System.out.println("Please insert your surname:");
        String surname = sc.nextLine();

        System.out.println("Please insert your username:");
        String username = sc.nextLine();

        System.out.println("Please insert your password");
        String password = sc.nextLine();
        return new User(name, surname, username, password);
    }

    //userin username ve parolunu sorushub user obyekti qaytarirsiniz
    @Override
    public User askUsernameAndPassword() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please insert your username:");
        String username = sc.nextLine();

        System.out.println("Please insert your password");
        String password = sc.nextLine();
        return new User(username, password);
    }

    @Override
    public User getLoggedInUser() {
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
        if (users.size() == 0) {
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
