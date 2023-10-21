package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.DataSetDto;
import com.fatih_demo.fatih_Demo.entity.DataSet;


import java.util.List;


public interface DataSetService {
    DataSetDto save(DataSet dataSet);

    DataSetDto getDataSet(Integer id);

    List<DataSetDto> getAllDataSet();

    void deleteDataSet(Integer id);

    DataSetDto updateDataSet(Integer id, DataSet dataSet);
}
