package com.example.demo.domains;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class Admin extends User{
    @Id
    private String userid;

    private String name;

    private String password;

    @Override
    public String getIdentity() {
        return identity;
    }

    private final String identity = "管理员";

    @Override
    public String borrow(Book book) {
        //根据已经借阅的数量 类别等借书
        return null;
    }

    @Override
    public String getUserid() {
        return userid;
    }

    @Override
    public void setUserid(String userid) {
        this.userid = userid;
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
