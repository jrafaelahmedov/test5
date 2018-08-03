package service.impl;

import bean.MessageConstant;
import bean.User;
import service.inter.MenuServiceInter;
import service.inter.UserServiceInter;
import java.util.Scanner;

//Burada hech neye toxunmayin her shey hazirdir.
public final class MenuServiceImpl implements MenuServiceInter {

    private UserServiceInter userService = DI.userService();

    protected MenuServiceImpl( ){
//        System.out.println("menu service constructor");

    }


    @Override
    public int showMenu() {
        Scanner sc = new Scanner(System.in);
//        System.out.println("show menu userservice="+userService);
        User loggedInUser = userService.getLoggedInUser();
        if(loggedInUser!=null) {
            if (loggedInUser.isAdmin()) {
                System.out.println(MessageConstant.menuDescriptionAfterLoginAdmin);
            }else{
                System.out.println(MessageConstant.menuDescriptionAfterLoginUser);
            }
        }else{
            System.out.println(MessageConstant.menuDescriptionBeforeLogin);
        }
       int selectedMenu =  sc.nextInt();
       return selectedMenu;
    }
}
