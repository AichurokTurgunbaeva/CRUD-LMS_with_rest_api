package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

@Getter
@Setter
public class StudentRequest {

    private String firstName;
    private String email;
    private String lastName;
    private StudyFormat studyFormat;
    private Long groupId;

}


