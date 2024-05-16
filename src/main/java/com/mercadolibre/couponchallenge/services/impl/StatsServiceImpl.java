package com.mercadolibre.couponchallenge.services.impl;

import com.mercadolibre.couponchallenge.clients.MercadoLibreItemsClient;
import com.mercadolibre.couponchallenge.dto.StatsCouponResponse;
import com.mercadolibre.couponchallenge.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final MercadoLibreItemsClient mercadoLibreItemsClient;

    //TODO: validar este servicio
    @Override
    public Mono<List<StatsCouponResponse>> getFavorites() {
        return null;
    }


}
