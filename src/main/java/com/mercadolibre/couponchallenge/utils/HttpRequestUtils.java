package com.mercadolibre.couponchallenge.utils;

import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequestUtils {

    public static final String BEARER = "Bearer ";
    public static final String ID_ITEM = "id";
    public static final String PRICE = "price";
    public static final String COMMA= ",";

    private HttpRequestUtils() {}

    public static Map<String, String> getHeaders(String token) {

        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.AUTHORIZATION, BEARER.concat(token));
        return headers;
    }

    public static String joinString(List<String> list, String delimiter) {
        return String.join(delimiter, list);
    }


}
