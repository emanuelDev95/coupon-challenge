package com.mercadolibre.couponchallenge.dto.mercadolibre.response.item;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BodyItemTest {


    @Test
    void testBodyItem() {

        // Arrange
        var id = "item";
        var price = 50.0;


        //Act
        BodyItem bodyItem = new BodyItem(id, price);

        //Assert
        assertEquals(id, bodyItem.id());
        assertEquals(price, bodyItem.price());
        assertNotNull(bodyItem);


    }

}