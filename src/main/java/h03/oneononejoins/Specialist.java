package h03.oneononejoins;

import javax.persistence.*;

@Entity
@Table(name="specialist")
public class Specialist {

    @Id
    private int id;
    private String specialty;
    private int grade;

    public Specialist(Hospital hospital) {
        this.hospital = hospital;
    }



    @OneToOne
    @JoinColumn(name="department_id")
    private Hospital hospital;

    public Specialist(int id, String specialty, int grade) {
        this.id = id;
        this.specialty = specialty;
        this.grade = grade;
    }

    public Specialist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "id=" + id +
                ", specialty='" + specialty + '\'' +
                ", grade=" + grade +
                '}';
    }
}
