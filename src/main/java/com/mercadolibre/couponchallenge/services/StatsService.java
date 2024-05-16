package com.mercadolibre.couponchallenge.services;

import com.mercadolibre.couponchallenge.dto.StatsCouponResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StatsService {

     Mono<List<StatsCouponResponse>> getFavorites();
}
