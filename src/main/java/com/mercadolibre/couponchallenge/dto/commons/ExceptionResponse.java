package com.mercadolibre.couponchallenge.dto.commons;

public record ExceptionResponse(
        Integer statusCode,
        String error,
        String message
) {
}
