package com.mercadolibre.couponchallenge.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;




@ConfigurationProperties(prefix = "app.api")
public record MercadoLibreConfig(
        String meli,
        String id,
        String clientSecret

) {
}
