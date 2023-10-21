package com.fatih_demo.fatih_Demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "announcement")
@Data
@NoArgsConstructor
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(length=2000,
            name = "summary")
    private String summary;

    @Column(length = 2000,
            name="full_text")
    private String fullText;

    @Column(name = "created_date")
    private LocalDate createdDate= LocalDate.now();

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "added_by")
    private String addedBy;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_path")
    private String imagePath;


    }




