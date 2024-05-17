package com.mercadolibre.couponchallenge.dto.api.stats;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatsCouponResponseTest {

    @Test
    void testStatsCouponResponse() {

        // Arrange
        var id = "item";
        var quantity = 50;

        // Act
        StatsCouponResponse response = new StatsCouponResponse(id, quantity);

        // Assert
        assertEquals(id, response.id());
        assertEquals(quantity, response.quantity());

    }

}