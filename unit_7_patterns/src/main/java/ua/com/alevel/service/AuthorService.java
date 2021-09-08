package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.DaoFactory;
import ua.com.alevel.dao.CrudDao;
import ua.com.alevel.entity.Author;

import java.util.List;

@Service
public class AuthorService implements CrudService<Author> {

    private final CrudDao<Author> authorDao = DaoFactory.getInstance().getAuthorDao();

    @Override
    public void create(Author author) {
        authorDao.create(author);
    }

    @Override
    public void update(Author author) {
        authorDao.update(author);
    }

    @Override
    public void delete(String id) {
        authorDao.delete(id);
    }

    @Override
    public Author findById(String id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
