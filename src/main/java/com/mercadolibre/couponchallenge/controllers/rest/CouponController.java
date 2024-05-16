package com.mercadolibre.couponchallenge.controllers.rest;


import com.mercadolibre.couponchallenge.dto.api.items.request.ItemsCouponRequest;
import com.mercadolibre.couponchallenge.dto.api.items.response.ItemsCouponResponse;
import com.mercadolibre.couponchallenge.dto.api.stats.StatsCouponResponse;
import com.mercadolibre.couponchallenge.services.ItemService;
import com.mercadolibre.couponchallenge.services.StatsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
@Validated
public class CouponController {

    private final ItemService itemService;
    private final StatsService statsService;

    @PostMapping
    public ResponseEntity<Mono<ItemsCouponResponse>> getCoupon(@NotEmpty(message = "Token may not be empty") @RequestHeader String token,
                                                               @Valid @RequestBody ItemsCouponRequest request) {

        return ResponseEntity.ok(itemService.getItemsCoupon(token, request));
    }

    @GetMapping("/stats")
    public ResponseEntity<Mono<List<StatsCouponResponse>>> getCouponStats(@NotEmpty(message = "Token may not be empty") @RequestHeader String token,
                                                                          @RequestParam String ids) {
        return ResponseEntity.ok(statsService.getFavorites(token, ids));

    }



}
