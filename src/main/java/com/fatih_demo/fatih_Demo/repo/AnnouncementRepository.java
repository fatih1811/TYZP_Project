package com.fatih_demo.fatih_Demo.repo;

import com.fatih_demo.fatih_Demo.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {



}