package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    private String name;
    private Integer age; // Ingeter 는 null을 포함할 수 있다

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
