package com.example.demo.service;

import com.example.demo.domains.Book;
import com.example.demo.domains.Message;
import com.example.demo.domains.User;
import java.util.List;

public interface BookService {

    /**
    *@Author : LML
    *@Date : 17:08 2019/1/25
    *@Desciption : 借书
    */
    String borrow(User user,Book book);

   List<Book> getAllBook();

   void returnBook(int userID,int bookID);
}
