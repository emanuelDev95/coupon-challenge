package com.mercadolibre.couponchallenge.services.impl;

import com.mercadolibre.couponchallenge.clients.MercadoLibreItemsClient;
import com.mercadolibre.couponchallenge.dto.api.items.request.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.api.items.response.ItemsCouponResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.ItemResponse;
import com.mercadolibre.couponchallenge.exceptions.NotFoundException;
import com.mercadolibre.couponchallenge.services.ItemService;
import com.mercadolibre.couponchallenge.utils.HttpRequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Validated
public class ItemServiceImpl implements ItemService {

    private final MercadoLibreItemsClient mercadoLibreItemsClient;

    @Override
    public Mono<ItemsCouponResponse> getItemsCoupon(final String token,
                                                     final ItemsCouponRequest itemsCouponRequest) {
        var idesRequest = HttpRequestUtils.joinString(itemsCouponRequest.itemsIds(), HttpRequestUtils.COMMA);
        var attributes = this.getAttributes();
        var items = getAllItems(token, idesRequest, attributes);
        return this.getItemsOfCoupon(itemsCouponRequest.amount(), items);

    }

    @Override
    public Flux<ItemResponse> getAllItems(String token, String ids, String attributes) {
        var headers = HttpRequestUtils.getHeaders(token);
        return mercadoLibreItemsClient.getItems(headers, ids, attributes);

    }

    private Mono<ItemsCouponResponse> getItemsOfCoupon(int amount, Flux<ItemResponse> items) {
        return items
                .filter(item -> item.body().price() != null) // Filtra los elementos con precio no nulo
                .collectMap(item -> item.body().id(), item -> item.body().price().intValue())
                .flatMap(itemsMap -> {
                    if (itemsMap.isEmpty()) {
                        return Mono.error(new NotFoundException("Items not found"));
                    }

                    AtomicInteger total = new AtomicInteger(0);

                    return Flux.fromIterable(itemsMap.entrySet())
                            .flatMap(entry -> Mono.just(entry.getValue())
                                    .filter(price -> total.get() + price <= amount)
                                    .doOnNext(total::addAndGet)
                                    .map(price -> entry.getKey())
                            )
                            .collectList()
                            .map(itemIds -> new ItemsCouponResponse(itemIds, total.get()));
                });
    }

    private  String getAttributes() {
        return HttpRequestUtils.ID_ITEM + HttpRequestUtils.COMMA + HttpRequestUtils.PRICE;
    }





}
