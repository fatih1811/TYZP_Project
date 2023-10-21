package com.fatih_demo.fatih_Demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DictionaryDto {



    private String turkishWord;

    private String englishWord;

    private String description;


}
