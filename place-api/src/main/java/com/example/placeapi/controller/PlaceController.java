package com.example.placeapi.controller;

import com.example.placeapi.model.Place;
import com.example.placeapi.service.PlaceService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/place")
    public void CreatePlace(@RequestBody Place place) {
        placeService.CreatePlace(place);
    }

    @GetMapping("/places")
    public List<Place> GetPlaces() {
        return placeService.GetPlaces();
    }
}
