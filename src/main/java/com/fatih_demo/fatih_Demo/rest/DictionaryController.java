package com.fatih_demo.fatih_Demo.rest;

import com.fatih_demo.fatih_Demo.dto.DictionaryDto;
import com.fatih_demo.fatih_Demo.entity.Dictionary;
import com.fatih_demo.fatih_Demo.service.DictionaryService;
import org.aspectj.asm.IModelFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictionaries")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/get/all")
    public List<DictionaryDto> getAllDictionaries() {
        return dictionaryService.getAllDictionary();
    }

    @GetMapping("/{id}")
    public DictionaryDto getDictionaryById(@PathVariable Integer id) {
        return dictionaryService.getDictionary(id);
    }

    @PostMapping("/add")
    public DictionaryDto createDictionary(@RequestBody Dictionary dictionary) {

        return dictionaryService.save(dictionary);
    }

    @PutMapping("/{id}")
    public DictionaryDto updateDictionary(@PathVariable Integer id, @RequestBody Dictionary dictionary) {
        return dictionaryService.updateDictionary(id, dictionary);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dictionaryService.deleteDictionary(id);
    }
}

