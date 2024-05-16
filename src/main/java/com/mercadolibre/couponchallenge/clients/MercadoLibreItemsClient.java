package com.mercadolibre.couponchallenge.clients;

import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.ItemResponse;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;

import java.util.Map;


@HttpExchange(url = "/items")
public interface MercadoLibreItemsClient {

    @GetExchange
    Flux<ItemResponse> getItems(@RequestHeader Map<String, String> headers,
                                @RequestParam(name = "ids") String itemsId,
                                @RequestParam String attributes);





}
