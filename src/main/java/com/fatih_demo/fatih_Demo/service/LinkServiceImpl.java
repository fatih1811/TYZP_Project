package com.fatih_demo.fatih_Demo.service;
import com.fatih_demo.fatih_Demo.dto.LinkDto;
import com.fatih_demo.fatih_Demo.entity.Link;
import com.fatih_demo.fatih_Demo.map.LinkMapper;
import com.fatih_demo.fatih_Demo.repo.LinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository, ModelMapper modelMapper) {
        this.linkRepository = linkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LinkDto save(Link link) {
        link = linkRepository.save(link);
        return LinkMapper.MAPPER.mapToLinkDto(link);
    }

    @Override
    public LinkDto getLink(Integer id) {
        Link link = linkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Link not found with id: " + id));
        return modelMapper.map(link, LinkDto.class);
    }

    @Override
    public List<LinkDto> getAllLinks() {
        List<Link> links = linkRepository.findAll();
        return links.stream()
                .map(link -> modelMapper.map(link, LinkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLink(Integer id) {
        linkRepository.deleteById(id);
    }

    @Override
    public LinkDto updateLink(Integer id, Link link) {
        Link linkToUpdate = linkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Link not found with id: " + id));

        linkToUpdate.setTitle(link.getTitle());
        linkToUpdate.setImagePath(link.getImagePath());
        linkToUpdate.setPublishedDate(link.getPublishedDate());
        linkToUpdate.setLinks(link.getLinks());

        Link updatedLink = linkRepository.save(linkToUpdate);
        LinkDto updatedLinkDto = LinkMapper.MAPPER.mapToLinkDto(updatedLink);
        return updatedLinkDto;
    }
}
