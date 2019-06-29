package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.GeneralInfo;

@Repository
public interface GeneralInfoRepository extends JpaRepository<GeneralInfo, Long> {

}
