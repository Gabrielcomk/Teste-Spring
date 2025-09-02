package br.com.mesquita.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private DatabaseExample databaseExample;

    @GetMapping("/")
    public String index() {
        var countries = databaseExample.getData();
        return "Welcome from " + countries.get(0).getName();
    }
}