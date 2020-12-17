package com.example.restExcercise.service;

import com.example.restExcercise.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DogService {
    List<Dog> getAllDogs();
    List<String> getAllBreeds();
    String getBreedForId(Long id);
    List<String> getAllNames();
}
