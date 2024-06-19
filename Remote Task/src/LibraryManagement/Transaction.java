package LibraryManagement;

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private LocalDate date;
    private String memberId;
    private String bookIsbn;
    private TransactionType transactionType;


    public Transaction(String transactionId, LocalDate date, String memberId, String bookIsbn, TransactionType transactionType) {
        this.transactionId = transactionId;
        this.date = date;
        this.memberId = memberId;
        this.bookIsbn = bookIsbn;
        this.transactionType = transactionType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setMemberId(String memberId, boolean isActive) {
        if (isActive) {
            this.memberId = memberId;
        } else {
            this.memberId = "INACTIVE_" + memberId;
        }
    }
}

