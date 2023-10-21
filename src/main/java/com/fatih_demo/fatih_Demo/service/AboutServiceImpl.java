package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.AboutDto;
import com.fatih_demo.fatih_Demo.entity.About;
import com.fatih_demo.fatih_Demo.repo.AboutRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AboutServiceImpl(AboutRepository aboutRepository, ModelMapper modelMapper) {
        this.aboutRepository = aboutRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AboutDto saveAbout(About about) {
        about = aboutRepository.save(about);
        return modelMapper.map(about, AboutDto.class);
    }

    @Override
    public AboutDto getAboutById(int id) {
        About about = aboutRepository.findById(id).orElse(null);
        return modelMapper.map(about, AboutDto.class);
    }

    @Override
    public List<AboutDto> getAllAbouts() {
        List<About> abouts = aboutRepository.findAll();
        return abouts.stream()
                .map(about -> modelMapper.map(about, AboutDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAbout(int id) {
        aboutRepository.deleteById(id);
    }

    @Override
    public AboutDto updateAbout(Integer id, About about) {
        About aboutToUpdate = aboutRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Dictionary with ID " + id + " not found"));
            aboutToUpdate.setTitle(about.getTitle());
            aboutToUpdate.setFulltext(about.getFulltext());
            aboutToUpdate.setImagePath(about.getImagePath());
            aboutToUpdate.setPublishedDate(about.getPublishedDate());
            aboutToUpdate = aboutRepository.save(aboutToUpdate);
            return modelMapper.map(aboutToUpdate, AboutDto.class);



    }
}
