package h04.onetomanyjoins;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RunnerDelete04 {

    /*
     * Note: When we are using sql queries, we wont be able to change our data base types, that's why when we use hibernate,
     * we need to always go for HQL queries
     */

    public static void main(String []args) {

        Books04 bookReader = new Books04();
        Students04 std = new Students04();

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students04.class)
                .addAnnotatedClass(Books04.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        String sqlQuery = "DELETE FROM Books04 ";
//      int numberOfRecordsDeleted = session.createSQLQuery(sqlQuery).executeUpdate();

        String sqlQueryb = "DELETE FROM Student_table ";
//      int numberOfRecordsDeleted= session.createSQLQuery(sqlQueryb).executeUpdate();


        std = session.get(Students04.class, 102);
        session.delete(std);

        tx.commit();

//      System.out.println("Number of Deleted records: "+ numberOfRecordsDeleted);

        //you need to delete specific records for student id 101
    }
}
