package peaksoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

import java.time.LocalDate;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private StudyFormat studyFormat;
    private String groupName;
    private LocalDate created;

}

