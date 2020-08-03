package com.bogdan;

import com.bogdan.Dao.UserDao;
import com.bogdan.model.User;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        System.out.println("=================== CLEAR DATA BASE AND ADD NEW USERS =====================");
        userDao.removeAll();
        userDao.addUser(new User("Bob",24));
        userDao.addUser(new User("Masha",26));
        userDao.addUser(new User("Tommy",19));
        userDao.addUser(new User("Alex",18));
        userDao.addUser(new User("Viki",22));
        userDao.addUser(new User("Ana",27));
        userDao.addUser(new User("Alex",33));
        userDao.addUser(new User("Poul",41));

        System.out.println("=================== GET USER BY ID, NAME AND ALL USERS =====================");
        userDao.getUserById(2);
        userDao.getUserByName("Alex");
        userDao.getAllUsers();

        System.out.println("=================== CHANGE SOME INFO USER =====================");
        User user = userDao.getUserById(2);
        user.setAge(37);
        user.setName("Moa");
        userDao.updateUser(user);
        userDao.getUserById(2);

        System.out.println("=================== DELETE USERS BY ID AND NAME =====================");
        userDao.removeUserById(2);
        userDao.removeUserByName("Alex");
    }
}
