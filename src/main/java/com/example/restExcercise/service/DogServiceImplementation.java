package com.example.restExcercise.service;

import com.example.restExcercise.entity.Dog;
import com.example.restExcercise.repository.DogRepository;
import com.example.restExcercise.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImplementation implements DogService {
    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> getAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> getAllBreeds() {
        return dogRepository.getAllBreeds();
    }

    @Override
    public String getBreedForId(Long id) {
        Optional<String> possibleBreed =
                Optional.ofNullable(dogRepository.getBreedForId(id));
        return possibleBreed.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> getAllNames() {
        return dogRepository.getAllNames();
    }
}
