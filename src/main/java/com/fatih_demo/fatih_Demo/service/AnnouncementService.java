package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.AnnouncementDto;
import com.fatih_demo.fatih_Demo.entity.Announcement;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface AnnouncementService {




        List<AnnouncementDto> save(List<Announcement> announcements, List<MultipartFile> imageFiles) throws IOException;



        AnnouncementDto getAnnouncementById(int id);

        List<AnnouncementDto> getAllAnnouncements();

        void deleteAnnouncement(int id);

        AnnouncementDto updateAnnouncement(int id, Announcement updatedAnnouncement, MultipartFile imageFile) throws IOException;
    }





