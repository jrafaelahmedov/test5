package service.impl;

import bean.MessageConstant;
import bean.User;
import service.inter.MenuServiceInter;
import service.inter.UserServiceInter;
import java.util.Scanner;

//Burada hech neye toxunmayin her shey hazirdir.
public final class MenuServiceImpl implements MenuServiceInter {

    protected MenuServiceImpl(){

    }

    private UserServiceInter userService = DI.userService();

    @Override
    public int showMenu() {
        Scanner sc = new Scanner(System.in);
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
