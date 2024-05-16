package com.mercadolibre.couponchallenge.dto.mercadolibre.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record BodyItem(

        String id,
        /*@JsonProperty("site_id")
        String siteId,
        String title,
        @JsonProperty("seller_id")
        String sellerId,
        @JsonProperty("category_id")
        String categoryId,*/
        Double price//,
        /*@JsonProperty("initial_quantity")
        Integer quantity,
        String status*/
) {
}
