import beans.Competitor;
import beans.User;
import config.Intitialization;
import util.FileUtil;
import util.MenuUtil;
import util.UserUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    /*0. login olmagim teleb olunur, 3 defe sehv etsem xeta versin ve sistemden cixsin.+
    * 1. menu cixir ve mene gosterir ki, men ne etmek isteyirem? 1- yarishmacilari daxil et, 2-yarishmaya bashla 3-xalini oyren 4-logout+
    * 2. yarishmacilari daxil et sechirem bu zaman menden neche
    * yarishmaci oldugu soruhulur, ve hemin yarishmacilarin
    * adi, soyadi, yashi teleb olunur +
    * 3. yarishmaya bashla sechirem bu zaman sistem ozu arxa planda hazir bir index goturur ve menden hansi yarishmacinin qalib oldugunu
    * sorushur eger duz tapsam menim xalimi artirir +
    * 4. logout sechsem bu zaman yeniden login sehifesine qaytarir,.
    * */
    public static void main(String[] args) throws Exception {
//        User user = UserUtil.requireInputsAndLogin(1,true);//Sarkhan 12345
//
//        Intitialization.initializeConfig(user);//
//
//        System.out.println("Hello, "+user.getUsername());
//        MenuUtil.showMenuInfinite();

        User[] users = new User[2];

        System.out.println( users.getClass().getSuperclass().getName());
//        System.out.println( objects.getClass().getSimpleName());;
//        Class[] classes = competitors.getClass().getInterfaces()Classes();
//        Class[] classes = competitors.getClass().getEnclosingClass()DeclaredClasses();
//        Class[] classes = competitors.getClass().getInterfaces();
//        for(Class c: classes){
//            System.out.println(c.getName());
//            System.out.println(c.getSimpleName());
////            System.out.println(c.getSuperclass().getName());
////            System.out.println(c.getSuperclass().getSimpleName());
//        }
//        System.out.println(competitors.getClass().getDeclaringClass().getName());
    }
}
