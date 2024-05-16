package com.mercadolibre.couponchallenge.services.impl;

import com.mercadolibre.couponchallenge.clients.MercadoLibreItemsClient;
import com.mercadolibre.couponchallenge.dto.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.ItemsCouponResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.BodyItem;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.ItemResponse;
import com.mercadolibre.couponchallenge.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final MercadoLibreItemsClient mercadoLibreItemsClient;

    private static final String BEARER = "Bearer ";
    private static final String ID_ITEM = "id";
    private static final String PRICE = "price";
    private static final String COMMA= ",";


    @Override
    public Mono<ItemsCouponResponse> getItemsCoupon(final String token,
                                                    final ItemsCouponRequest itemsCouponRequest) {
        var idesRequest = String.join(COMMA, itemsCouponRequest.itemsIds());
        var attributes = getAttributes();
        var items = getAllItems(token, idesRequest, attributes);
        return this.getItemsOfCoupon(itemsCouponRequest.amount(), items);

    }

    private String getAttributes() {
        return ID_ITEM + COMMA + PRICE;
    }


    private Flux<ItemResponse> getAllItems(String token, String ids, String attributes) {
        var headers = getHeaders(token);
        return mercadoLibreItemsClient.getItems(headers, ids, attributes);


    }

    private Map<String, String> getHeaders(String token) {

        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.AUTHORIZATION, BEARER.concat(token));
        return headers;
    }



    public Mono<ItemsCouponResponse> getItemsOfCoupon(int amount, Flux<ItemResponse> items) {
        Comparator<ItemResponse> idComparator = Comparator.comparing(item -> item.getBody().id());
        return items.collectList().map(itemList -> {
            AtomicInteger totalPrices = new AtomicInteger();
            List<ItemResponse> filteredItems = itemList.stream()
                    .sorted(idComparator)
                    .filter(item -> item.getBody().price() <= amount)
                    .filter(item -> {
                        int currentTotal = totalPrices.addAndGet(item.getBody().price().intValue());
                        return currentTotal <= amount;
                    })
                    .toList();

            int total = filteredItems.stream().mapToInt(item -> item.getBody().price().intValue()).sum();
            List<String> itemIds = filteredItems.stream().map(item -> item.getBody().id()).sorted().toList();
            return new ItemsCouponResponse(itemIds, total);
        });
    }





}
