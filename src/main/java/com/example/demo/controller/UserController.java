//package com.example.demo.controller;
//
////
//@RestController
//@RequestMapping("UserController")
//public class UserController {
//    /**
//     *@Author : gsy
//     *@Desciption : 得到个人信息
//     *@return : 个人信息
//     */
//    @GetMapping("/getpersonal/{userid}")
//    public String getpersonal(@PathVariable("userid")String userid){
//        return "";
//    }
//
//    /**
//     *@Author : gsy
//     *@Desciption : 根据userid保存编辑自己的个人信息
//     *@param userid
//     *@param username
//     *@param briefcase
//     *@param school
//     */
//    @GetMapping("/editpersonal/{userid}/{username}/{briefcase}/{school}")
//    public void editpersonal(@PathVariable("userid")String userid,@PathVariable("username")String username,
//                             @PathVariable("briefcase")String briefcase,@PathVariable("school")String school){
//    }
//
//    /**
//     *@Author : gsy
//     *@Desciption : 根据identity得到自己可以借的书籍
//     *@param identity
//     *@return : 个人可以借的书籍的JSONArray
//     */
//    @GetMapping("/availablebook/{identity}")
//    public JSONArray availablebook(@PathVariable("identity") String identity){
//        return null;
//    }
//
//    /**
//     *@Author : gsy
//     *@Desciption : 借书
//     *@param userid
//     *@param identity
//     *@param bookid
//     *@param bookname
//     *@param category
//     */
//    @GetMapping("/borrowbook/{userid}/{identity}/{bookid}/{bookname}/{category}")
//    public void borrowbook(@PathVariable("userid")String userid,@PathVariable("identity") String identity,
//                           @PathVariable("bookid")String bookid, @PathVariable("bookname")String bookname,
//                           @PathVariable("category")String category){
//    }
//}
