package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
