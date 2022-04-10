package h02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {


    public static void main(String[] args) {


        Students02 std;


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students02.class);
        SessionFactory sf = con.buildSessionFactory();
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();


        std = s1.get(Students02.class, 101);


        tx.commit();


        System.out.println(std);

    }

}