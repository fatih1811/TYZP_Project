package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class DataSetDto {
    private String description;
    private String topic;
    private String title;
    private LocalDate publishedDate;


}
