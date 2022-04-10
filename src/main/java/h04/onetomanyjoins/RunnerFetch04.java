package h04.onetomanyjoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {

    public static void main(String[] args) {


        Books04 bRead = new Books04();
        Students04 stdRead = new Students04();

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students04.class)
                .addAnnotatedClass(Books04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        stdRead = session.get(Students04.class, 102);

        bRead = session.get(Books04.class, 10);

        tx.commit();

        List<Books04> bookList = stdRead.getBooksList();

        bookList.forEach(b -> System.out.println("Book : " + b.getBook_name()));

//		System.out.println(stdRead);

        //get the student name, student id, and book name from common records


//        String sqlQuery = "Select std_name, s.std_id, b.book_name "
//                + "FROM students_table s INNER JOIN books_table b "
//                + "ON s.std_id = b.std_id";
//
//
//		List <Object[]> list1 = session.createSQLQuery(sqlQuery).getResultList();
//
//		for(Object[] o : list1) {
//			System.out.println(Arrays.toString(o));
//		}
//
//		for(Object[] o : list1) {
//			for(int i=0; i<o.length;i++) {
//				System.out.println(o[i]);
//			}
//		}

        String hqlQuery = "Select s.name, s.std_id, b.book_name "
                + "FROM Students04 s INNER "
                + "JOIN Books04 b "
                + "ON s.std_id = b.student";

        List<Object[]> listb = session.createQuery(hqlQuery).getResultList();

        for (Object[] o : listb) {

            System.out.println("HQL : " + Arrays.toString(o));
        }
        //Please get all the records from tables printing name, book name, student id and grade
        String sqlQeury = "Select s.student_name, s.std_id, b.book_name, s.grade  "
                + "FROM Student_table s FULL "
                + "JOIN Books04 b "
                + "ON s.std_id = b.std_id";

//		List<Object[]> listc = session.createSQLQuery(sqlQeury).getResultList();
//
//		for(Object[] o : listc) {
//
//			System.out.println(Arrays.toString(o));
//		}
    }

}