package ua.com.alevel.dao;

import ua.com.alevel.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractBookDao {

    protected List<Book> books = new ArrayList<>();

    AbstractAuthorDao authorDao = new CsvAuthorDao();

    protected void createBook(Book book) {
        book.setId(generateId());
        books.add(book);
    }

    protected void updateBook(Book book) {
        if (existById(book.getId())) {
            Book current = findBookById(book.getId());
            current.setId(book.getId());
            current.setName(book.getName());
            current.setGenre(book.getGenre());
            current.setAuthorIds(book.getAuthorIds());
        }
    }

    protected void linkAuthor(String authorId, String bookId) {
        Book current = books.stream().filter(book -> book.getId().equals(bookId)).findFirst().get();
        List<String> authorIds = current.getAuthorIds();
        authorIds.add(authorId);
    }

    protected void unlinkAuthor(String authorId, String bookId) {
        Book current = books.stream().filter(book -> book.getId().equals(bookId)).findFirst().get();
        List<String> authorIds = current.getAuthorIds();
        authorIds.removeIf(id -> id.equals(authorId));
    }

    protected void deleteBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    protected Book findBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().get();
    }

    protected List<Book> findAllBooks() {
        return books;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return books.stream().anyMatch(book -> book.getId().equals(id));
    }
}
