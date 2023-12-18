package com.soyhenry.expenseapp.dto.request;

public class ExpenseRequestDto {
    private Double amount;
    private ExpenseCategoryRequestDto categoryDto;
    private String date;

    public ExpenseRequestDto() {
    }

    public ExpenseRequestDto(Double amount, ExpenseCategoryRequestDto categoryDto, String date) {
        this.amount = amount;
        this.categoryDto = categoryDto;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseCategoryRequestDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryName(ExpenseCategoryRequestDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExpenseRequestDto{" +
                "amount=" + amount +
                ", categoryDto=" + categoryDto.toString() +
                ", date='" + date + '\'' +
                '}';
    }
}
