package com.mercadolibre.couponchallenge.dto.api.items.response;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemsCouponResponseTest {


    @Test
    void testItemsCouponResponse() {
        // Arrange
        List<String> itemsIds = Arrays.asList("item1", "item2", "item3");
        Integer total = 100;

        // Act
        ItemsCouponResponse request = new ItemsCouponResponse(itemsIds, total);

        // Assert
        assertEquals(itemsIds, request.ids());
        assertEquals(total, request.total());
    }

}