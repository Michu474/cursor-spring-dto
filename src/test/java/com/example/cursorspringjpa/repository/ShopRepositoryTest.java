package com.example.cursorspringjpa.repository;

import com.example.cursorspringjpa.entity.Shop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource("classpath:testDB.properties")
@AutoConfigureTestEntityManager
class ShopRepositoryTest {
    @Autowired
    ShopRepository shopRepository;

    Shop shop1;
    Shop shop2;
    List<Shop> shops = new ArrayList<>();

    @BeforeEach
    void setUp() {
        shop1 = new Shop(40L, "Rozetka", "Lviv", "North", 20, true);
        shop2 = new Shop(41L, "Allo", "Kyiv", "North", 30, false);
        shops.add(shop1);
        shops.add(shop2);
        shopRepository.save(shop1);
        shopRepository.save(shop2);
    }

    @AfterEach
    void tearDown() {
        shop1 = shop2 = null;
        shops = null;

    }


    @Test
    public void givenShopToAddShouldReturnAddedProduct() {
        Shop fetchedShop = shopRepository.findById(shop1.getId()).get();
        assertEquals(40L, fetchedShop.getId());
    }

    @Test
    void findShopByGivenId() {
        System.out.println(shop1.toString());
        Shop testShop1 = shopRepository.findShopById(40L).orElseThrow();
        assertEquals(shop1, testShop1);
    }

    @Test
    void findAllShops() {
        List<Shop> shopList = shopRepository.findAll();
        assertEquals(shopList, shops);
    }

    @Test
    void deleteGivenShop() throws Exception {
        Shop newShop = shopRepository.save(new Shop());
        Long ShopId = newShop.getId();
        System.out.println(shopRepository.existsById(ShopId));
        shopRepository.deleteById(ShopId);
        if (shopRepository.existsById(ShopId)) {
            throw new Exception();
        }
    }

}