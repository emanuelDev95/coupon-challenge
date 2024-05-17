package com.mercadolibre.couponchallenge.config;

import com.mercadolibre.couponchallenge.clients.MercadoLibreItemsClient;
import com.mercadolibre.couponchallenge.clients.MercadoLibreReviewsClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
 class WebClientConfigTest {

    @Mock
    private WebClient webClient;

    @InjectMocks
    private WebClientConfig webClientConfig;

    @Test
     void testWebClient() {
        // Act
        WebClient result = webClientConfig.webClient("http://test.url");

        // Assert
        assertNotNull(result);
    }

    @Test
     void testMercadoLibreItemsClient() {
        // Act
        MercadoLibreItemsClient result = webClientConfig.mercadoLibreItemsClient(webClient);

        // Assert
        assertNotNull(result);
    }

    @Test
     void testMercadoLibreReviewsClient() {
        // Act
        MercadoLibreReviewsClient result = webClientConfig.mercadoLibreReviewsClient(webClient);

        // Assert
        assertNotNull(result);
    }
}