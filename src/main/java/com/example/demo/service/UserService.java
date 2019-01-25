package com.example.demo.service;


import com.example.demo.domains.Message;
import com.example.demo.domains.User;
import java.util.List;


public interface UserService {
    /**
    *@Author : LML
    *@Date : 16:56 2019/1/25
    *@Desciption :  登录调用的方法
    *@return :  正确情况返回：  identity 学生 id 1 这样的字符串  错误返回 ： 密码错误  或者  用户不存在
    */
    String login(String username,String password);


    /**
    *@Author : LML
    *@Date : 17:02 2019/1/25
    *@Desciption : 修改身份 type：0->学生  1->研究生  2->教师
    *@return : res
    */
    void changeUserInfo(int userID,int type);



    void notifyAdmin(String info);


    /**
    *@Author : LML
    *@Date : 17:01 2019/1/25
    *@Desciption : 注册
    */
    void insertUser(User user);


    /**
    *@Author : LML
    *@Date : 17:08 2019/1/25
    *@Desciption : 管理员查看自己的信息
    */
    List<Message> getAllMessage();
}