package com.example.cursorspringjpa.service;

import com.example.cursorspringjpa.entity.Shop;
import com.example.cursorspringjpa.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;


    public Shop createShop(Shop shop){

        shopRepository.save(shop);

        return shop;
    }

    public List<Shop> findAll(){
        return shopRepository.findAll();
    }

    public Shop findById(Long id){
        return shopRepository.findShopById(id);
    }

}
