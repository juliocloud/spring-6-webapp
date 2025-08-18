package br.com.ojuliocode.spring_6_webapp.services;

import br.com.ojuliocode.spring_6_webapp.domain.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {
    public Iterable<Author> findAll();
}
