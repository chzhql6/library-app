package com.group.libraryapp.dto.fruit.request;

public class FruitSearchRequest {

    private final String option;
    private final Long price;

    public FruitSearchRequest(String option, Long price) {
        this.option = option;
        this.price = price;
    }

    public String getOption() {
        return option;
    }

    public Long getPrice() {
        return price;
    }
}
