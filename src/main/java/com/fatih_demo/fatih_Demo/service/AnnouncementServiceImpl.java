package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.AnnouncementDto;
import com.fatih_demo.fatih_Demo.entity.Announcement;
import com.fatih_demo.fatih_Demo.repo.AnnouncementRepository;
import org.springframework.stereotype.Service;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.UUID;

import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;



@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository, ModelMapper modelMapper) {
        this.announcementRepository = announcementRepository;
        this.modelMapper = modelMapper;
    }

    public List<AnnouncementDto> save(List<Announcement> announcements, List<MultipartFile> imageFiles) throws IOException {
        List<AnnouncementDto> announcementDtos = new ArrayList<>();

        for (int i = 0; i < announcements.size(); i++) {
            Announcement announcement = announcements.get(i);
            MultipartFile imageFile = (imageFiles != null && i < imageFiles.size()) ? imageFiles.get(i) : null;

            if (imageFile != null && !imageFile.isEmpty()) {
                String imagePath = "uploads/" + UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Files.copy(imageFile.getInputStream(), Paths.get(imagePath), StandardCopyOption.REPLACE_EXISTING);
                announcement.setImagePath(imagePath);
            }

            announcement = announcementRepository.save(announcement);
            AnnouncementDto announcementDto = modelMapper.map(announcement, AnnouncementDto.class);
            announcementDtos.add(announcementDto);
        }

        return announcementDtos;
    }
    @Override
    public AnnouncementDto getAnnouncementById(int id) {
        Announcement announcement = announcementRepository.findById(id).orElse(null);
        return modelMapper.map(announcement, AnnouncementDto.class);
    }

    @Override
    public List<AnnouncementDto> getAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcements.stream()
                .map(announcement -> modelMapper.map(announcement, AnnouncementDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAnnouncement(int id) {
        announcementRepository.deleteById(id);
    }

    @Override
    public AnnouncementDto updateAnnouncement(int id, Announcement updatedAnnouncement, MultipartFile imageFile) throws IOException {
        Announcement announcementToUpdate = announcementRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Announcement with ID " + id + " not found"));

        announcementToUpdate.setTitle(updatedAnnouncement.getTitle());
        announcementToUpdate.setSummary(updatedAnnouncement.getSummary());
        announcementToUpdate.setFullText(updatedAnnouncement.getFullText());
        announcementToUpdate.setAddedBy(updatedAnnouncement.getAddedBy());
        announcementToUpdate.setPublishedDate(updatedAnnouncement.getPublishedDate());
        announcementToUpdate.setImagePath(updatedAnnouncement.getImagePath());

        if (imageFile != null && !imageFile.isEmpty()) {
            String imagePath = "uploads/" + UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            announcementToUpdate.setImagePath(imagePath);
        }

        announcementRepository.save(announcementToUpdate);

        return modelMapper.map(announcementToUpdate, AnnouncementDto.class);
    }
}
