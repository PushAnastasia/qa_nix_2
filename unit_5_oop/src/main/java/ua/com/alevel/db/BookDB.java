package ua.com.alevel.db;

import ua.com.alevel.entity.Book;

import java.util.UUID;

public class BookDB {

    private Book[] books = new Book[1];

    public void create(Book book) {
        book.setId(generateId());
        int bookCount = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                bookCount++;
            }
        }
        if (bookCount == books.length) {
            increaseBooks();
        }
        books[bookCount] = book;
    }

    public void update(Book book) {
        int index = getIndex(book.getId());
        books[index].setName(book.getName());
        books[index].setAuthor(book.getAuthor());
        books[index].setPagesNumber(book.getPagesNumber());
    }

    public void delete(String id) {
        int index = getIndex(id);
        for (int i = index; i < books.length; i++) {
            if (i == (books.length - 1)) {
                books[i] = null;
            } else {
                books[i] = books[i + 1];
            }
        }
        if (books.length > 1) {
            decreaseBooks();
        }
    }

    public Book findById(String id) {
        return books[getIndex(id)];
    }

    public Book[] findAll() {
        return books;
    }

    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getId().equals(id)) {
                index = i;
            }
        }
        return index;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Book book : books) {
            if (book != null && book.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    private Book[] increaseBooks() {
        Book[] tempBooks = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            tempBooks[i] = books[i];
        }
        books = tempBooks;
        return books;
    }

    private Book[] decreaseBooks() {
        Book[] tempBooks = new Book[books.length - 1];
        for (int i = 0; i < tempBooks.length; i++) {
            tempBooks[i] = books[i];
        }
        books = tempBooks;
        return books;
    }
}
