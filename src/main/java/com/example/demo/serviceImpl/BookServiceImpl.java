package com.example.demo.serviceImpl;

import com.example.demo.domains.Book;
import com.example.demo.domains.User;
import com.example.demo.service.BookService;

public class BookServiceImpl implements BookService{
    @Override
    public String borrow(User user, Book book) {
        return user.borrow(book);
    }
}
