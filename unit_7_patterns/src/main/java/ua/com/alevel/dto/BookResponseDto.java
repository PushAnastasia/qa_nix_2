package ua.com.alevel.dto;

import ua.com.alevel.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookResponseDto {

    private String id;
    private String name;
    private String genre;
    private List<String> authorIds = new ArrayList<>();

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.genre = book.getGenre();
        this.authorIds = book.getAuthorIds();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public List<String> getAuthorIds() {
        return authorIds;
    }
}
