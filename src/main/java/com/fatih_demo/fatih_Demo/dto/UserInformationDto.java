package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInformationDto {
    private String email;
    private  String firstName;
    private String lastname;
}
