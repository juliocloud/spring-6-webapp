package br.com.ojuliocode.spring_6_webapp.services;

import br.com.ojuliocode.spring_6_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
