package com.example.restExcercise.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.restExcercise.entity.Dog;
import com.example.restExcercise.exception.DogNotFoundException;
import com.example.restExcercise.repository.DogRepository;
import com.example.restExcercise.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private DogService dogService;
    public Iterable<Dog> findDogs(){
        return dogService.getAllDogs();
    }
    public Dog findDogById(Integer id){
        return dogService.getDogById(id);
    }
    public Dog newDog(String name, String breed, String location){
        Dog dog = new Dog();
        dog.setBreed(breed);
        dog.setDogName(name);
        dog.setOrigin(location);
        return  dogService.update(dog);
    }
    public Dog updateDogName(Integer id, String name){
        try {
            Dog dog = dogService.getDogById(id);
            dog.setDogName(name);
            return dogService.update(dog);
        } catch (DogNotFoundException ex){
            ex.setId(id);
            throw ex;
        }
    }
    public Boolean deleteDog(Integer id){
        return dogService.delete(id);
    }
}
