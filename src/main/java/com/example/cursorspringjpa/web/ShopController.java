package com.example.cursorspringjpa.web;

import com.example.cursorspringjpa.dto.ShopDTO;
import com.example.cursorspringjpa.service.ShopServiceDTO;
import com.example.cursorspringjpa.entity.Shop;
import com.example.cursorspringjpa.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/shops")
public class ShopController {
    @Autowired
    ShopService shopService;

    @Autowired
    ShopServiceDTO shopServiceDTO;

    @GetMapping(value = "/findAll")
    public List<ShopDTO> findAll(){

        return shopServiceDTO.parseShopsToDTO(shopService.findAll());

    }

    @GetMapping(value = "/findShop/{id}")
    public ShopDTO findShopById(@PathVariable Long id){
        return shopServiceDTO.parseShopToDTO(shopService.findById(id));
    }

    @PostMapping(value = "/createShop")
    public Shop createShop(HttpServletRequest request,HttpServletResponse response) throws IOException {

        Shop shop = shopServiceDTO.parseJsonToShop(request,response);

        return shopService.createShop(shop);
    }
}
