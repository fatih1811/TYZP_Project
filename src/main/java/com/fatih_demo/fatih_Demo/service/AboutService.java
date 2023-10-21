package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.AboutDto;
import com.fatih_demo.fatih_Demo.entity.About;

import java.util.List;

import java.util.List;

public interface AboutService {

    AboutDto saveAbout(About about);

    AboutDto getAboutById(int id);

    List<AboutDto> getAllAbouts();

    void deleteAbout(int id);

    AboutDto updateAbout(Integer id, About about);
}

