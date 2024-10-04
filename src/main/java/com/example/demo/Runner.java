package com.example.demo;

import com.example.demo.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CrudRepository<Country, Integer> crudRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Country> countries = countryRepository.findByNameIs("USA");
        countries.stream().forEach(System.out::println);
    }
}
