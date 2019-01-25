package com.example.demo.domains;


import com.example.demo.daoImpl.RecordDaoImpl;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "users")
public class Teacher extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    @Override
    public String getIdentity() {
        return identity;
    }

    private final String identity = "老师";




    @Override
    public String borrow(Book book) {
        int already = new RecordDaoImpl().getBookNumAlreadyBorrowed(id);
        if(already>=DefaultConstant.TEACHER_MAX_NUM){
            return "最多借阅15本,不能再借阅";
        }
        if(!DefaultConstant.TEACHER_category.contains(book.getCategory())){
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
            return "辅导书籍借阅成功";
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
