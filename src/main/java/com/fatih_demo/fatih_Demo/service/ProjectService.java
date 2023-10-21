package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.ProjectDto;
import com.fatih_demo.fatih_Demo.entity.Project;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    ProjectDto save(Project project, MultipartFile imageFile)throws IOException;

    ProjectDto getProjectById(Integer id);

    List<ProjectDto> getAllProject();

    void deleteProject(Integer id);

    ProjectDto updateProject(Integer id,Project project,MultipartFile imageFile)throws IOException;


}
