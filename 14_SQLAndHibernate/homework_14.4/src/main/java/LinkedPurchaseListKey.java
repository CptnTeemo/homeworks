import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinkedPurchaseListKey implements Serializable {

    private Integer studentId;
    private Integer courseId;

    public LinkedPurchaseListKey() {
    }

    public LinkedPurchaseListKey(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Column(name = "student_id", insertable = false, updatable = false)
    public Integer getStudentId() {
        return studentId;
    }

    @Column(name = "course_id", insertable = false, updatable = false)
    public Integer getCourseId() {
        return courseId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseListKey that = (LinkedPurchaseListKey) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
