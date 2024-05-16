package com.mercadolibre.couponchallenge;

import com.mercadolibre.couponchallenge.config.properties.MercadoLibreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({MercadoLibreConfig.class})
public class CouponChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponChallengeApplication.class, args);
    }

}
