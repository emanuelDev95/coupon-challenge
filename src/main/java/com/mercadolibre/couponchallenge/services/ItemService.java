package com.mercadolibre.couponchallenge.services;

import com.mercadolibre.couponchallenge.dto.api.items.request.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.api.items.response.ItemsCouponResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.ItemResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {

    Mono<ItemsCouponResponse> getItemsCoupon(final String token,
            final ItemsCouponRequest itemsCouponRequest);

    Flux<ItemResponse> getAllItems(String token, String ids, String attributes);
}
