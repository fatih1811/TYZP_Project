package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.ResourceDto;
import com.fatih_demo.fatih_Demo.entity.Resource;

import java.util.List;

public interface ResourceService {

    ResourceDto save(Resource resource);

    ResourceDto getResource(Integer id);

    List<ResourceDto> getAllResource();

    void deleteService(Integer id);

    ResourceDto updateResource(Integer id, Resource resource);
}
