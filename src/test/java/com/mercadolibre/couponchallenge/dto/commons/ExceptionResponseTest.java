package com.mercadolibre.couponchallenge.dto.commons;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExceptionResponseTest {

    @Test
    void testExceptionResponse() {
        // Arrange
        Integer statusCode = 404;
        String error = "Not Found";
        String message = "Item not found";

        // Act
        ExceptionResponse response = new ExceptionResponse(statusCode, error, message);

        // Assert
        assertEquals(statusCode, response.statusCode());
        assertEquals(error, response.error());
        assertEquals(message, response.message());
    }

}