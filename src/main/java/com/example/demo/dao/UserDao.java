package com.example.demo.dao;

import com.example.demo.domains.User;

import java.util.List;

public interface UserDao {

    void insertUser(User user);


    List<User> getAllUsers();
}
