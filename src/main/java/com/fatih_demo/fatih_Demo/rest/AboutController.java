package com.fatih_demo.fatih_Demo.rest;

import com.fatih_demo.fatih_Demo.dto.AboutDto;
import com.fatih_demo.fatih_Demo.entity.About;
import com.fatih_demo.fatih_Demo.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
public class AboutController {

    private final AboutService aboutService;

    @Autowired
    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @PostMapping("/add")
    public AboutDto saveAbout(@RequestBody About about) {
        return aboutService.saveAbout(about);
    }

    @GetMapping("/{id}")
    public AboutDto getAboutById(@PathVariable int id) {
        return aboutService.getAboutById(id);
    }

    @GetMapping("/all")
    public List<AboutDto> getAllAbouts() {
        return aboutService.getAllAbouts();
    }

    @PutMapping("/{id}")
    public AboutDto updateAbout(@PathVariable int id, @RequestBody About about) {
        return aboutService.updateAbout(id, about);
    }

    @DeleteMapping("/{id}")
    public void deleteAbout(@PathVariable int id) {
        aboutService.deleteAbout(id);
    }
}

