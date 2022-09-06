import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "students")
public class Students {

    private Integer id;
    private String name;
    private Integer age;
    private LocalDateTime registrationDate;
    private List<Course> courses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Column(name = "registration_date")
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    @ManyToMany(mappedBy = "studentsList")
    public List<Course> getCourses() {
        return courses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                '}';
    }
}