package peaksoft.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@Getter @Setter
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "teacher_gen", sequenceName = "teacher_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "last_name")
    private String lastName;

    @Transient
    private Long courseId;

    @OneToOne
    @JsonIgnore
    private Course course;

    @CreatedDate
    private LocalDate created;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
