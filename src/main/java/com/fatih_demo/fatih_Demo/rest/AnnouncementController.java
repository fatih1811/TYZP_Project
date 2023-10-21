package com.fatih_demo.fatih_Demo.rest;

import com.fatih_demo.fatih_Demo.dto.AnnouncementDto;
import com.fatih_demo.fatih_Demo.entity.Announcement;
import com.fatih_demo.fatih_Demo.service.AnnouncementService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;




@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }
    @PostMapping("/add")
    public List<AnnouncementDto> createAnnouncements(@RequestBody List<Announcement> announcements,
                                                     @RequestParam(value = "imageFiles", required = false) List<MultipartFile> imageFiles) throws IOException {
        return announcementService.save(announcements, imageFiles);
    }

    @GetMapping("/{id}")
    public AnnouncementDto getAnnouncementById(@PathVariable int id) {
        return announcementService.getAnnouncementById(id);
    }

    @GetMapping("/all")
    public List<AnnouncementDto> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    @PutMapping("/{id}/update")
    public AnnouncementDto updateAnnouncement(@PathVariable int id,
                                              @RequestBody Announcement updatedAnnouncement,
                                              @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) throws IOException {
        return announcementService.updateAnnouncement(id, updatedAnnouncement, imageFile);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable int id) {
        announcementService.deleteAnnouncement(id);
    }
}


