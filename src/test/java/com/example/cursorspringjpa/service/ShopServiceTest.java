package com.example.cursorspringjpa.service;

import com.example.cursorspringjpa.entity.Shop;
import com.example.cursorspringjpa.repository.ShopRepository;
import com.example.cursorspringjpa.service.Impl.ShopServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    @Mock
    ShopRepository shopRepository;

    @Autowired
    @InjectMocks
    ShopServiceImpl shopService;

    Shop shop1;
    Shop shop2;
    List<Shop> shops = new ArrayList<>();

    @BeforeEach
    void setUp() {
        shop1 = new Shop(1L, "Rozetka", "Kyiv", "North", 20, true);
        shop2 = new Shop(2L, "Allo", "Kyiv", "North", 30, false);
        shops.add(shop1);
        shops.add(shop2);
    }

    @AfterEach
    void tearDown() {
        shop1 = shop2 = null;
        shops = null;

    }

    @Test
    void givenShopToCreateShouldReturnCreatedShop() {
        when(shopRepository.save(any())).thenReturn(shop1);
        shopService.createShop(shop1);
        verify(shopRepository, times(1)).save(any());
    }

    @Test
    void findAllShops() {
        shopRepository.save(shop1);
        when(shopRepository.findAll()).thenReturn(shops);
        List<Shop> shopList = shopRepository.findAll();
        assertEquals(shopList, shops);
        verify(shopRepository, times(1)).findAll();
        verify(shopRepository, times(1)).save(shop1);
    }

    @Test
    void findShopByGivenId() {
        when(shopRepository.findShopById(1L)).thenReturn(Optional.ofNullable(shop1));
        Shop shop = shopRepository.findShopById(1L).orElseThrow();
        assertEquals(shop, shop1);
        verify(shopRepository, times(1)).findShopById(1L);
    }
}