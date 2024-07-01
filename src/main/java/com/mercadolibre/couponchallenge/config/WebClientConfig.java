package com.mercadolibre.couponchallenge.config;

import com.mercadolibre.couponchallenge.clients.MercadoLibreItemsClient;
import com.mercadolibre.couponchallenge.clients.MercadoLibreReviewsClient;
import io.netty.channel.ChannelOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {


    @Bean
    public WebClient webClient(@Value("${app.api.url}") String urlBase) {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000); // 1-second timeout

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        return WebClient.builder()
                .clientConnector(connector)
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
