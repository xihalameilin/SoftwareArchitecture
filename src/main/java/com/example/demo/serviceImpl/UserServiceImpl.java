package com.example.demo.serviceImpl;

import com.example.demo.dao.MessageDao;
import com.example.demo.dao.UserDao;
import com.example.demo.daoImpl.MessageDaoImpl;
import com.example.demo.daoImpl.UserDaoImpl;
import com.example.demo.domains.Message;
import com.example.demo.domains.User;
import com.example.demo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private MessageDao messageDao = new MessageDaoImpl();
    @Override
    public String login(String username, String password) {
        List<User> users = userDao.getAllUsers();
        for(User user:users){
            if(username.equals(user.getName())){
                if(password == user.getPassword()){
                    return user.toString();
                }
                else{
                    return "密码错误";
                }
            }
        }
        return "此用户不存在";
    }

    @Override
    public void changeUserInfo(int userID,int type) {
        userDao.changeIdentity(userID,type);
        new UserServiceImpl().notifyAdmin("ID为"+userID+"的用户更新了信息");
    }

    @Override
    public void notifyAdmin(String info) {
        Message message = new Message();
        message.setContent(info);
        messageDao.insertMessage(message);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public List<Message> getAllMessage() {
        return null;
    }
}
