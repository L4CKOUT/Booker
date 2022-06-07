package booker.springframework.Booker.repo;


import booker.springframework.Booker.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
