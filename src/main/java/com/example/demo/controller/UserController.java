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

import java.util.Date;

@RestController
@RequestMapping("UserController")
public class UserController {

    private BookService bookService = new BookServiceImpl();

    private UserService userService = new UserServiceImpl();
    /**
     *@Author : gsy
     *@Desciption : 得到个人信息
     *@return : 个人信息
     */
    @GetMapping("/getpersonal/{userid}")
    public String getpersonal(@PathVariable("userid")String userid){

        return userService.getUserByUserID(userid).toString();
    }

    /**
     *@Author : gsy
     *@Desciption : 根据userid保存编辑自己的个人信息
     *@param userid
     *@param username
     *@param briefcase
     *@param school
     */
    @GetMapping("/editpersonal/{userid}/{username}/{briefcase}/{school}")
    public void editpersonal(@PathVariable("userid")String userid,@PathVariable("username")String username,
                             @PathVariable("briefcase")String briefcase,@PathVariable("school")String school){

    }

    /**
     *@Author : gsy
     *@Desciption : 根据identity得到自己可以借的书籍
     *@param identity
     *@return : 个人可以借的书籍的JSONArray
     */
    @GetMapping("/availablebook/{identity}")
    public JSONArray availablebook(@PathVariable("identity") String identity){
        return new JSONArray(bookService.getAllBook(identity).toString());
    }

    /**
     *@Author : gsy
     *@Desciption : 借书
     *@param userid
     *@param identity
     *@param bookid
     *@param bookname
     *@param category
     */
    @GetMapping("/borrowbook/{userid}/{identity}/{bookid}/{bookname}/{category}")
    public void borrowbook(@PathVariable("userid")String userid,@PathVariable("identity") String identity,
                           @PathVariable("bookid")int bookid, @PathVariable("bookname")String bookname,
                           @PathVariable("category")String category){
        Book book = new Book();
        book.setName(bookname);
        book.setCategory(category);
        book.setId(bookid);
        User user = new Student();
        if(identity.equals("学生"))
            user = new Student();
        else if(identity.equals("教师"))
            user = new Teacher();
        else if(identity.equals("研究生"))
            user = new PostGraduate();
        user.setUserid(userid);
        bookService.borrow(user,book);
    }
}
