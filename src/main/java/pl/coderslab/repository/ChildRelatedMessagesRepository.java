package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.ChildRelatedMessages;

@Repository
public interface ChildRelatedMessagesRepository extends JpaRepository<ChildRelatedMessages, Long> {
    ChildRelatedMessages findFirstByOrderByIdDesc();

    ChildRelatedMessages findById(long id);
}
