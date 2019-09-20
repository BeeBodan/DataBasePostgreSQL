package com.bogdan;

import com.bogdan.Dao.UserDao;
import com.bogdan.model.User;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        System.out.println("=================== CLEAR DATA BASE AND ADD NEW USERS =====================");
        userDao.removeAll();
        userDao.addUser(new User("Masha",26));
        userDao.addUser(new User("Bob",24));
        userDao.addUser(new User("Alex",18));
        userDao.addUser(new User("Viki",22));
        userDao.addUser(new User("Ana",27));

        System.out.println("=================== GET USER BY ID, NAME AND ALL USERS =====================");
        System.out.println("User by id: " + userDao.getUserById(2));
        System.out.println("User by name: " + userDao.getUserByName("Masha"));
        System.out.println("All users: " + userDao.getAllUsers());

        System.out.println("=================== CHANGE SOME INFO USER =====================");
        User user = userDao.getUserByName("Ana");
        System.out.println("User by name: " + user);
        user.setAge(37);
        userDao.updateUser(user);
        System.out.println("Updated user: " + userDao.getUserByName("Ana"));

        System.out.println("=================== DELETE USERS BY ID AND NAME =====================");
        userDao.removeUserById(3);
        userDao.removeUserByName("Viki");
    }
}
