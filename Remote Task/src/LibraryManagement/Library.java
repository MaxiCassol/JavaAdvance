package LibraryManagement;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, Book> books; // Map to store books with ISBN as key
    private final Map<String, Member> members; // Map to store members with ID as key
    private final List<Transaction> transactions; // List to store transaction history

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void registerMember(Member member) {
        members.put(member.getId(), member);
    }

    public void checkOutBook(String isbn, String memberId) {
        if (!books.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        if (!members.containsKey(memberId)) {
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }
        Book book = books.get(isbn);
        if (!book.isAvailable()) {
            System.out.println("Book with ISBN " + isbn + " is not available for checkout.");
            return;
        }
        Member member = members.get(memberId);
        book.setAvailable(false); // Mark book as unavailable
        member.addCheckedOutBook(isbn); // Add book to member's checked-out list
        transactions.add(new Transaction(generateTransactionId(), LocalDate.now(), memberId, isbn, TransactionType.CHECKOUT));
        System.out.println("Book \"" + book.getTitle() + "\" checked out by " + member.getName());
    }

    public void returnBook(String isbn, String memberId, boolean isDamaged) {
        if (!books.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        if (!members.containsKey(memberId)) {
            System.out.println("Member with ID " + memberId + " not found.");
            return;
        }
        Book book = books.get(isbn);
        if (book.isAvailable()) {
            System.out.println("Book with ISBN " + isbn + " is already available.");
            return;
        }
        if (isDamaged) {
            book.setDamaged(true);
            Member member = members.get(memberId);
            member.incrementPenalties();
            if (member.getPenalties() >= 3) {
                removeMember(memberId);
            } else {
                System.out.println("Warning: Returning a damaged book is bad. You have " + (3 - member.getPenalties()) + " penalties remaining before removal from the library system.");
            }
        }

        Member member = members.get(memberId);
        book.setAvailable(true); // Mark book as available
        member.removeCheckedOutBook(isbn); // Remove book from member's checked-out list
        transactions.add(new Transaction(generateTransactionId(), LocalDate.now(), memberId, isbn, TransactionType.RETURN));
        System.out.println("Book \"" + book.getTitle() + "\" returned by " + member.getName());
    }

    void removeMember(String memberId) {
        // Remove member from the members map
        Member removedMember = members.remove(memberId);
        if (removedMember != null) {
            // Update transactions related to the removed member
            updateTransactionsForMemberRemoval(removedMember);
            // Notify the user about member removal
            notifyUserAboutMemberRemoval(removedMember);
        }
    }

    private void updateTransactionsForMemberRemoval(Member removedMember) {
        // Iterate through transactions and update the status of the member.
        for (Transaction transaction : transactions) {
            if (transaction.getMemberId().equals(removedMember.getId())) {
                // Update transaction status
                transaction.setMemberId(removedMember.getId(), false);
            }
        }
    }
    private void notifyUserAboutMemberRemoval(Member removedMember) {
        System.out.println("Member \"" + removedMember.getName() + "\" has been removed from the library system.");
    }


    void addMember(Member member) {
        // Add the member to the members map
        members.put(member.getId(), member);
        // Update transactions related to the added member
        updateTransactionsForMemberAddition(member);
        // Notify the user about the added member
        System.out.println("Member \"" + member.getName() + "\" has been added back to the library system.");
    }

    private void updateTransactionsForMemberAddition(Member addedMember) {
        // Iterate through transactions and update the status of the member
        for (Transaction transaction : transactions) {
            if (transaction.getMemberId().startsWith("INACTIVE_" + addedMember.getId())) {
                // Remove the "INACTIVE_" prefix from the member ID in the transaction
                transaction.setMemberId(addedMember.getId(), true);
            }
        }
    }
    public void generateTransactionReport() {
        System.out.println("Transaction Report:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getTransactionId() + " | " + transaction.getDate() + " | " +
                    transaction.getMemberId() + " | " + transaction.getBookIsbn() + " | " +
                    transaction.getTransactionType());
        }
    }

    private String generateTransactionId() {
        // Generate transaction ID based on current timestamp (can be further customized)
        return "TRX-" + System.currentTimeMillis();
    }
}
