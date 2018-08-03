package config;

import bean.Config;
import bean.User;
import service.impl.DI;
import service.inter.FileManagerServiceInter;
import java.util.Arrays;

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
            config.setAllUsers(Arrays.asList(user));
            fms.refreshConfig();//
            initialize();
        }
    }


}
