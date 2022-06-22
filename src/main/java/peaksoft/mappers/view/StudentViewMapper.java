package peaksoft.mappers.view;

import org.springframework.stereotype.Component;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entities.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {
    public StudentResponse viewStudent(Student student) {
        if(student==null) {
            return null;
        }
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setEmail(student.getEmail());
        response.setLastName(student.getLastName());
        response.setStudyFormat(student.getStudyFormat());
        response.setGroupName(student.getGroup().getGroupName());
        response.setCreated(student.getCreated());
        return response;
    }

    public List<StudentResponse> view(List<Student> students) {
        List<StudentResponse> responses = new ArrayList<>();
        for (Student student:  students) {
            responses.add(viewStudent(student));
        }
        return responses;
    }

}
