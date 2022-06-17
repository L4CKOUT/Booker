package booker.springframework.Booker.bootstrap;

import booker.springframework.Booker.model.Author;
import booker.springframework.Booker.model.Book;
import booker.springframework.Booker.model.Publisher;
import booker.springframework.Booker.repositories.AuthorRepository;
import booker.springframework.Booker.repositories.BookRepository;
import booker.springframework.Booker.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Detect as a Spring Data JPA component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher.setCity("United Kingdom");
        publisher.setState("London");

        publisherRepository.save(publisher);

        Author seuss = new Author("Dr", "Seuss");
        Book lorax = new Book("The Lorax", "123456");
        seuss.getBooks().add(lorax);
        lorax.getAuthors().add(seuss);

        lorax.setPublisher(publisher);
        publisher.getBooks().add(lorax);

        authorRepository.save(seuss);
        bookRepository.save(lorax);
        publisherRepository.save(publisher);


        Author mg = new Author("Malcomn", "Gladwell");
        Book bomb = new Book("The Bomber Mafia", "20010491");
        mg.getBooks().add(bomb);
        bomb.getAuthors().add(mg);

        bomb.setPublisher(publisher);
        publisher.getBooks().add(bomb);

        authorRepository.save(mg);
        bookRepository.save(bomb);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of publisher books: " + publisher.getBooks().size());
    }
}
