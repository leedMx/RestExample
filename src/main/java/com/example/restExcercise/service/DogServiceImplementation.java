package com.example.restExcercise.service;

import com.example.restExcercise.entity.Dog;
import com.example.restExcercise.exception.DogNotFoundException;
import com.example.restExcercise.repository.DogRepository;
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

    @Override
    public Dog getDogById(Integer id) {
        Optional<Dog> byId = dogRepository.findById(id);
        return byId.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public Dog update(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Boolean delete(Integer id) {
        dogRepository.deleteById(id);
        return true;
    }
}
