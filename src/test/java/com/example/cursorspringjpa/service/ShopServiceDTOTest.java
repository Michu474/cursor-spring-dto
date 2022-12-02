package com.example.cursorspringjpa.service;

import com.example.cursorspringjpa.dto.ShopDTO;
import com.example.cursorspringjpa.entity.Shop;
import com.example.cursorspringjpa.service.Impl.ShopServiceDTOImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ShopServiceDTOTest {



    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    Shop shop1;
    Shop shop2;
    List<Shop> shops = new ArrayList<>();
    List<Shop> shopList = new ArrayList<>();

    @Mock
    BufferedReader bufferedReader;
    @Mock
    ObjectMapper objectMapper;
    @InjectMocks
    ShopServiceDTOImpl serviceDTO;

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
    void parseJsonToShop() throws IOException {
        httpServletRequest.setContentType("application/json");
        httpServletRequest.setContent(asJsonString(shop1).getBytes("UTF-8"));
        Shop shop = serviceDTO.parseJsonToShop(httpServletRequest,httpServletResponse);
        assertNotNull(shop);
        assertEquals(shop,shop1);
    }

    @Test
    void parseShopsToDTO() {
        shopList.add(new Shop());
        List<ShopDTO> shopsDTO = serviceDTO.parseShopsToDTO(shopList);
        assertNotNull(shopsDTO);
        assertNotSame(shopsDTO, shopList);
    }

    @Test
    void parseShopToDTO() {
        Shop shop = new Shop();
        ShopDTO shopDTO = serviceDTO.parseShopToDTO(shop);
        assertNotSame(shop, shopDTO);

    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}