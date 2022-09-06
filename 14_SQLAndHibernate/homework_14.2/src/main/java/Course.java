import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    private Integer id;
    private String name;
    private Integer duration;
    private CourseType type;
    private String description;
    private Integer teacherId;
    private Integer studentsCount;
    private Integer price;
    private Float pricePerHour;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    public CourseType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Column(name = "teacher_id")
    public Integer getTeacherId() {
        return teacherId;
    }

    @Column(name = "students_count")
    public Integer getStudentsCount() {
        return studentsCount;
    }

    public Integer getPrice() {
        return price;
    }

    @Column(name = "price_per_hour")
    public Float getPricePerHour() {
        return pricePerHour;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPricePerHour(Float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
