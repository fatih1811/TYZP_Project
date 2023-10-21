package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.ResourceDto;
import com.fatih_demo.fatih_Demo.entity.Resource;
import com.fatih_demo.fatih_Demo.repo.ResourceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository, ModelMapper modelMapper) {
        this.resourceRepository = resourceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResourceDto save(Resource resource) {
        // Kaynak kaydetme işlemini burada gerçekleştirin
        Resource savedResource = resourceRepository.save(resource);
        return modelMapper.map(savedResource, ResourceDto.class);
    }

    @Override
    public ResourceDto getResource(Integer id) {
        Resource resource = resourceRepository.findById(id).orElse(null);
        return modelMapper.map(resource, ResourceDto.class);
    }

    @Override
    public List<ResourceDto> getAllResource() {
        List<Resource> resources = resourceRepository.findAll();
        return resources.stream()
                .map(resource -> modelMapper.map(resource, ResourceDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteService(Integer id) {
        resourceRepository.deleteById(id);
    }

    @Override
    public ResourceDto updateResource(Integer id, Resource resource) {
        Resource resourceToUpdate = resourceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Resource with ID " + id + " not found"));


        resourceToUpdate.setName(resource.getName());
        resourceToUpdate.setDescription(resource.getDescription());
        resourceToUpdate.setPublishedDate(resource.getPublishedDate());


        resourceRepository.save(resourceToUpdate);

        return modelMapper.map(resourceToUpdate, ResourceDto.class);
    }
}

