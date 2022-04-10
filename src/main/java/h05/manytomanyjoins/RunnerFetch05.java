package h05.manytomanyjoins;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RunnerFetch05 {
    public static void main(String[] args) {
        Book05 book = new Book05();
        Student05 std = new Student05();
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(Book05.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//      std = session.get(Student05.class, 102);
//
//      System.out.println(std);

//      book = session.get(Book05.class, 11);
//
//      System.out.println(book.getStudentList());

        //Just fetch the data from Book class where book name is Art Book
        String hqlQuery3 = "FROM Book05 where book_name = 'Art Book'";
//      List<Object> rl3 = session.createQuery(hqlQuery3).getResultList();
//      Book05 rl4 = (Book05)session.createQuery(hqlQuery3).getSingleResult();
//      System.out.println(rl4);
//
//      String hqlQuery4 = "Select s.name FROM Student05 s";
//
//      List<Student05 > rl5 = session.createQuery(hqlQuery4).getResultList();
//
//      System.out.println(rl5);

//      String hqlQuery = "Select b.book_name FROM Book05 b";
//
//      List<String> rl6 = session.createQuery(hqlQuery).list();
//      System.out.println(rl6);


        //fetch all book names that have book id as 11
//      String hqlQuery7 = "SELECT b.book_name FROM Book05 b where b.book_id = 11";
//      Object rl7 = session.createQuery(hqlQuery7).getSingleResult();
//
//      System.out.println(rl7);

        //Fetch the student name, book id where student id = 101

        String hqlQuery8 = "SELECT s.name, b.book_name FROM Student05 s INNER JOIN Book05 b ON s.std_id = 102";

        List<Object[]> rl8 = session.createQuery(hqlQuery8).getResultList();

        for(Object[] o: rl8) {

            System.out.println(Arrays.toString(o));

        }

        tx.commit();
    }
}