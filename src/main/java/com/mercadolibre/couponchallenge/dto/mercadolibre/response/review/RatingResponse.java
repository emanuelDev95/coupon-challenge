package com.mercadolibre.couponchallenge.dto.mercadolibre.response.review;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RatingResponse(
        @JsonProperty("five_star")
        Integer fiveStars) {

}
