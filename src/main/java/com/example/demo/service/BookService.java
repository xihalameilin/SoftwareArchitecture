package com.example.demo.service;

import com.example.demo.domains.Book;
import com.example.demo.domains.User;

public interface BookService {
    String borrow(User user,Book book);
}
