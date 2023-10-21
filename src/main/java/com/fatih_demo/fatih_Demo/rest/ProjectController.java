package com.fatih_demo.fatih_Demo.rest;
import com.fatih_demo.fatih_Demo.dto.ProjectDto;
import com.fatih_demo.fatih_Demo.entity.Project;
import com.fatih_demo.fatih_Demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ProjectDto createProject(@RequestBody Project project, @RequestParam(name = "imageFile", required = false) MultipartFile imageFile) throws IOException {
        return projectService.save(project, imageFile);
    }

    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable Integer id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/get/all")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProject();
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable Integer id, @RequestBody Project project, @RequestParam(name = "imageFile", required = false) MultipartFile imageFile) throws IOException {
        return projectService.updateProject(id, project, imageFile);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
    }
}
