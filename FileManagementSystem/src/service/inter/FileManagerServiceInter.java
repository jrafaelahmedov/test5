package service.inter;

import bean.Config;

public interface FileManagerServiceInter {

    public String getSelectedFileOrFolderPath();

    public boolean checkUserAccessToFile(String filePath);

    public boolean isItFolder(String path);

    public void printAllSubFilesAndFolders(String folderPath);

    public void printAllSubFoldersOrFileName();

    public Config readConfig();

    public boolean refreshConfig();

}
