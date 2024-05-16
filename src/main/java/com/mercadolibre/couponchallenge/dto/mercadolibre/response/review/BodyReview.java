package com.mercadolibre.couponchallenge.dto.mercadolibre.response.review;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record BodyReview(
        List<ReviewResponse> reviews,
        @JsonProperty("rating_levels")
        RatingResponse ratingLevels
) {

}
