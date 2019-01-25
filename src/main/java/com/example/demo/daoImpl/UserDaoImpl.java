package com.example.demo.daoImpl;

import com.example.demo.dao.UserDao;
import com.example.demo.domains.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    @Override
    public void changeIdentity(int userID, int type) {
        String identity = "";
        if (type == 0)
            identity = "学生";
        else if (type == 1)
            identity = "研究生";
        else if (type == 2)
            identity = "教师";
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE User u set u.identity = "+ identity +" where u.id = "+userID);
        query.executeUpdate();
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);

    }

    public static void main(String[] args){

//        User user = new Student();
//        user.setName("lml");
//        user.setPassword("123");
        new UserDaoImpl().getAllUsers();
    }


}
