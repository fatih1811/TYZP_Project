package com.fatih_demo.fatih_Demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String tel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "image_url")
    private String imageUrl;
}
