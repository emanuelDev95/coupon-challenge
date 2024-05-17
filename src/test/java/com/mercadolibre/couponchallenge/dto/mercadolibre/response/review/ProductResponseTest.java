package com.mercadolibre.couponchallenge.dto.mercadolibre.response.review;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductResponseTest {


    @Test
    void testProductResponse() {
        //Arr
        var id = "ML123456";

        //Act
        var productResponse = new ProductResponse(id);

        //Assert
        assertNotNull(productResponse);
        assertEquals(id, productResponse.id());
    }

}