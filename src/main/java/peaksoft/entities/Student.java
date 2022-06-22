package peaksoft.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import peaksoft.enums.StudyFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.MERGE;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "study_format")
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {MERGE})
    @JsonIgnore
    private Group group;

    @Transient
    private Long groupId;

    @CreatedDate
    private LocalDate created;


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
