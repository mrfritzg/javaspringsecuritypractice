package com.example.demo.repo;

import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByNameStartsWith(String prefix);

    List<Country> findByNameIs(String name);

}
