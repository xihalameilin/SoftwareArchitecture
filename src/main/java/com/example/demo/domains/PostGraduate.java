package com.example.demo.domains;

import com.example.demo.daoImpl.RecordDaoImpl;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class PostGraduate extends  User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    private final String identity = "学生";

    @Override
    public String getIdentity() {
        return identity;
    }

    @Override
    public String borrow(Book book) {
        int already = new RecordDaoImpl().getBookNumAlreadyBorrowed(id);
        if(already>=DefaultConstant.POSRGRADUATE_MAX_NUM){
            return "最多借阅20本,不能再借阅";
        }
        if(!DefaultConstant.POSRGRADUATE_category.contains(book.getCategory())){
            return "此类别不能借阅";
        }
        else{
            Record record = new Record();
            record.setBookID(book.getId());
            record.setCategory(book.getCategory());
            record.setBookname(book.getName());
            record.setFlag(1);
            record.setTime(new Date());
            record.setUserID(id);
            new RecordDaoImpl().insertRecord(record);
            return "研究书籍借阅成功";
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}