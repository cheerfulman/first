package Dao;

import User.User;

public class TextDao {
    public static void main(String[] args) {
        User user = new User();
        user.setPrice(50);
        user.setUsername("zhu");
        UserDao.addPrice(user);
        System.out.println(321);
    }
}
