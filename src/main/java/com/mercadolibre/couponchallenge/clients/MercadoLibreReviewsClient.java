package com.mercadolibre.couponchallenge.clients;

import com.mercadolibre.couponchallenge.dto.mercadolibre.response.review.BodyReview;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

@HttpExchange("/reviews")
public interface MercadoLibreReviewsClient {

    @GetExchange("/item/{idItem}")
    Mono<BodyReview> getReviewsByIdItem(@RequestHeader Map<String, String> headers,
                                        @PathVariable String idItem);
}
