package com.mercadolibre.couponchallenge.config;

import com.mercadolibre.couponchallenge.clients.MercadoLibreItemsClient;
import com.mercadolibre.couponchallenge.clients.MercadoLibreReviewsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {


    @Bean
    public WebClient webClient(@Value("${app.api.url}") String urlBase) {
        return WebClient.builder()
                .baseUrl(urlBase)
                .build();
    }

    @Bean
    public MercadoLibreItemsClient mercadoLibreItemsClient(WebClient webClient){

        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient))
                .build()
                .createClient(MercadoLibreItemsClient.class);

    }

    @Bean
    public MercadoLibreReviewsClient mercadoLibreReviewsClient(WebClient webClient){

        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient))
                .build()
                .createClient(MercadoLibreReviewsClient.class);

    }



}
