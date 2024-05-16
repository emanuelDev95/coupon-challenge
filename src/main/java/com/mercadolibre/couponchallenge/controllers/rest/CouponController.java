package com.mercadolibre.couponchallenge.controllers.rest;


import com.mercadolibre.couponchallenge.dto.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.ItemsCouponResponse;
import com.mercadolibre.couponchallenge.dto.StatsCouponResponse;
import com.mercadolibre.couponchallenge.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Mono<ItemsCouponResponse>> getCoupon(@RequestHeader String token, @RequestBody ItemsCouponRequest request) {

        return ResponseEntity.ok(itemService.getItemsCoupon(token, request));
    }

    //TODO: validar este servicio
    @GetMapping("/stats")
    public ResponseEntity<Mono<List<StatsCouponResponse>>> getCouponStats(@RequestHeader String token) {
        return ResponseEntity.ok(Mono.just(List.of(new StatsCouponResponse("MLA1", 15))));

    }



}
