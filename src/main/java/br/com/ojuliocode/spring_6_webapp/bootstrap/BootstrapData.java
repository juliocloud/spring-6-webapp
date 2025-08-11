package br.com.ojuliocode.spring_6_webapp.bootstrap;

import br.com.ojuliocode.spring_6_webapp.domain.Author;
import br.com.ojuliocode.spring_6_webapp.domain.Book;
import br.com.ojuliocode.spring_6_webapp.domain.Publisher;
import br.com.ojuliocode.spring_6_webapp.repositories.AuthorRepository;
import br.com.ojuliocode.spring_6_webapp.repositories.BookRepository;
import br.com.ojuliocode.spring_6_webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nCommand Line runner\n");

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Doamin Driven Design");
        ddd.setIsbn("123456");

        Publisher oreiley = new Publisher();
        oreiley.setPublisherName("O'reiley");
        oreiley.setAddress("Stony Circle, Suite 195");
        oreiley.setCity("Santa Rosa");
        oreiley.setZip("95401");
        oreiley.setState("CA");

        Publisher oreileySaved = publisherRepository.save(oreiley);
        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        dddSaved.setPublisher(oreileySaved);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("75864");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        noEJBSaved.setPublisher(oreileySaved);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("Author count >>> " + authorRepository.count());
        System.out.println("Book count >>> " + bookRepository.count());
        System.out.println("Publisher count >>> " + publisherRepository.count());
    }
}
