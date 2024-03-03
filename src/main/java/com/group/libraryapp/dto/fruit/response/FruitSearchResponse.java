package com.group.libraryapp.dto.fruit.response;

import java.time.LocalDate;

public class FruitSearchResponse {

    private final String name;
    private final Long price;
    private final LocalDate warehousingDate;

    public FruitSearchResponse(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
