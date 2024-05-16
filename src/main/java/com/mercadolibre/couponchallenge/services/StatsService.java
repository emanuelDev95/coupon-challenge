package com.mercadolibre.couponchallenge.services;

import com.mercadolibre.couponchallenge.dto.api.stats.StatsCouponResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StatsService {

     Mono<List<StatsCouponResponse>> getFavorites(String token, String ids);
}
