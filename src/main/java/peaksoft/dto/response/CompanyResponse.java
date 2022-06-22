package peaksoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Course;
import java.time.LocalDate;
import java.util.List;
@Getter @Setter
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private List<Course> courses;
    private LocalDate created;
}
