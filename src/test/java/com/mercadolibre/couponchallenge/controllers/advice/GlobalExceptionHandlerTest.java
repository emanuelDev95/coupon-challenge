package com.mercadolibre.couponchallenge.controllers.advice;

import com.mercadolibre.couponchallenge.controllers.advice.GlobalExceptionHandler;
import com.mercadolibre.couponchallenge.dto.commons.ExceptionResponse;
import com.mercadolibre.couponchallenge.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
     void testHandleWebClientResponseException() {
        // Arrange
        WebClientResponseException ex = mock(WebClientResponseException.class);
        when(ex.getStatusCode()).thenReturn(HttpStatus.BAD_REQUEST);
        when(ex.getMessage()).thenReturn("Bad Request");

        // Act
        ResponseEntity<ExceptionResponse> result = globalExceptionHandler.handleWebClientResponseException(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertEquals("Bad Request", Objects.requireNonNull(result.getBody()).message());
    }

    @Test
    void testHandleNotFoundException() {
        // Arrange
        NotFoundException ex = mock(NotFoundException.class);
        when(ex.getMessage()).thenReturn("Not Found");
        when(ex.getLocalizedMessage()).thenReturn("Not Found");

        // Act
        ResponseEntity<ExceptionResponse> result = globalExceptionHandler.handleNotFoundException(ex);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals("Not Found", Objects.requireNonNull(result.getBody()).message());

    }

    @Test
    public void testHandleMethodArgumentNotValidException() {
        // Arrange
        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        ObjectError objectError = new ObjectError("object", "defaultMessage");
        when(ex.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getAllErrors()).thenReturn(Collections.singletonList(objectError));

        // Act
        ResponseEntity<ExceptionResponse> result = globalExceptionHandler.handleMethodArgumentNotValidException(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }


}