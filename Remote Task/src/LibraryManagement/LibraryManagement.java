package LibraryManagement;

public class LibraryManagement {
    public static void main(String[] args) {
        // Create a new library instance
        Library library = new Library();

        // Register new members
        library.registerMember(new Member("John Doe", "M1234", "123 Main St"));
        library.registerMember(new Member("Alice Smith", "M5678", "456 Elm St"));

        // Add books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780142437230", "Classic"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction"));

        // Perform transactions
        library.checkOutBook("9780142437230", "M1234");
        library.checkOutBook("9780061120084", "M5678");

        // Return books with and without damage
        library.returnBook("9780142437230", "M1234", false); // Returned without damage
        library.returnBook("9780061120084", "M5678", true); // Returned with damage

        // Remove a member from the library system
        library.removeMember("M1234");

        // Add a previously removed member back to the library
        library.addMember(new Member("John Doe", "M1234", "123 Main St"));

        // Generate transaction report
        library.generateTransactionReport();
    }
}
