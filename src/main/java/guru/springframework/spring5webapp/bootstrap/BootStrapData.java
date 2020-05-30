package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
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

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher  pub1 = new Publisher("456 your street","phila",
                "PA","09087","Booking House" );
        publisherRepository.save(pub1);
        System.out.println("Number of Pubs: " + publisherRepository.count());



        Author eric = new Author("eric", "evans");
        Book ddd = new Book("Domain Driven Design","12121");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pub1);
       pub1.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(pub1);



        Author rod = new Author("rod", "johson");
        Book noEjb = new Book("J2EE DEvelopment without EJB","878787");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        noEjb.setPublisher(pub1);
        pub1.getBooks().add(noEjb);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(pub1);

        System.out.println("Started in BootStrapp");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of Publishers books: " + pub1.getBooks().size());




    }
}