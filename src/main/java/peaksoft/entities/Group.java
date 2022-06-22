package peaksoft.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="groups")
@Getter @Setter
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_gen", sequenceName = "group_seq", allocationSize = 1)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    @Transient
    private List<Long> coursesId;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courses=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student>students=new ArrayList<>();

    @CreatedDate
    private LocalDate created;


    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
