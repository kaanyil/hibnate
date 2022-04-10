package h01.annotations;

import javax.persistence.*;

/*
 POJO: Plain Old Java Object
 1) Create private instances / variables
 2) Create no args and all args constructors
 3) Create getters and setters
 4) Create toString method
 */

/*
Note: If you will use a class in hibernate to create table in database ,
      do not make any variable "final" or "static"
*/
@Entity //@Entity annotation maps the class to the related table in DB
@Table(name = "students_table")//@Table annotation, we can give a custom name to our table
public class Students01 {

    @Id //we use @id annotation to create primary key on our table
    private int student_id;
    @Column(name = "student_name")//@Column to give custom names to columns
    private String name;
    //@Transient // it will skip this variable, and it will not generate column with this variable.
    private int grade;

    public Students01() {

    }

    public Students01(int id, String name, int grade) {
        super();
        this.student_id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getStudent_id() {
        return student_id;
    }

    public Students01 setStudent_id(int id) {
        this.student_id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Students01 setName(String name) {
        this.name = name;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public Students01 setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        return "Students01: " +
                "id=" + student_id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '.';
    }
}
