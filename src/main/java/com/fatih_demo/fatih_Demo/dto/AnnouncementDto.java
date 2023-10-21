package com.fatih_demo.fatih_Demo.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class AnnouncementDto {



    private String title;
    private String summary;
    private String fullText;
    private String addedBy;
    private String imagePath;
    private String publishedDate;



}
