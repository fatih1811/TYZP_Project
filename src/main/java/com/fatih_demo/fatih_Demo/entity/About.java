package com.fatih_demo.fatih_Demo.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name= "about")
@Data
@NoArgsConstructor
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name = "fulltext", columnDefinition = "TEXT")
    private String fulltext;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "image_path")
    private String imagePath;

}
