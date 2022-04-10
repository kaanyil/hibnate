package h03.oneononejoins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Students03 {


    @Id
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_name")
    private String name;
    private int grade;
    @OneToOne(mappedBy = "student")
    private Diary diary;

    public Students03() {

    }

    public Students03(int id, String name, int grade, Diary diary) {

        this.id = id;
        this.name = name;
        this.grade = grade;
        this.diary = diary;

    }

    public int getId() {
        return id;
    }

    public Students03 setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Students03 setName(String name) {
        this.name = name;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public Students03 setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public Diary getDairy() {
        return diary;
    }

    public Students03 setDairy(Diary diary) {
        this.diary = diary;
        return this;
    }

    @Override
    public String toString() {
        return "Students03 [id=" + id + ",\n name=" + name + ",\n grade=" + grade + "]";
    }


}