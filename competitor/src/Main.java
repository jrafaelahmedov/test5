import beans.User;
import config.Config;
import util.MenuUtil;
import util.UserUtil;

public class Main {


    /*0. login olmagim teleb olunur, 3 defe sehv etsem xeta versin ve sistemden cixsin.+
    * 1. menu cixir ve mene gosterir ki, men ne etmek isteyirem? 1- yarishmacilari daxil et, 2-yarishmaya bashla 3-xalini oyren 4-logout+
    * 2. yarishmacilari daxil et sechirem bu zaman menden neche
    * yarishmaci oldugu soruhulur, ve hemin yarishmacilarin
    * adi, soyadi, yashi teleb olunur +
    * 3. yarishmaya bashla sechirem bu zaman sistem ozu arxa planda hazir bir index goturur ve menden hansi yarishmacinin qalib oldugunu
    * sorushur eger duz tapsam menim xalimi artirir +
    * 4. logout sechsem bu zaman yeniden login sehifesine qaytarir,.
    *
    * */
    public static void main(String[] args) {
        User user = UserUtil.requireInputsAndLogin(1,true);

        System.out.println("Hello, "+user.getUsername());
        MenuUtil.showMenuInfinite();
    }
}
