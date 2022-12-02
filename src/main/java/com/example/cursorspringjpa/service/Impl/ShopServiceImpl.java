package com.example.cursorspringjpa.service.Impl;

import com.example.cursorspringjpa.entity.Shop;
import com.example.cursorspringjpa.repository.ShopRepository;
import com.example.cursorspringjpa.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;


    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public Shop findById(Long id) {
        Shop shopById = shopRepository.findShopById(id).orElseThrow();
        return shopById;
    }

}
