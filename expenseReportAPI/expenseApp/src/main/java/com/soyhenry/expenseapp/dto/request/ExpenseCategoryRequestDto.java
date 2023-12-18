package com.soyhenry.expenseapp.dto.request;

public class ExpenseCategoryRequestDto {
    private String name;

    public ExpenseCategoryRequestDto() {
    }

    public ExpenseCategoryRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpenseCategoryRequestDto{" +
            "name='" + name + '\'' +
            '}';
    }
}
