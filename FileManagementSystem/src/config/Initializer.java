package config;

import bean.Config;
import service.impl.DI;
import service.inter.FileManagerServiceInter;

public class Initializer {

    public static Config config;

    private static FileManagerServiceInter fms = DI.fileManagerService();

    public static void initialize(){
        config = fms.readConfig();
    }


}
