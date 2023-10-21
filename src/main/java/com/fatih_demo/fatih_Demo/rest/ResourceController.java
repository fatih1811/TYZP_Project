package com.fatih_demo.fatih_Demo.rest;

import com.fatih_demo.fatih_Demo.dto.ResourceDto;
import com.fatih_demo.fatih_Demo.entity.Resource;
import com.fatih_demo.fatih_Demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping("/add")
    public ResourceDto createResource(@RequestBody Resource resource) {
        return resourceService.save(resource);
    }

    @GetMapping("/{id}")
    public ResourceDto getResourceById(@PathVariable Integer id) {
        return resourceService.getResource(id);
    }

    @GetMapping("/all")
    public List<ResourceDto> getAllResources() {
        return resourceService.getAllResource();
    }

    @PutMapping("/{id}")
    public ResourceDto updateResource(@PathVariable Integer id, @RequestBody Resource resource) {
        return resourceService.updateResource(id, resource);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Integer id) {
        resourceService.deleteService(id);
    }
}

