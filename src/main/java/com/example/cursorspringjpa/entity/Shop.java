package com.example.cursorspringjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String shopName;
    private String city;
    private String address;
    private int stuffNumber;
    private boolean siteExists;
}
