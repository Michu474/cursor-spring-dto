package com.example.cursorspringjpa.web;

import com.example.cursorspringjpa.entity.Shop;
import com.example.cursorspringjpa.service.Impl.ShopServiceDTOImpl;
import com.example.cursorspringjpa.service.Impl.ShopServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class ShopControllerTest {

    @MockBean
    ShopServiceImpl shopService;

    @MockBean
    ShopServiceDTOImpl serviceDTO;

    @InjectMocks
    ShopController shopController;
    Shop shop1;
    Shop shop2;
    List<Shop> shops = new ArrayList<>();



    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        shop1 = new Shop(1L, "Rozetka", "Lviv", "North", 20, true);
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
    void findAll() throws Exception {
        when(shopService.findAll()).thenReturn(shops);
        mockMvc.perform(get("/shops/findAll")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(shops)))
                .andExpect(status().is2xxSuccessful()).andDo(print());
    }

    @Test
    void findShopById() throws Exception {
        when(shopService.findById(shop1.getId())).thenReturn(shop1);
        mockMvc.perform(get("/shops/findShop/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(shop1))).andExpect(status().is2xxSuccessful()).andDo(print());
        verify(shopService,times(1)).findById(shop1.getId());
    }

    @Test
    void PostMappingOfProduct() throws Exception {
        when(shopService.createShop(any())).thenReturn(shop1);
        mockMvc.perform(post("/shops/createShop")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(shop1))).andExpect(status().is2xxSuccessful());
        verify(shopService, times(1)).createShop(any());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}