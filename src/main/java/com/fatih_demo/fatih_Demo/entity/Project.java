package com.fatih_demo.fatih_Demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "info")
    private String info;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;

    @Column(name = "added_by")
    private String addedBy;

    @Column(name = "summary")
    private String summary;

    @Column(name = "title")
    private String title;

    @Column(name = "image_path")
    private String imagePath;

    @Lob
    @Column(name = "image")
    private byte[] image;

}
