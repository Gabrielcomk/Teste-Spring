package br.com.mesquita.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.springframework.stereotype.Service;
@Service

public class DatabaseExample {


    private static final Logger log = LoggerFactory.getLogger(DatabaseExample.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

   public List<Country> getData() {
        List<Country> countryList;
        countryList = jdbcTemplate.query("SELECT id, name FROM countries", (rs, rowNum) -> new Country((int) rs.getLong("id"), rs.getString("name")));
        return countryList;
    }
}