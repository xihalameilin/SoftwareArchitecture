package com.example.demo.serviceImpl;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.RecordDao;
import com.example.demo.daoImpl.BookDaoImpl;
import com.example.demo.daoImpl.RecordDaoImpl;
import com.example.demo.domains.Book;
import com.example.demo.domains.DefaultConstant;
import com.example.demo.domains.Record;
import com.example.demo.domains.User;
import com.example.demo.service.BookService;

import java.util.ArrayList;
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

    @Override
    public List<Book> getAllBook(String identity) {
        List<Book> books = bookDao.getAllBooks();
        List<Book> result = new ArrayList<>();
        List<String> catagory = new ArrayList<>();
        if(identity.equals("学生"))
            catagory = DefaultConstant.STUDNET_category;
        else if(identity.equals("教师"))
            catagory = DefaultConstant.TEACHER_category;
        else if(identity.equals("研究生"))
            catagory = DefaultConstant.POSRGRADUATE_category;
        for(Book book:books){
            if(catagory.contains(book.getCategory()))
                result.add(book);
        }
        return result;
    }

    @Override
    public List<Record> getRecordByUserID(int userID) {
        return recordDao.getAllRecords(userID);
    }


}
