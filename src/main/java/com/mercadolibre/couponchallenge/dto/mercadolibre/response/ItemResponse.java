package com.mercadolibre.couponchallenge.dto.mercadolibre.response;

public class ItemResponse {

    private final Integer code;
    private final BodyItem body;

    public ItemResponse(Integer code, BodyItem body) {
        this.code = code;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public BodyItem getBody() {
        return body;
    }
}
