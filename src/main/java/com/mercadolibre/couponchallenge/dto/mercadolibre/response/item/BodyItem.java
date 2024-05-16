package com.mercadolibre.couponchallenge.dto.mercadolibre.response.item;

import lombok.Builder;

@Builder
public record BodyItem(
        String id,
        Double price//,
) {
}
