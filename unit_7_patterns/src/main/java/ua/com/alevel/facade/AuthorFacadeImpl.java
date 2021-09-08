package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.AuthorRequestDto;
import ua.com.alevel.dto.AuthorResponseDto;
import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorFacadeImpl implements AuthorFacade {

    private final AuthorService authorService;

    public AuthorFacadeImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void create(AuthorRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(AuthorRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        authorService.delete(id);
    }

    @Override
    public AuthorResponseDto findById(String id) {
        return new AuthorResponseDto(authorService.findById(id));
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        List<Author> authors = authorService.findAll();
        List<AuthorResponseDto> dtoList = new ArrayList<>();
        for (Author author : authors) {
            dtoList.add(new AuthorResponseDto(author));
        }
        return dtoList;
    }

    private void createOrUpdate(AuthorRequestDto dto, String id) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setBirthDay(dto.getBirthDay());
        if (id == null) {
            authorService.create(author);
        } else {
            author.setId(id);
            authorService.update(author);
        }
    }
}
