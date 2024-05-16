package com.mercadolibre.couponchallenge.services;

import com.mercadolibre.couponchallenge.dto.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.ItemsCouponResponse;
import reactor.core.publisher.Mono;

public interface ItemService {

    Mono<ItemsCouponResponse> getItemsCoupon(final String token,
            final ItemsCouponRequest itemsCouponRequest);
}
