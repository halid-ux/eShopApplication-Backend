package mk.finki.ukim.eshop.service;

import mk.finki.ukim.eshop.model.Author;
import mk.finki.ukim.eshop.model.dto.AuthorDto;

import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author addAuthor(AuthorDto author);

    Author editAuthor(Long id, AuthorDto author);

    void deleteAuthor(Long id);
}

