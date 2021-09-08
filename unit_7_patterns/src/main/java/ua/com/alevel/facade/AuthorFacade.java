package ua.com.alevel.facade;

import ua.com.alevel.dto.AuthorRequestDto;
import ua.com.alevel.dto.AuthorResponseDto;

import java.util.List;

public interface AuthorFacade {

    void create(AuthorRequestDto dto);
    void update(AuthorRequestDto dto, String id);
    void delete(String id);
    AuthorResponseDto findById(String id);
    List<AuthorResponseDto> findAll();
}
