package util;
import java.io.*;
public class FileUtil {

    public static void writeObjectToFile(Object object, String name){
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {//try-with-resources

            fout = new FileOutputStream(name);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(object);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static Object readObjectFromFile(String name) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
        Object obj = in.readObject();
        return obj;
    }
}