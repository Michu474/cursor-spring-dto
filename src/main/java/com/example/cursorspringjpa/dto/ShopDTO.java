package com.example.cursorspringjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {
    private Long id;
    private String shopName;
    private String city;
    private String address;
    private boolean siteExists;
}
