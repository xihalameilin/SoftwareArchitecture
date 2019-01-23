package com.example.demo.daoImpl;

import com.example.demo.dao.UserDao;
import com.example.demo.domains.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import java.util.List;


public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(User user) {
        Session session = HibernateUtils.getSession();
        session.save(user);
        HibernateUtils.closeSession(session);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateUtils.getSession();
        String hql =" select * from users ";
        SQLQuery<User> query=session.createSQLQuery(hql).addEntity(User.class);
        List<User> list = query.list();
        HibernateUtils.closeSession(session);
        for(User user:list){
            System.out.println(user.getName());
            System.out.println(user.getIdentity());
        }
        return list;
    }

    public static void main(String[] args){

//        User user = new Student();
//        user.setName("lml");
//        user.setPassword("123");
        new UserDaoImpl().getAllUsers();
    }


}
