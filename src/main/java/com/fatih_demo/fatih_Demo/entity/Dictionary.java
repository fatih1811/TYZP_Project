package com.fatih_demo.fatih_Demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name ="dictionary")
@Data
@NoArgsConstructor
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "turkish_word")
    private String turkishWord;

    @Column(name = "english_word")
    private String englishWord;

    @Column(length = 2000,
            name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "published_date")
    private LocalDate publishedDate;

}
