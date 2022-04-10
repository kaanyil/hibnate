package h04.onetomanyjoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave04 {

//    In OneToMany relationship, parent class can have multiple children,
//    but child class can not have multiple parents.

    public static void main(String[] args) {

        Books04 b1 = new Books04(11, "Math Book");
        Books04 b2 = new Books04(12, "Science Book");
        Books04 b3 = new Books04(13, "Java Book");
        Books04 b4 = new Books04(14, "Art Book");

        List<Books04> books1 = new ArrayList();
        books1.add(b1);
        books1.add(b2);

        Students04 std1 = new Students04(101, "Ali Can", 10, books1);
/*
    Note: In OneToMany relationship, parent class can have multiple children but Child class cannot have multiple parents.
    So, a student can have multiple books, but a book cannot have multiple student owners.
    If you try to add multiple owner for a book, hibernate does not give any error, it just accepts last parent
    as valid parent.
 */
        Students04 std2 = new Students04(102, "Veli Han", 9);

//        std2.getBooksList().add(b2);
        std2.getBooksList().add(b3);
        std2.getBooksList().add(b4);
        std2.setBooksList(std2.getBooksList());

        b1.setStudent(std1);
        b2.setStudent(std1);

//        b2.setStudent(std2);
        b3.setStudent(std2);
        b4.setStudent(std2);


        Students04 std3 = new Students04(103, "Ayse Tan", 8);


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students04.class)
                .addAnnotatedClass(Books04.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(b1);
        session.save(b2);
        session.save(b3);
        session.save(b4);

        session.save(std1);
        session.save(std2);
        session.save(std3);

        tx.commit();


    }
}