package com.example.course3.service;

import com.example.course3.data.inventory.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
