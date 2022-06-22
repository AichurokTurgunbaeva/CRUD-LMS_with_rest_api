package peaksoft.mappers.view;

import org.springframework.stereotype.Component;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.entities.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {
      public TeacherResponse viewTeacher(Teacher teacher) {
            if(teacher==null) {
                return null;
            }
            TeacherResponse response = new TeacherResponse();
            response.setId(teacher.getId());
            response.setFirstName(teacher.getFirstName());
            response.setEmail(teacher.getEmail());
            response.setLastName(teacher.getLastName());
            response.setCourseName(teacher.getCourse().getCourseName());
            response.setCreated(teacher.getCreated());
            return response;
        }

        public List<TeacherResponse> view(List<Teacher> teachers) {
            List<TeacherResponse> responses = new ArrayList<>();
            for (Teacher teacher:  teachers) {
                responses.add(viewTeacher(teacher));
            }
            return responses;
        }

}
