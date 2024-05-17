package com.mercadolibre.couponchallenge.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HttpRequestUtilsTest {

    @Test
    void testGetHeaders() {
        // Arrange
        String token = "token";

        // Act
        Map<String, String> headers = HttpRequestUtils.getHeaders(token);

        // Assert
        assertEquals(HttpRequestUtils.BEARER.concat(token), headers.get(HttpHeaders.AUTHORIZATION));
    }

    @Test
    void testJoinString() {
        // Arrange
        List<String> list = Arrays.asList("item1", "item2", "item3");
        String delimiter = ",";

        // Act
        String result = HttpRequestUtils.joinString(list, delimiter);

        // Assert
        assertEquals("item1,item2,item3", result);
    }

}