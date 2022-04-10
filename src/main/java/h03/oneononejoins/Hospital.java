package h03.oneononejoins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hospital {
    /*
    Have the following items in Hospital table;
    department_id
    name
    specialist
    Create a new table as Specialist with following items

    specialist_id
    specialty
    grade

    Create onOnOne relation between these two tables
    then set 3 records for them and get all common data from them

    */

    @Id
    @Column(name="department_id")
    private int  id;
    @Column(name="hospital_name")
    private String name;
    @OneToOne(mappedBy = "hospital")
    private Specialist specialist;

    public Hospital(int id, String name, Specialist specialist) {
        this.id = id;
        this.name = name;
        this.specialist = specialist;
    }



    public Hospital() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialist='" + specialist + '\'' +
                '}';
    }
}
