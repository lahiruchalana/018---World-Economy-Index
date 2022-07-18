package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.service.GDPService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/data/gdp")
public class GDPController {

    private final GDPService gdpService;

    public GDPController(GDPService gdpService) {
        this.gdpService = gdpService;
    }

    @PostMapping
    public void addNewGDPData(@RequestBody GDP gdp) {
        gdpService.addNewGDP(gdp);
    }

}
