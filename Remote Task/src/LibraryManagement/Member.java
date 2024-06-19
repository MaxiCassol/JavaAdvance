package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String id;
    private String address;
    private List<String> checkedOutBooks;
    private int penalties;

    public Member(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.checkedOutBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCheckedOutBooks(List<String> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public void addCheckedOutBook(String isbn) {
        checkedOutBooks.add(isbn);
    }

    public void removeCheckedOutBook(String isbn) {
        checkedOutBooks.remove(isbn);
    }

    public void incrementPenalties() {
        penalties++;
        // Check if the member has reached the penalty limit (3)
        if (penalties >= 3) {
            System.out.println("Member " + name + " has reached the penalty limit.");
        }
    }

    public int getPenalties() {
        return penalties;
    }
}