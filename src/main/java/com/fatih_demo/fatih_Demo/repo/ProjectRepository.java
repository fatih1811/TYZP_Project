package com.fatih_demo.fatih_Demo.repo;

import com.fatih_demo.fatih_Demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
