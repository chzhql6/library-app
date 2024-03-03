package com.group.libraryapp.dto.fruit.request;

public class FruitSalesAmountRequest {

    private final String name;

    public FruitSalesAmountRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
