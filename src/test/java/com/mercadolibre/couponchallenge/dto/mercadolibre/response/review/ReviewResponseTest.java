package com.mercadolibre.couponchallenge.dto.mercadolibre.response.review;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewResponseTest {

    @Test
    void testReviewResponse() {
        //Arr
        var id = "ML123456";
        var product = new ProductResponse(id);

        //Act
        var review = new ReviewResponse(product);

        //Assert
        assertNotNull(review);
        assertNotNull(product);
        assertEquals(product, review.product());
        assertEquals(id, review.product().id());
    }

}