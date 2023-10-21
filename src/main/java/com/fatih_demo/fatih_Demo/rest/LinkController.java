package com.fatih_demo.fatih_Demo.rest;
import com.fatih_demo.fatih_Demo.dto.LinkDto;
import com.fatih_demo.fatih_Demo.entity.Link;
import com.fatih_demo.fatih_Demo.service.LinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/add")
    public LinkDto createLink(@RequestBody Link link) {
        return linkService.save(link);
    }

    @GetMapping("/{id}")
    public LinkDto getLinkById(@PathVariable Integer id) {
        return linkService.getLink(id);
    }

    @GetMapping("/all")
    public List<LinkDto> getAllLinks() {
        return linkService.getAllLinks();
    }

    @PutMapping("/{id}")
    public LinkDto updateLink(@PathVariable Integer id, @RequestBody Link link) {
        return linkService.updateLink(id, link);
    }

    @DeleteMapping("/{id}")
    public void deleteLink(@PathVariable Integer id) {
        linkService.deleteLink(id);
    }
}
