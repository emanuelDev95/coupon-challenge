package com.mercadolibre.couponchallenge.dto.mercadolibre.response.review;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReviewResponse(
        @JsonProperty("reviewable_object")
        ProductResponse product
) {

}
