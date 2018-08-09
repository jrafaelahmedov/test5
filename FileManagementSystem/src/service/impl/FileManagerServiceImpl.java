package service.impl;

import bean.Config;
import config.Initializer;
import jdk.nashorn.internal.ir.Terminal;
import util.ReadFileIO;
import util.WriteToFileIO;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public final class FileManagerServiceImpl extends AbstractFileManager {

    protected FileManagerServiceImpl() {
//        System.out.println("FileManagerServiceImpl construcor");
    }

    @Override
    public String getSelectedFileOrFolderPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert file or folder name");
        String folderOrFileName = scanner.nextLine();
        return folderOrFileName;
        //Mushteriden Scanner vasitesile file ve ya folder adi teleb olunacaq ve return olunacaq
    }

    @Override
    public boolean isItFolder(String path) {
        //burada path eger folderdirse return true eks halda false qaytarirsiniz.
        // boolean exists = Files.exists(file);        // Check if the file exists
        // boolean isFile = Files.isRegularFile(file); // Check if it's a regular file
        Path file = new File(path).toPath();
        boolean isDirectory = Files.isDirectory(file);   // Check if it's a directory
        return isDirectory;
    }

    @Override
    public void printAllSubFilesAndFolders(String folderPath) {
        //bu methoda gonderilen folder path-in ichinde olan butun folder ve file adlarini alt-alta printe versin
        Path file = new File(folderPath).toPath();
     // boolean exists = Files.exists(file);        // Check if the file exists
        boolean isDirectory = Files.isDirectory(file);   // Check if it's a directory
        boolean isFile = Files.isRegularFile(file); // Check if it's a regular file
        if (isDirectory) {
            System.out.println("cd "+file+" %d");
            System.out.println( System.getProperty(file.toString()));
        } else if (isFile) {
            System.out.println("dir");
        }
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
