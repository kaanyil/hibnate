package h02.embeddable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Students02 {


    @Id
    private int student_id;
    @Column(name="student_name")
    private String name;
    @Column(name = "student_grade")
    private int grade;
    @Embedded
    private Courses02 course;


    public Students02() {
    }

    public Students02(int id, String name, int grade,Courses02 course) {

        this.student_id = id;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }
    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int id) {
        this.student_id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public Courses02 getCourse() {
        return course;
    }
    public void setCourse(Courses02 course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Students02: id=" + student_id + ", name=" + name + ", grade=" + grade + ", course=" + course + ".";
    }










}