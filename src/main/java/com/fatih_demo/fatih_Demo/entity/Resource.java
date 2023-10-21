package com.fatih_demo.fatih_Demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name ="resource")
@Data
@NoArgsConstructor
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @Column(name="published_date")
    private LocalDate publishedDate;
    @Column(name="created_date")
    private LocalDate createdDate= LocalDate.now();

}
