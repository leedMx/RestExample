package com.example.restExcercise.repository;

import com.example.restExcercise.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog,Integer> {
    @Query("SELECT id, breed FROM Dog WHERE id=:id")
    String getBreedForId(Long id);
    @Query("SELECT id, breed FROM Dog")
    List<String> getAllBreeds();
    @Query("SELECT id, dogName FROM Dog")
    List<String> getAllNames();
}
