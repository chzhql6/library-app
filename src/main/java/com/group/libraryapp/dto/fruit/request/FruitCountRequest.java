package com.group.libraryapp.dto.fruit.request;

public class FruitCountRequest {

    private final String name;

    public FruitCountRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
