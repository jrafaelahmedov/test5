import main.*;

import java.util.ArrayList;
import java.util.List;

public class Main {//Main.class

    public static void main(String[] args) {
        Wrapper<Human, Person, Teacher>  w = new Wrapper<>();
        accept(w);
    }

    public static void accept(Wrapper<?,Person,Teacher> w){//unbound
       Object obj =  w.getT();
       Person p = w.getE();
    }


    /*
    * 1. Generic nece elan olunur ve nece istifade olunur class seviyyesinde
    * 2. Diamond operator 1.7-den sonra
    * 3. Sadece Humanlara xidmet ede bilen generic classin yaradilmasi
    * 4. Genericin methodlarda bir basha istifadesi
    * 5. Generic bize compile time type safety verir.
    * 6. Wildcard ?,,,  Lower bound(? super Human), Upper bound( ? extends Human), unbound(?)
    * 7. type eraser and raw type - tipin silinmesi - interviewlarda cox sorushulur
    * 8. Bir neche tipin istifade olunmasi
    * 9. Generic class diger generic classdan extends etmesi
    *
    * suallar lower boundun tetbiq sahesi
    * unboundun tetbiq sahesi
    * */

}
