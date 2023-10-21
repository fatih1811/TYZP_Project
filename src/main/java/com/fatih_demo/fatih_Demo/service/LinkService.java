package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.LinkDto;
import com.fatih_demo.fatih_Demo.entity.Link;

import java.util.List;

public interface LinkService {

    LinkDto save(Link link);
    LinkDto getLink(Integer id);
    List<LinkDto> getAllLinks();
    void deleteLink(Integer id);
    LinkDto updateLink(Integer id, Link link);
}
