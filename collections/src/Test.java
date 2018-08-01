import java.util.*;

public class Test {

    public static void main(String[] args) {
        HashMap<User, String> hasMap = new HashMap<>();
        hasMap.put(new User("Raju",30),"Raju");

        User u = new User("Sarkhan",25);
        User u2 = new User("Sarkhan",25);
        hasMap.put(u,"Sarkhan");
        hasMap.put(u2,"Sarkhan Rasullu");//2

        System.out.println(hasMap);
    }
}
