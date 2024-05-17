package com.mercadolibre.couponchallenge.dto.mercadolibre.response.item;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemResponseTest {

    @Test
    void testItemResponse() {

        //Arrange
        var code = 200;
        var id = "item";
        var price = 50.0;
        BodyItem bodyItem = new BodyItem(id, price);

        //Act
        var response = new ItemResponse(code, bodyItem);

        //Assert
        assertNotNull(response);
        assertEquals(response.body(), bodyItem);
        assertEquals(response.code(), code);

    }

}