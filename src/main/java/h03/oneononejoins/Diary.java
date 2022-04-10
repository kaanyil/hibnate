package h03.oneononejoins;
import javax.persistence.*;

@Entity
public class Diary {

    @Id
    private int id;
    private String diary;
    @OneToOne
    @JoinColumn(name="student_id")
    private Students03 student;

    public Diary() {

    }

    public Diary(int id, String dairy) {
        this.id = id;
        this.diary = dairy;
    }

    public Students03 getStudent() {
        return student;
    }

    public void setStudent(Students03 student) {
        this.student = student;
    }


    public int getId() {
        return id;
    }

    public Diary setId(int id) {
        this.id = id;
        return this;
    }

    public String getDiary() {
        return diary;
    }

    public Diary setDiary(String diary) {
        this.diary = diary;
        return this;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", diary='" + diary + '\'' +
                ", student=" + student +
                '}';
    }
}
