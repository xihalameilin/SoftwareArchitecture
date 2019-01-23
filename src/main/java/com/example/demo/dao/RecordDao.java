package com.example.demo.dao;

import com.example.demo.domains.Record;

import java.util.List;

public interface RecordDao {
    List<Record> getAllRecords(int userID);

    void insertRecord(Record record);
}
