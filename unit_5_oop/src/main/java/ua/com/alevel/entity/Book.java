package ua.com.alevel.entity;

public class Book extends BaseEntity {

    private String name;
    private String author;
    private int pagesNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public String toString() {
        return "Book(Id = " + getId() +
                ", name = " + name +
                ", author = " + author +
                ", number of pages = " + pagesNumber + ")";
    }
}
