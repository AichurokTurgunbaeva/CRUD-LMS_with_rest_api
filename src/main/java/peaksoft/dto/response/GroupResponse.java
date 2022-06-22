package peaksoft.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Course;
import peaksoft.entities.Student;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GroupResponse {
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private List<String> coursesNames;
    private List<Student> students;
    private LocalDate created;

    @JsonIgnore
    private List<Course> courses;
}
