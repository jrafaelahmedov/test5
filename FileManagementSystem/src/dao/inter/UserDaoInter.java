package dao.inter;

import bean.User;
import dao.impl.UserDaoImpl;

import java.util.List;

public interface UserDaoInter {

        public boolean add(User user);

        public boolean save(User user);

        public List<User> getAllUsers();//must print all users

        public List<User> getAllInActiveUsers();//must print all inactive users

        public List<User> getAllActiveUsers();//must print all active users

        public static UserDaoInter instance(){
                return new UserDaoImpl();
        }
}
