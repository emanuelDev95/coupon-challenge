package com.mercadolibre.couponchallenge.services.impl;

import com.mercadolibre.couponchallenge.clients.MercadoLibreItemsClient;
import com.mercadolibre.couponchallenge.dto.api.items.request.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.api.items.response.ItemsCouponResponse;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.BodyItem;
import com.mercadolibre.couponchallenge.dto.mercadolibre.response.item.ItemResponse;
import com.mercadolibre.couponchallenge.exceptions.NotFoundException;
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
class ItemServiceImplTest {

    @Mock
    private MercadoLibreItemsClient mercadoLibreItemsClient;

    @InjectMocks
    private ItemServiceImpl itemService;


    @Test
    void getAllItems() {
        //Arrange

        String token = "token";
        String ids = "MLS123456";
        String attributes = "price";

        ItemResponse itemResponse = new ItemResponse(200,
                new BodyItem("MLS123456", 500.0));

        when(mercadoLibreItemsClient.getItems(any(), any(), any())).thenReturn(Flux.just(itemResponse));

        //Act
        Flux<ItemResponse> result = itemService.getAllItems(token, ids, attributes);


        //Assert
        StepVerifier.create(result)
                .expectNext(itemResponse)
                .verifyComplete();
    }

    @Test
    void getItemsOfCouponPriceNonNull() {
        //Arrange
        String token = "token";
        var ids = "MLS123456";
        var request = new ItemsCouponRequest(List.of(ids), 500);

        ItemResponse itemResponse = new ItemResponse(200,
                new BodyItem("MLS123456", 500.0));
        ItemsCouponResponse expct = new ItemsCouponResponse(List.of(ids), 500);


        //Act

        when(mercadoLibreItemsClient.getItems(any(), any(), any())).thenReturn(Flux.just(itemResponse));
        Mono<ItemsCouponResponse> result = itemService.getItemsCoupon(token, request);

        //Assert
        StepVerifier.create(result)
                .expectNext(expct)
                .verifyComplete();




    }

    @Test
    void getItemsOfCouponPriceIsNull() {
        String token = "token";
        var ids = "MLS123456";
        var request = new ItemsCouponRequest(List.of(ids), 500);

        ItemResponse itemResponse = new ItemResponse(200,
                new BodyItem("MLS123456", null));


        when(mercadoLibreItemsClient.getItems(any(), any(), any())).thenReturn(Flux.just(itemResponse));

        Mono<ItemsCouponResponse> result = itemService.getItemsCoupon(token, request);

        StepVerifier.create(result)
                .expectError(NotFoundException.class)
                .verify();




    }

}






