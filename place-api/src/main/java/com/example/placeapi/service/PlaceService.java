package com.example.placeapi.service;

import com.example.placeapi.dao.PlaceDAO;
import com.example.placeapi.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceDAO placeDAO;

    public void CreatePlace(Place place) {
        placeDAO.save(place);
    }

    public List<Place> GetPlaces() {
        return placeDAO.findAll();
    }
    
}
