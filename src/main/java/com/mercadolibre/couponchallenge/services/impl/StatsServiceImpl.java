package com.mercadolibre.couponchallenge.services.impl;

import com.mercadolibre.couponchallenge.clients.MercadoLibreReviewsClient;
import com.mercadolibre.couponchallenge.dto.api.stats.StatsCouponResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.ItemResponse;
import com.mercadolibre.couponchallenge.services.ItemService;
import com.mercadolibre.couponchallenge.services.StatsService;
import com.mercadolibre.couponchallenge.utils.HttpRequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final ItemService itemService;
    private final MercadoLibreReviewsClient mercadoLibreReviewsClient;

    @Override
    public Mono<List<StatsCouponResponse>> getFavorites(String token, String ids) {
        var items = getItems(token,ids);
        return getCoupons(token, items).collectList();
    }

    private Flux<ItemResponse> getItems(String token, String ids) {
        var attributes = HttpRequestUtils.ID_ITEM;
        return itemService.getAllItems(token, ids, attributes);
    }

    private Flux<StatsCouponResponse> getCoupons(String token, Flux<ItemResponse> items) {
        return items.flatMap(itemResponse -> {
            String id = itemResponse.body().id();
            return mercadoLibreReviewsClient.getReviewsByIdItem(HttpRequestUtils.getHeaders(token), id)
                    .map(bodyReview -> new StatsCouponResponse(bodyReview.reviews().get(0).product().id(),
                                    bodyReview.ratingLevels().fiveStars()
                            ));
                }).collectSortedList(Comparator.comparing(StatsCouponResponse::quantity).reversed())
                .flatMapMany(Flux::fromIterable);
    }


}
