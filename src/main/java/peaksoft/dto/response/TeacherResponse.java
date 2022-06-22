package peaksoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private String courseName;
    private LocalDate created;
}
