package com.fatih_demo.fatih_Demo.service;


import com.fatih_demo.fatih_Demo.dto.DictionaryDto;
import com.fatih_demo.fatih_Demo.entity.Dictionary;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DictionaryService {


        DictionaryDto save(Dictionary dictionary);

        DictionaryDto getDictionary(Integer id);

        List<DictionaryDto> getAllDictionary();

        void deleteDictionary(Integer id);

        DictionaryDto updateDictionary(Integer id, Dictionary dictionary);
    }

