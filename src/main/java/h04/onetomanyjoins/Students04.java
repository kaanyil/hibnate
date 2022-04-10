package h04.onetomanyjoins;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Students04 {

    @Id
    private int std_id;

    private String name;
    private int grade;
    @OneToMany(mappedBy="student", orphanRemoval = true, cascade = CascadeType.ALL)
   //When we use orphanRemoval it is to indicate that we want to delete all related records to our child table
    //When we use CascadeType.ALL we are executing our approval to delete child records
    private List<Books04> booksList = new ArrayList();


    public Students04() {

    }
    public Students04(int std_id, String name, int grade) {

        this.std_id = std_id;
        this.name = name;
        this.grade = grade;
    }
    public Students04(int std_id, String name, int grade, List<Books04> booksList) {
        super();
        this.std_id = std_id;
        this.name = name;
        this.grade = grade;
        this.booksList = booksList;
    }



    public int getStd_id() {
        return std_id;
    }
    public void setStd_id(int std_id) {
        this.std_id = std_id;
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


    public List<Books04> getBooksList() {
        return booksList;
    }
    public void setBooksList(List<Books04> bookList) {
        this.booksList = bookList;
    }
    @Override
    public String toString() {
        return "Students04 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", bookList=" + booksList + "]";
    }


}


