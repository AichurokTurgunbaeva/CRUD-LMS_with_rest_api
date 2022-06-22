package peaksoft.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)
    private Long id;

    private String courseName;

    private String duration;

    @Transient
    private  Long companyId;

    @ManyToOne
    private Company company;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "courses",cascade = CascadeType.REMOVE)

    private List<Group> groups;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Teacher teacher;

    @CreatedDate
    private LocalDate created;

    public void setGroup(Group group){
        this.groups.add(group);
    }

    public void addGroup(Group group) {
            this.groups.add(group);
        }

    public List<Group> getGroups() {
        return groups;
    }
}

