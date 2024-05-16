package com.mercadolibre.couponchallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ItemsCouponRequest(
        @JsonProperty("items_ids")
        List<String> itemsIds,
        Integer amount
) {

}
