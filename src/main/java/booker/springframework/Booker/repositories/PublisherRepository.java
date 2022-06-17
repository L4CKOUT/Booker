package booker.springframework.Booker.repositories;

import booker.springframework.Booker.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}

