package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    Group findById(long id);
}
