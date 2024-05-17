package com.mercadolibre.couponchallenge.dto.mercadolibre.response.review;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RatingResponseTest {

    @Test
    void testRatingResponse() {

        //Arrange
        var fiveStarts = 35;

        //Act
        var ratingResponse = new RatingResponse(fiveStarts);

        //Assert
        assertNotNull(ratingResponse);
        assertEquals(fiveStarts, ratingResponse.fiveStars());
    }

}