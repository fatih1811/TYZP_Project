package com.fatih_demo.fatih_Demo.repo;

import com.fatih_demo.fatih_Demo.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
}
