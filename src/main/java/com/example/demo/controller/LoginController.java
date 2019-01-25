//package com.example.demo.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/LoginController")
//public class LoginController {
//
//    /**
//     *@Author : gsy
//     *@Desciption : 根据用户名和密码登录
//     * @param userid
//     * @param passwd
//     *@return : 身份 / 密码错误
//     */
//    @GetMapping("/login/{userid}/{passwd}")
//    public String login(@PathVariable("userid")String userid,@PathVariable("passwd")String passwd){
//        //调用userService方法
//        //返回登陆人的身份
//        return "普通学生";
//    }
//
//    /**
//     *@Author : gsy
//     *@Desciption : 注册
//     * @param username
//     * @param userid
//     * @param passwd
//     * @param identity
//     * @param briefcase
//     * @param school
//     */
//    @GetMapping("/register/{username}/{userid}/{passwd}/{identity}/{briefcase}/{school}")
//    public void register(@PathVariable("username")String username, @PathVariable("userid")String userid,
//                         @PathVariable("passwd")String passwd, @PathVariable("identity")String identity,
//                         @PathVariable("briefcase")String briefcase, @PathVariable("school")String school){
//        //调用userService方法
//        //返回登陆人的身份
//    }
//
//    /**
//     *@Author : gsy
//     *@Desciption : 检查用户名是否被注册
//     * @param userid
//     */
//    @GetMapping("/check/{userid}")
//    public boolean check(@PathVariable("userid")String userid){
//        return true;
//    }
//
//}
