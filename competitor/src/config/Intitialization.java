package config;

import beans.User;
import util.FileUtil;

public class Intitialization {

    public static Config config = null;

    public static void initializeConfig(User user){
        config = new Config(user);//silinir
        try {
            Object configObj = FileUtil.readObjectFromFile("config.ser");//Config null
            config = (Config) configObj;//null
        }catch(Exception ex){
            //ignore
            //ex.printStackTrace();
        }
    }

    public static void refreshConfig(){
        FileUtil.writeObjectToFile(config,"config.ser");
    }
}
