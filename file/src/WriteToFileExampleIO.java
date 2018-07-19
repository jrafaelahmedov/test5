import java.io.*;

public class WriteToFileExampleIO {

    private static final String FILENAME = "E:\\test\\filename.txt";

    public static void writeUsingBufferedWriter(){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "This is the content to write into file\n";

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    public static void writeUsingBufferedWriterAutoCloseable(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            String content = "This is the content to write into file\n";

            bw.write(content);

            // no need to close it.
            //bw.close();

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void writeUsingFileWriter(String data, boolean append) {
        File file = new File("test ");
        try(FileWriter fr = new FileWriter(file, append)) {
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeUsingFileWriter(String data) {
        writeUsingFileWriter(data,false);
    }

    private static void writeUsingOutputStream(String data) {
        File f = new File("test");//pass, working directory

        try(OutputStream os = new FileOutputStream(f)) {///try-with-resources
            os.write(data.getBytes(), 0, data.length());
            //x exception
        } catch (IOException e) {
            e.printStackTrace();
        }

        //finally, try-with-resources

    }


    public static void writeObjectToFile(Object object, String name){
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {

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

    public static void main(String[] args) {
        writeUsingOutputStream("Salam");
    }

}