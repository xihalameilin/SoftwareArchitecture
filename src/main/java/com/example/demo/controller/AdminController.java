package com.example.demo.controller;

import com.example.demo.domains.*;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;
import com.example.demo.serviceImpl.BookServiceImpl;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AdminController")
public class AdminController {
    private BookService bookService = new BookServiceImpl();

    private UserService userService = new UserServiceImpl();
    /**
     *@Author : gsy
     *@Desciption : 得到全部的书籍
     *@return : 书籍的JSONArray
     */
    @GetMapping("/getBooks")
    public JSONArray getBooks(){
        //得到方法得到全部的书籍
        return new JSONArray(bookService.getAllBook().toString());
    }

    /**
     *@Author : gsy
     *@Desciption : 得到全部的普通学生的信息
     *@return : 学生的JSONArray
     */
    @GetMapping("/getStudents")
    public JSONArray getStudents(){

        return new JSONArray(userService.getUsers(0).toString());
    }

    /**
     *@Author : gsy
     *@Desciption : 得到全部的研究生的信息
     *@return : 研究生的JSONArray
     */
    @GetMapping("/getMasters")
    public JSONArray getMasters(){
        return new JSONArray(userService.getUsers(1).toString());
    }

    /**
     *@Author : gsy
     *@Desciption : 得到全部的老师信息
     *@return : 老师的JSONArray
     */
    @GetMapping("/getTeachers")
    public JSONArray getTeachers(){

        return new JSONArray(userService.getUsers(2).toString());
    }

    /**
     *@Author : gsy
     *@Desciption : 管理员编辑用户信息
     *@param userid
     *@param username
     *@param identity
     *@param briefcase
     *@param school
     */
    @GetMapping("/editother/{userid}/{username}/{identity}/{briefcase}/{school}")
    public void editother(@PathVariable("userid")String userid, @PathVariable("username")String username,
                             @PathVariable("identity")String identity,@PathVariable("briefcase")String briefcase,
                             @PathVariable("school")String school){
        User user = new Student();
        if(identity.equals("学生"))
            user = new Student();
        else if(identity.equals("教师"))
            user = new Teacher();
        else if(identity.equals("研究生"))
            user = new PostGraduate();
        user.setUserid(userid);
        user.setName(username);
        user.setDepartment(briefcase);
        user.setSchool(school);
        userService.updateUser(user);


    }

    /**
     *@Author : gsy
     *@Desciption : 管理员编辑书籍信息
     *@param bookid
     *@param bookname
     *@param category
     */
    @GetMapping("/editbook/{bookid}/{bookname}/{category}")
    public void editbook(@PathVariable("bookid")int bookid,@PathVariable("bookname")String bookname,
                             @PathVariable("category")String category){
        Book book = new Book();
        book.setId(bookid);
        book.setCategory(category);
        book.setName(bookname);
        bookService.updateBook(book);

    }

    /**
     *@Author : gsy
     *@Desciption : 根据userid生成借书记录
     *@param userid
     *@return : 用户的借书记录信息
     */
    @GetMapping("/generaterecords/{userid}")
    public JSONArray generaterecords(@PathVariable("userid")String userid){

        return new JSONArray(bookService.getRecordByUserID(userid));
    }

    /**
     *@Author : gsy
     *@Desciption : 根据userid生成逾期罚单
     *@param userid
     *@return : 用户的逾期罚单
     */
    @GetMapping("/generatepenalty/{userid}")
    public JSONArray generatepenalty(@PathVariable("userid")String userid){

        return new JSONArray(bookService.getAllLateRecord(userid).toString());
    }

    /**
     *@Author : gsy
     *@Desciption : 根据userid更改用户的权限
     *@param userid
     *@param identity
     *@return : 更改用户的权限
     */
    @GetMapping("/changeidentity/{userid}/{identity}")
    public void changeidentity(@PathVariable("userid")String userid,@PathVariable("identity")String identity){
        int type = 0;
        if(identity.equals("学生"))
            type = 0;
        else if(identity.equals("研究生"))
            type = 1;
        else if(identity.equals("教师"))
            type = 2;
        userService.changeUserInfo(userid,type);
    }

}
