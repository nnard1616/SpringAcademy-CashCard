package com.nathannard.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CashCardJsonTest {

    @Test
    void myFirstTest() {
        assertThat(1).isEqualTo(42);

    }
}
