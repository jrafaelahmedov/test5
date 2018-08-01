package service.impl;

import bean.MessageConstant;
import service.inter.FileManagerServiceInter;

public abstract class AbstractFileManager implements FileManagerServiceInter {

    public void printAllSubFoldersOrFileName(){
        String selectedFileOrFolder = getSelectedFileOrFolderPath();
        boolean hasAccess = checkUserAccessToFile(selectedFileOrFolder);
        if(hasAccess){
            boolean isItFolder = isItFolder(selectedFileOrFolder);
            if(isItFolder){
                printAllSubFilesAndFolders(selectedFileOrFolder);
            }else{
                System.out.println("Filename:"+selectedFileOrFolder);
            }
        }else{
            System.out.println(MessageConstant.hasNotAccess);
        }
    }
}
