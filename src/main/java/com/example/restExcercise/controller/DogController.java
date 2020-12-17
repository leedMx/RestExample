package com.example.restExcercise.controller;

import com.example.restExcercise.entity.Dog;
import com.example.restExcercise.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list = dogService.getAllDogs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getAllNames(){
        return new ResponseEntity<>(dogService.getAllNames(),HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedForId(@PathVariable Long id){
        return new ResponseEntity<>(dogService.getBreedForId(id),HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllBreeds(){
        return new ResponseEntity<>(dogService.getAllBreeds(),HttpStatus.OK);
    }
}
