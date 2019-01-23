package com.example.demo.daoImpl;

import com.example.demo.dao.RecordDao;
import com.example.demo.domains.Record;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
public class RecordDaoImpl implements RecordDao {
    @Override
    public List<Record> getAllRecords(int userID) {
        Session session = HibernateUtils.getSession();
        Query query = session.createQuery("from Record where userid = "+userID);
        List<Record> list = query.getResultList();
        HibernateUtils.closeSession(session);
        return list;
    }

    @Override
    public void insertRecord(Record record) {
        Session session = HibernateUtils.getSession();
        session.save(record);
        HibernateUtils.closeSession(session);
    }

    public static void main(String[] args){

//        User user = new Student();
//        user.setName("lml");
//        user.setPassword("123");
        new UserDaoImpl().getAllUsers();
    }
}
