package com.bogdan;

import com.bogdan.model.User;

import java.util.List;

public interface Storage {

    void removeAll();

    void removeUserById(int id);

    void removeUserByName(String name);

    void addUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByName(String name);

    List<User> getAllUsers();
}