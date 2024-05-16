package com.mercadolibre.couponchallenge.dto.api.items.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ItemsCouponResponse (
        @JsonProperty("item_ids")
        List<String> ids,
        Integer total
) {
}
