package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.InfoForTeacher;
@Repository
public interface InfoForTeacherRepository extends JpaRepository<InfoForTeacher,Long> {

}
