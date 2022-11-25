package com.example.cursorspringjpa.repository;

import com.example.cursorspringjpa.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShopRepository extends JpaRepository<Shop,Long> {
    public Shop findShopById(Long id);
}
