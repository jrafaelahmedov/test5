package service.impl;

import dao.impl.UserDaoImpl;
import dao.inter.UserDaoInter;
import service.inter.FileManagerServiceInter;
import service.inter.MenuServiceInter;
import service.inter.UserServiceInter;

public class DI {//Dependency Injection

    private static MenuServiceInter menuService = null;
    private static FileManagerServiceInter fileManagerService = null;
    private static UserDaoInter userDao = null;
    private static UserServiceInter userService = null;


    public static UserServiceInter userService(){
//        System.out.println("user service method");
        if(userService == null){
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public static MenuServiceInter menuService(){
//        System.out.println("menu service method started");
        if(menuService==null){
            menuService = new MenuServiceImpl();
        }
        return menuService;
    }

    public static FileManagerServiceInter fileManagerService(){
//        System.out.println("fileManagerService service method started");
        if(fileManagerService==null){
            fileManagerService = new FileManagerServiceImpl();
        }
        return fileManagerService;
    }

    public static UserDaoInter userDao(){
//        System.out.println("userDao method started");
        if(userDao==null){
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

}
