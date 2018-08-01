package service.impl;

import bean.Config;
import bean.User;
import config.Initializer;
import service.inter.UserServiceInter;
import util.ReadFileIO;
import util.WriteToFileIO;

import java.util.List;

public final class FileManagerServiceImpl extends AbstractFileManager {

    protected FileManagerServiceImpl(){

    }

    private UserServiceInter userServiceInter = DI.userService();

    @Override
    public boolean checkUserAccessToFile(String fileOrFolderPath) {
        User user =  userServiceInter.getLoggedInUser();
        List<String> nonAccessibleFileOrFolders = user.getNonAccessableFilesOrFolders();
        boolean hasAccess = !nonAccessibleFileOrFolders.contains(fileOrFolderPath);
        return hasAccess;
    }


    @Override
    public String getSelectedFileOrFolderPath() {
        //Mushteriden Scanner vasitesile file ve ya folder adi teleb olunacaq ve return olunacaq
        return null;
    }

    @Override
    public boolean isItFolder(String path) {
        //burada path eger fodlerdirse return true eks halda false qaytarirsiniz.
        return false;
    }

    @Override
    public void printAllSubFilesAndFolders(String folderPath) {
        //bu methoda gonderilen folder path-in ichinde olan butun folder ve file adlarini alt-alta printe versin
    }

    @Override
    public Config readConfig() {
        return (Config) ReadFileIO.readFileDeserialize(Config.fileName);//Config obyektini filedan oxumaq lazimdir.
    }

    @Override
    public boolean refreshConfig() {
        return WriteToFileIO.writeObjectToFile(Initializer.config, Config.fileName);
    }

}
