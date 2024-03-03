package com.group.libraryapp.dto.fruit.response;

public class FruitSaleAmountsResponse {

    private long salesAmount;
    private long notsalesAmount;

    public FruitSaleAmountsResponse(long salesAmount, long notsalesAmount) {
        this.salesAmount = salesAmount;
        this.notsalesAmount = notsalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotsalesAmount() {
        return notsalesAmount;
    }
}
