package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.entity.Dictionary;
import com.fatih_demo.fatih_Demo.repo.DictionaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


import com.fatih_demo.fatih_Demo.dto.DictionaryDto;







@Service
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DictionaryServiceImpl(DictionaryRepository dictionaryRepository, ModelMapper modelMapper) {
        this.dictionaryRepository = dictionaryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DictionaryDto save(Dictionary dictionary) {

        dictionary = dictionaryRepository.save(dictionary);
        return modelMapper.map(dictionary, DictionaryDto.class);
    }


    @Override
    public DictionaryDto getDictionary(Integer id) {
        Dictionary dictionary = dictionaryRepository.findById(id).orElse(null);
        return modelMapper.map(dictionary, DictionaryDto.class);
    }

    @Override
    public List<DictionaryDto> getAllDictionary() {
        List<Dictionary> dictionaries = dictionaryRepository.findAll();
        return dictionaries.stream()
                .map(dictionary -> modelMapper.map(dictionary, DictionaryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDictionary(Integer id) {
        dictionaryRepository.deleteById(id);
    }

    @Override
    public DictionaryDto updateDictionary(Integer id, Dictionary dictionary) {
        Dictionary dictionaryToUpdate = dictionaryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Dictionary with ID " + id + " not found"));

        dictionaryToUpdate.setTurkishWord(dictionary.getTurkishWord());
        dictionaryToUpdate.setEnglishWord(dictionary.getEnglishWord());
        dictionaryToUpdate.setDescription(dictionary.getDescription());
        dictionaryToUpdate.setCreatedDate(dictionary.getCreatedDate());
        dictionaryToUpdate.setPublishedDate(dictionary.getPublishedDate());
        dictionaryRepository.save(dictionaryToUpdate);

        return modelMapper.map(dictionaryToUpdate, DictionaryDto.class);
    }
}




