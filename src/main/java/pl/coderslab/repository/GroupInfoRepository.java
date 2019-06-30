package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.GroupInfo;


public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {

}
