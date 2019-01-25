package com.example.demo.domains;

import javax.persistence.*;

@Entity
@Table(name = "users")
public abstract class User {

    @Id
    private String userid;

    private String name;

    private String password;

    private String identity;

    private String school;

    private String department;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public abstract String borrow(Book book);

    public String getUserid() {
        return userid;
    }

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

    public String toString(){
        return "name "+name+" identity "+identity+ " id "+userid +" school "+ school +" department "+department;
    }
}
