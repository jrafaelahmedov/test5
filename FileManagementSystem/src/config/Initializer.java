package config;

import bean.Config;
import bean.User;
import service.impl.DI;
import service.inter.FileManagerServiceInter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initializer {

    public static Config config;

    private static FileManagerServiceInter fms = DI.fileManagerService();

    public static void initialize() throws Exception{
        config = fms.readConfig();//null

        if(config==null){
            User user = new User("admin","admin");
            user.setPosition(1);//admin
            user.setStatus(1);//active
            config = new Config();
            List<User> list = new ArrayList<>();
            list.add(user);
            config.setAllUsers(list);
            fms.refreshConfig();//
            initialize();
        }else{
            List<User> list = new ArrayList<>(config.getAllUsers());
            config.setAllUsers(list);
        }
    }


}
