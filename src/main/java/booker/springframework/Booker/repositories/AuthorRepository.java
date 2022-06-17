package booker.springframework.Booker.repositories;

import booker.springframework.Booker.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}