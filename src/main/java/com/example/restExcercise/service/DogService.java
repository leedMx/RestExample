package com.example.restExcercise.service;

import com.example.restExcercise.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> getAllDogs();
    List<String> getAllBreeds();
    String getBreedForId(Long id);
    List<String> getAllNames();
    Dog getDogById(Integer id);
    Dog update(Dog dog);
    Boolean delete(Integer id);
}
