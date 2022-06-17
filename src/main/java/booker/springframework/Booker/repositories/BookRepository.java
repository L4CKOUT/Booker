package booker.springframework.Booker.repositories;

import booker.springframework.Booker.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
