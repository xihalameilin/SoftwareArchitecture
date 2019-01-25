package com.example.demo.serviceImpl;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.RecordDao;
import com.example.demo.daoImpl.BookDaoImpl;
import com.example.demo.daoImpl.RecordDaoImpl;
import com.example.demo.domains.Book;
import com.example.demo.domains.User;
import com.example.demo.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookDao bookDao = new BookDaoImpl();
    private RecordDao recordDao = new RecordDaoImpl();
    @Override
    public String borrow(User user, Book book) {
        return user.borrow(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookDao.getAllBooks();
    }

    @Override
    public void returnBook(int userID, int bookID) {
        recordDao.returnBook(userID,bookID);
    }
}
