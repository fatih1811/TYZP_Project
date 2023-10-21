package com.fatih_demo.fatih_Demo.repo;

import com.fatih_demo.fatih_Demo.entity.Resource;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer> {

}
