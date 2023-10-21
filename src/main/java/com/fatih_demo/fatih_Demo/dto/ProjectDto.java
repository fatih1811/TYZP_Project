package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProjectDto {

    private LocalDate publishedDate;
    private String detail;
    private String summary;
    private String title;
    private String imagePath;

}
