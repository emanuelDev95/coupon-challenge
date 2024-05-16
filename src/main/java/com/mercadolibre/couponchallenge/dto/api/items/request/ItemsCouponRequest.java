package com.mercadolibre.couponchallenge.dto.api.items.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ItemsCouponRequest(
        @JsonProperty("items_ids")
        List<String> itemsIds,
        //@Min(message = "cannot be less than 1", value = 1)
        Integer amount
) {

}
