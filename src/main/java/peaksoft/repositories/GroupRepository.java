package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
