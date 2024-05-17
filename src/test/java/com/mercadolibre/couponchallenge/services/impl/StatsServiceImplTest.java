package com.mercadolibre.couponchallenge.services.impl;

import com.mercadolibre.couponchallenge.clients.MercadoLibreReviewsClient;
import com.mercadolibre.couponchallenge.dto.api.stats.StatsCouponResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.BodyItem;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.ItemResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.review.BodyReview;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.review.ProductResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.review.RatingResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.review.ReviewResponse;
import com.mercadolibre.couponchallenge.services.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class StatsServiceImplTest {

    @Mock
    private ItemService itemService;
    @Mock
    private MercadoLibreReviewsClient mercadoLibreReviewsClient;
    @InjectMocks
    private StatsServiceImpl statsService;

    @Test
    void getStats() {
        String token = "token";
        var ids = "MLS123456";

        ItemResponse itemResponse = new ItemResponse(200,
                new BodyItem("MLS123456", 500.0));

        BodyReview bodyReviewMono = new BodyReview(List.of(new ReviewResponse(
                new ProductResponse("MLS123456")
        )), new RatingResponse(15) );

        when(itemService.getAllItems(any(),any(), any())).thenReturn(Flux.just(itemResponse));
        when(mercadoLibreReviewsClient.getReviewsByIdItem(any(),any())).thenReturn(Mono.just(bodyReviewMono));

        StatsCouponResponse expct = new StatsCouponResponse("MLS123456", 15);
        var expctList = List.of(expct);

        var result = statsService.getFavorites(token, ids);

        StepVerifier.create(result)
                .expectNext(expctList)
                .verifyComplete();

    }

}