package com.fatih_demo.fatih_Demo.service;
import com.fatih_demo.fatih_Demo.dto.ProjectDto;
import com.fatih_demo.fatih_Demo.entity.Project;
import com.fatih_demo.fatih_Demo.repo.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(Project project, MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            String imagePath = "uploads/" + UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            Files.copy(imageFile.getInputStream(), Paths.get(imagePath), StandardCopyOption.REPLACE_EXISTING);
            project.setImagePath(imagePath);
        }
        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public ProjectDto getProjectById(Integer id) {
        Project project = projectRepository.findById(id).orElse(null);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getAllProject() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(project -> modelMapper.map(project, ProjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDto updateProject(Integer id, Project updatedProject, MultipartFile imageFile) throws IOException {
        Project projectToUpdate = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project with ID " + id + " not found"));

        projectToUpdate.setTitle(updatedProject.getTitle());
        projectToUpdate.setSummary(updatedProject.getSummary());
        projectToUpdate.setDetail(updatedProject.getDetail());
        projectToUpdate.setAddedBy(updatedProject.getAddedBy());
        projectToUpdate.setPublishedDate(updatedProject.getPublishedDate());
        projectToUpdate.setImagePath(updatedProject.getImagePath());
        projectToUpdate.setInfo(updatedProject.getInfo());
        if (imageFile != null && !imageFile.isEmpty()) {
            String imagePath = "uploads/" + UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            Files.copy(imageFile.getInputStream(), Paths.get(imagePath), StandardCopyOption.REPLACE_EXISTING);
            projectToUpdate.setImagePath(imagePath);
        }

        projectRepository.save(projectToUpdate);

        return modelMapper.map(projectToUpdate, ProjectDto.class);
    }
}