package ua.com.alevel.dao;

import ua.com.alevel.entity.Book;

public interface BookDao {

    void create(Book book);
    void update(Book book);
    void delete(String id);
    Book findById(String id);
    Book[] findAll();
}
