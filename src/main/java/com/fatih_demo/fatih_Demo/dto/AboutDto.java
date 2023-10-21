package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AboutDto {

    private int id;
    private String title;
    private String fulltext;
    private String imagePath;
}
