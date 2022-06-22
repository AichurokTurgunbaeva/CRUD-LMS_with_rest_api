package peaksoft.mappers.edit;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.entities.Teacher;

import java.time.LocalDate;

@Component
public class TeacherEditMapper {
        public Teacher create(TeacherRequest request) {
            if(request==null) {
                return null;
            }
            Teacher teacher = new Teacher();
            teacher.setFirstName(request.getFirstName());
            teacher.setEmail(request.getEmail());
            teacher.setLastName(request.getLastName());
            teacher.setCourseId(request.getCourseId());
            teacher.setCreated(LocalDate.now());
            return teacher;
        }

        public void update(Teacher teacher, TeacherRequest request) {
            teacher.setFirstName(request.getFirstName());
            teacher.setEmail(request.getEmail());
            teacher.setLastName(request.getLastName());
            teacher.setCourseId(request.getCourseId());
            teacher.setCreated(LocalDate.now());
        }
}
