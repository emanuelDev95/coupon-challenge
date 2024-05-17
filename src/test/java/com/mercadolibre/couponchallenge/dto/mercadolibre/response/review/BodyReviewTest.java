package com.mercadolibre.couponchallenge.dto.mercadolibre.response.review;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BodyReviewTest {


    @Test
    void testBodyReview() {

        // Arrange
        var id = "ML123456";
        var fiveStarts = 18;
        var product = new ProductResponse(id);
        List<ReviewResponse> reviews = List.of(new ReviewResponse(product));
        RatingResponse ratingLevels = new RatingResponse(fiveStarts);

        // Act
        BodyReview bodyReview = new BodyReview(reviews, ratingLevels);

        // Assert
        assertNotNull(bodyReview);
        assertEquals(reviews, bodyReview.reviews());
        assertEquals(ratingLevels, bodyReview.ratingLevels());

    }

}