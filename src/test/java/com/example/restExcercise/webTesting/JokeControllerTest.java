package com.example.restExcercise.webTesting;

import com.example.restExcercise.config.SecurityConfiguration;
import com.example.restExcercise.controller.JokeController;
import com.example.restExcercise.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (JokeController.class)
//@Import(SecurityConfiguration.class)
public class JokeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    RestTemplate rest;
    @MockBean
    AuthenticationService auth;

    @Test
    public void testJoke() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/joke"))
                .andExpect(status().isOk());
    }
}
