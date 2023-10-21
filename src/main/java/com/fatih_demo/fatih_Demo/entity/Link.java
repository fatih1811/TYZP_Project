package com.fatih_demo.fatih_Demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "link")
@Data
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "links")
    private String links;

}
