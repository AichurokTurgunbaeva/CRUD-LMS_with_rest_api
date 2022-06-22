package peaksoft.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Course;

import java.util.List;

@Getter
@Setter
public class GroupRequest {
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private List<Long> coursesID;
    @JsonIgnore
    private List<Course> courses;

}

