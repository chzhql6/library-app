package com.group.libraryapp.dto.calculator.request;

public class CalculatorDayOfTheWeek {

    private final String date;

    public CalculatorDayOfTheWeek(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
