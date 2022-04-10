package h03.oneononejoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class RunnerSave03 {

    public static void main(String[] args) {

        Diary d1= new Diary(11, "First Diary");
        Diary d2= new Diary(12, "Second Diary");
        Diary d3= new Diary(13, "Third Diary");

        //List<String> list = new ArrayList<>();
        
        Students03 std1 = new Students03(101,"Ali Can", 11, d1);
        Students03 std2 = new Students03(102,"Veli Han", 11, d2);
        Students03 std3 = new Students03(103,"Ayse Tan", 11, d3);

        d1.setStudent(std1);
        d2.setStudent(std2);
        //d3.setStudent(std3);


        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students03.class)
                .addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();

        s1.save(d1);
        s1.save(d2);
        s1.save(d3);

        s1.save(std1);
        s1.save(std2);
        s1.save(std3);


        tx.commit();



    }
}
