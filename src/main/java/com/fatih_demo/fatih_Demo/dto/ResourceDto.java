package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class ResourceDto {
    private String name;
    private String description;
    private LocalDate publishedDate;
}
