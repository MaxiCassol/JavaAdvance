package com.soyhenry.expenseapp.domain;

public class Expense {
    private Long id;
    private Double amount;
    private Long categoryId;
    private String categoryName;
    private String date;

    public Expense() {
    }

    public Expense(Double amount, Long categoryId, String categoryName, String date) {
        this.amount = amount;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long category) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
            "id=" + id +
            ", amount=" + amount +
            ", categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", date='" + date + '\'' +
            '}';
    }
}
