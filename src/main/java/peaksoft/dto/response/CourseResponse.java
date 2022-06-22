package peaksoft.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Company;
import peaksoft.entities.Group;
import peaksoft.entities.Teacher;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String courseName;
    private String duration;

    private String companyName;

    private List<Group> groups;

    private Teacher teacher;

    private LocalDate created;
}
