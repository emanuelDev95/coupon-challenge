package com.mercadolibre.couponchallenge.controllers.rest;

import com.mercadolibre.couponchallenge.dto.api.items.request.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.api.items.response.ItemsCouponResponse;
import com.mercadolibre.couponchallenge.dto.api.stats.StatsCouponResponse;
import com.mercadolibre.couponchallenge.services.ItemService;
import com.mercadolibre.couponchallenge.services.StatsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;

@SpringBootTest
class CouponControllerTest {

    @Mock
    private ItemService itemService;

    @Mock
    private StatsService statsService;

    @InjectMocks
    private CouponController couponController;

    @Test
    void testGetCoupon() {
        // Arrange
        String token = "token";
        var ids = Collections.singletonList("MLS123456");
        var amount = 500;
        ItemsCouponRequest request = new ItemsCouponRequest(ids,amount);
        ItemsCouponResponse response = new ItemsCouponResponse(ids,450);

        when(itemService.getItemsCoupon(token, request)).thenReturn(Mono.just(response));

        // Act
        ResponseEntity<Mono<ItemsCouponResponse>> result = couponController.getCoupon(token, request);

        // Assert
        StepVerifier.create(Objects.requireNonNull(result.getBody()))
                .expectNext(response)
                .verifyComplete();
    }

    @Test
    void testGetCouponStats() {
        // Arrange
        String token = "token";
        String ids = "ids";
        StatsCouponResponse response = new StatsCouponResponse("MLS123456", 18); // Assuming you have a default constructor or a method to create an instance
        List<StatsCouponResponse> responseList = Collections.singletonList(response);

        when(statsService.getFavorites(token, ids)).thenReturn(Mono.just(responseList));

        // Act
        ResponseEntity<Mono<List<StatsCouponResponse>>> result = couponController.getCouponStats(token, ids);

        // Assert
        StepVerifier.create(Objects.requireNonNull(result.getBody()))
                .expectNext(responseList)
                .verifyComplete();
    }
}