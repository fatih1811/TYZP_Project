package com.fatih_demo.fatih_Demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_information")
@Data
@NoArgsConstructor
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name ="first_name")
    private String firstname;
    @Column(name ="last_name")
    private String lastname;
    @Column(name = "created_date")
    private LocalDate createdDate=LocalDate.now();



}
