package com.fatih_demo.fatih_Demo.rest;

import com.fatih_demo.fatih_Demo.dto.DataSetDto;
import com.fatih_demo.fatih_Demo.entity.DataSet;
import com.fatih_demo.fatih_Demo.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datasets")
public class DataSetController {
    private final DataSetService dataSetService;

    @Autowired
    public DataSetController(DataSetService dataSetService) {
        this.dataSetService = dataSetService;
    }

    @GetMapping("/{id}")
    public DataSetDto getDataSet(@PathVariable Integer id) {
        return dataSetService.getDataSet(id);
    }

    @GetMapping("/get/all")
    public List<DataSetDto> getAllDataSets() {
        return dataSetService.getAllDataSet();
    }

    @PostMapping("/add")
    public DataSetDto saveDataSet(@RequestBody DataSet dataSet) {
        return dataSetService.save(dataSet);
    }

    @PutMapping("/{id}")
    public DataSetDto updateDataSet(@PathVariable Integer id, @RequestBody DataSet dataSet) {
        return dataSetService.updateDataSet(id, dataSet);
    }

    @DeleteMapping("/{id}")
    public void deleteDataSet(@PathVariable Integer id) {
        dataSetService.deleteDataSet(id);
    }


}
