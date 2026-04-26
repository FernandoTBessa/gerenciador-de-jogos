package com.example;

import org.junit.jupiter.api.Test; // Mudou do JUnit 4 para o 5
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @Test
    void contextLoads() {
        // Este teste apenas verifica se o Spring consegue iniciar com seu banco PostgreSQL
    }
}