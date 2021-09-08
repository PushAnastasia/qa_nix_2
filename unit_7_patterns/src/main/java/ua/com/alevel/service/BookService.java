package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.DaoFactory;
import ua.com.alevel.dao.CrudDao;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.util.List;

@Service
public class BookService implements CrudService<Book> {

    private final CrudDao<Book> bookDao = DaoFactory.getInstance().getBookDao();
    private final CrudDao<Author> authorDao = DaoFactory.getInstance().getAuthorDao();

    @Override
    public void create(Book book) {
        bookDao.create(book);
        List<String> authorIds = book.getAuthorIds();
        for (String authorId : authorIds) {
            authorDao.link(authorId, book.getId());
        }
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(String id) {
        Book current = findById(id);
        List<String> authorIds = current.getAuthorIds();
        for (String authorId : authorIds) {
            authorDao.unlink(authorId, id);
        }
        bookDao.delete(id);
    }

    @Override
    public Book findById(String id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
