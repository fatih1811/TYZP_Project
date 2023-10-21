package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDto {
    private String title;
    private String address;
    private String tel;
    private String fax;
    private String email;
    private String imageUrl;
}
