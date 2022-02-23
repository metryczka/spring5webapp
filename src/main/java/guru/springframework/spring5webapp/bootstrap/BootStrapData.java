package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository1) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository1;

    }

    @Override
    public void run(String... args) throws Exception {

        Author henryk = new Author ("Henryk", "Sienkiewicz");
        Book krzyzacy = new Book("Krzyzacy", "AB12345");
        henryk.getBooks().add(krzyzacy);
        krzyzacy.getAuthors().add(henryk);

        authorRepository.save(henryk);
        bookRepository.save(krzyzacy);

        Author mickiewicz = new Author ("Adam", "Mickiewicz");
        Book pan = new Book("Pan Tadeusz", "AC9467");
        mickiewicz.getBooks().add(pan);
        pan.getAuthors().add(mickiewicz);

        authorRepository.save(mickiewicz);
        bookRepository.save(pan);

        Publisher publisher = new Publisher ("Sowa", "Klonowa", "Krakow", "lasser Poland", "32-233");
        publisherRepository.save(publisher);

        pan.setPublisher(publisher);
        krzyzacy.setPublisher(publisher);
        publisher.getBooks().add(pan);
        publisher.getBooks().add(krzyzacy);
        publisherRepository.save(publisher);
        bookRepository.save(pan);
        bookRepository.save(krzyzacy);





    }
}
