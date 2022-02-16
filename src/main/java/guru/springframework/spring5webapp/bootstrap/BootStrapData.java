package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.repositories.PublisherRepository;
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

        System.out.println("This is started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());

        Publisher publisher = new Publisher ("Sowa", "Klonowa", "Krakow", "lasser Poland", "32-233");
        publisherRepository.save(publisher);
        System.out.println("Number of publishers " + publisherRepository.count());

        pan.setPublisher(publisher);
        krzyzacy.setPublisher(publisher);
        publisher.getBooks().add(pan);
        publisher.getBooks().add(krzyzacy);
        publisherRepository.save(publisher);
        bookRepository.save(pan);
        bookRepository.save(krzyzacy);
        System.out.println("Publisher has " + publisher.getBooks().size() + " books");




    }
}
