package com.mercadolibre.couponchallenge.services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthServiceImplTest {

    @Autowired
    private AuthService authService;

    @Test
    void getToken(){

        var request = new AuthRequest("authorization_code",
                "6108866500380003",
                "bjAK91iRzT0ERGRi4nydLlB7Z6yPUVlX",
                "TG-6644f6b8e682e000013f7c1e-1595725864",
                "https://github.com/emanuelDev95");

        var response = authService.getToken(request);

        System.out.println(response.toString());

        /*StepVerifier.create(response)
                .expectNextMatches(authResponse -> Objects.nonNull(authResponse.accessToken()))
                .expectComplete()
                .verify();*/

    }



}