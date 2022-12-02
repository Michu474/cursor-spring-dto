package com.example.cursorspringjpa.service;

import com.example.cursorspringjpa.entity.Shop;

import java.util.List;

public interface ShopService {

    Shop createShop(Shop shop);
    List<Shop> findAll();
    Shop findById(Long id);
}
