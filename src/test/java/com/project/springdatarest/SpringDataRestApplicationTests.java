package com.project.springdatarest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.project.springdatarest.controller.VoitureController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)  // Utilisation de @ExtendWith pour JUnit 5
@SpringBootTest

class SpringbootReactPart1ApplicationTests {

    @Autowired
    private VoitureController voitureController;  // Injection du contrôleur

    @Test
    void contextLoads() {
        assertThat(voitureController).isNotNull();

    }
}
