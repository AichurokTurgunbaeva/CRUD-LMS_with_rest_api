package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
