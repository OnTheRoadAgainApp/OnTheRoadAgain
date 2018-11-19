package works.ontheroadagain.app.services;

import org.springframework.data.repository.CrudRepository;
import works.ontheroadagain.app.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findById (Long id);
}
