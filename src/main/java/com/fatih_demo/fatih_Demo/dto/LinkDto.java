package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LinkDto {
    private String title;
    private String imagePath;
    private LocalDate publishedDate;
    private String links;


}
