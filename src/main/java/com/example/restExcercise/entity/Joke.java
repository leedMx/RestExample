package com.example.restExcercise.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Joke {
    private Integer id;
    private String type;
    private String setup;
    private String punchline;
}
