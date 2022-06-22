package peaksoft.mappers.edit;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.CourseRequest;
import peaksoft.entities.Course;

import java.time.LocalDate;

@Component
public class CourseEditMapper {

    public Course create(CourseRequest request) {
        if(request==null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
        course.setCompanyId(request.getCompanyId());
        course.setCreated(LocalDate.now());
        return course;
    }

    public void update(Course course, CourseRequest request) {
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
        course.setCompanyId(request.getCompanyId());
        course.setCreated(LocalDate.now());
    }
}
