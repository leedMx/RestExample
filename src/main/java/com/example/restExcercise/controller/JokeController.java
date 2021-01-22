package com.example.restExcercise.controller;

import com.example.restExcercise.entity.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JokeController {
    @Autowired
    RestTemplate restTemplate;
    private static final String URI = "https://official-joke-api.appspot.com/random_joke";

    @GetMapping("/joke")
    public Joke readJoke(){
        System.out.println("looking for a joke");
        Joke joke = restTemplate.getForObject(URI, Joke.class);
        System.out.println(joke);
        return joke;
    }
}
