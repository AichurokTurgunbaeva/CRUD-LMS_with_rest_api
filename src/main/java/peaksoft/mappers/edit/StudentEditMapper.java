package peaksoft.mappers.edit;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.StudentRequest;
import peaksoft.entities.Student;

import java.time.LocalDate;

@Component
public class StudentEditMapper {
    public Student create(StudentRequest request) {
        if(request==null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setEmail(request.getEmail());
        student.setLastName(request.getLastName());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroupId(request.getGroupId());
        student.setCreated(LocalDate.now());
        return student;
    }

    public void update(Student student, StudentRequest request) {
        student.setFirstName(request.getFirstName());
        student.setEmail(request.getEmail());
        student.setLastName(request.getLastName());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroupId(request.getGroupId());
        student.setCreated(LocalDate.now());
    }
}


