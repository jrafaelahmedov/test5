import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User>{//unique
    private String name;//Sarkhan   251324538
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Comparator<User> comparator =new Comparator<User>() {

        public int compare(User o1, User o2) {//+,-,0
            int res = o2.age-o1.age;
            return res;//+,-,==
        }
    };


    @Override
    public int compareTo(User o) {
        System.out.println("user comparet to");
        return comparator.compare(this,o);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
