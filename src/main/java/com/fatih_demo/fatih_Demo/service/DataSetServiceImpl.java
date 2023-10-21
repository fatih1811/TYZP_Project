package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.DataSetDto;
import com.fatih_demo.fatih_Demo.entity.DataSet;
import com.fatih_demo.fatih_Demo.repo.DataSetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DataSetServiceImpl implements DataSetService{
    private final DataSetRepository dataSetRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DataSetServiceImpl(DataSetRepository dataSetRepository, ModelMapper modelMapper) {
        this.dataSetRepository = dataSetRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataSetDto save(DataSet dataSet) {
        dataSet = dataSetRepository.save(dataSet);
        return modelMapper.map(dataSet, DataSetDto.class);
    }

    @Override
    public DataSetDto getDataSet(Integer id) {
        DataSet dataSet = dataSetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DataSet not found with id: " + id));
        return modelMapper.map(dataSet, DataSetDto.class);
    }

    @Override
    public List<DataSetDto> getAllDataSet() {
        List<DataSet> dataSetList = dataSetRepository.findAll();
        return dataSetList.stream()
                .map(dataSet -> modelMapper.map(dataSet, DataSetDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDataSet(Integer id) {
        dataSetRepository.deleteById(id);
    }
    @Override
    public DataSetDto updateDataSet(Integer id, DataSet dataSet) {
        DataSet dataSetToUpdate = dataSetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DataSet not found with id: " + id));

        dataSetToUpdate.setDescription(dataSet.getDescription());
        dataSetToUpdate.setTopic(dataSet.getTopic());
        dataSetToUpdate.setTitle(dataSet.getTitle());
        dataSetToUpdate.setPublishedDate(dataSet.getPublishedDate());

        DataSet updatedDataSet = dataSetRepository.save(dataSetToUpdate);
        return modelMapper.map(updatedDataSet, DataSetDto.class);
    }
}
