package com.mercadolibre.couponchallenge.dto.api.items.request;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemsCouponRequestTest {

    @Test
    void testItemsCouponRequest() {
        // Arrange
        List<String> itemsIds = Arrays.asList("item1", "item2", "item3");
        Integer amount = 100;

        // Act
        ItemsCouponRequest request = new ItemsCouponRequest(itemsIds, amount);

        // Assert
        assertEquals(itemsIds, request.itemsIds());
        assertEquals(amount, request.amount());
    }

}