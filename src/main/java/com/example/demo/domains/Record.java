package com.example.demo.domains;

import javax.persistence.*;


//这里采用冗余的设计方便查询

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userID;


    private Integer BookID;


    private String bookname;

    private String category;


}
