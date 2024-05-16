package com.mercadolibre.couponchallenge.dto.mercadolibre.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthResponse(
        @JsonProperty("access_token")
        String accessToken,
        @JsonProperty("token_type")
        String tokenType,
        @JsonProperty("expires_in")
        Long expiresIn,
        String scope,
        @JsonProperty("user_id")
        Long userID,
        @JsonProperty("refresh_token")
        String refreshToken
) {
}
