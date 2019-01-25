package com.example.demo.dao;

import com.example.demo.domains.User;

import java.util.List;

public interface UserDao {

    void insertUser(User user);


    List<User> getAllUsers();


    void changeIdentity(int userID,int type);

    boolean isRegister(String username);

    List<User> getUsers(int type);

    User getUserByUserID(int userID);
}
