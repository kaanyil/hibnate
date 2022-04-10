package h04.onetomanyjoins;
import javax.persistence.*;

@Entity
@Table(name ="books_table")
public class Books04 {
    @Id
    private int book_id;
    private String book_name;
    @ManyToOne
    @JoinColumn(name="std_id")
    private Students04 student;


    public Books04() {

    }
    public Books04(int book_id, String book_name) {
        this.book_id = book_id;
        this.book_name = book_name;
    }
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public Students04 getStudent() {
        return student;
    }
    public void setStudent(Students04 student) {
        this.student = student;
    }
    @Override
    public String toString() {
        return "Books04 [book_id=" + book_id + ", book_name=" + book_name + "]";
    }











}
