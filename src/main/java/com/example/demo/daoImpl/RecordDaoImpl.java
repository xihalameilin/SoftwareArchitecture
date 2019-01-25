package com.example.demo.daoImpl;

import com.example.demo.dao.RecordDao;
import com.example.demo.domains.Record;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
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

    @Override
    public int getBookNumAlreadyBorrowed(int userID) {

        Session session = HibernateUtils.getSession();
        Query query = session.createQuery("from Record where isborrowed = 1");
        List<Record> records = query.getResultList();
        HibernateUtils.closeSession(session);
        return records.size();
    }

    @Override
    public void returnBook(int userID, int bookID) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE Record r SET r.flag = 0 where r.userID = 1 and r.bookID =1 ");
        query.executeUpdate();
        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
    }

    public static void main(String[] args){
        Record record = new Record();
        record.setTime(new Date());
        record.setUserID(1);
        record.setFlag(1);
        record.setBookname("教育大全");
        record.setCategory("教育");
        record.setBookID(1);

        new RecordDaoImpl().returnBook(1,1);
    }
}
