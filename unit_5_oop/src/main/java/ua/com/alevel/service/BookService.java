package ua.com.alevel.service;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.dao.BookDaoArrayImpl;
import ua.com.alevel.entity.Book;

public class BookService {

    private BookDao dao = new BookDaoArrayImpl();

    public void create(Book book) {
        dao.create(book);
    }

    public void update(Book book) {
        dao.update(book);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public Book findById(String id) {
        return dao.findById(id);
    }

    public Book[] findAll() {
        return dao.findAll();
    }
}
