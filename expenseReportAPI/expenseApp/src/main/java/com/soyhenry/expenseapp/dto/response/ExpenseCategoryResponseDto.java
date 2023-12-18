package com.soyhenry.expenseapp.dto.response;

public class ExpenseCategoryResponseDto {
    private Long id;
    private String name;

    public ExpenseCategoryResponseDto() {
    }

    public ExpenseCategoryResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpenseCategoryResponseDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
