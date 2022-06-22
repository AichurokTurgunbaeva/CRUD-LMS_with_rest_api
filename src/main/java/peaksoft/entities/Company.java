package peaksoft.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")

@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen", sequenceName = "company_seq", allocationSize = 1)
    private Long id;

    private String companyName;

    private String locatedCountry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)

    @ToString.Exclude
    private List<Course> courses=new ArrayList<>();
    @CreatedDate
    private LocalDate created;

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
