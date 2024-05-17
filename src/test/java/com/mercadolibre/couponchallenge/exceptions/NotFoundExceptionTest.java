package com.mercadolibre.couponchallenge.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotFoundExceptionTest {

    @Test
     void testNotFoundException() {
        // Arrange
        String message = "Not Found";

        // Act
        NotFoundException exception = new NotFoundException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }

}