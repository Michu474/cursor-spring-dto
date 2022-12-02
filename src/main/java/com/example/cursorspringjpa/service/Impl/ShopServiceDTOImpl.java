package com.example.cursorspringjpa.service.Impl;

import com.example.cursorspringjpa.dto.ShopDTO;
import com.example.cursorspringjpa.entity.Shop;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShopServiceDTOImpl {

    public Shop parseJsonToShop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String shopString = reader.lines().collect(Collectors.joining());
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = objectMapper.readValue(shopString, Shop.class);
        return shop;
    }

    public List<ShopDTO> parseShopsToDTO(List<Shop> shops) {
        return shops.stream()
                .map(it -> parseShopToDTO(it))
                .collect(Collectors.toList());
    }

    public ShopDTO parseShopToDTO(Shop shop) {
        return new ShopDTO(shop.getId(), shop.getShopName(), shop.getCity(),
                shop.getAddress(), shop.isSiteExists());
    }

}
