package com.fatih_demo.fatih_Demo.repo;

import com.fatih_demo.fatih_Demo.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {

}
