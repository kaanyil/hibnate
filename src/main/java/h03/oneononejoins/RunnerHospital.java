package h03.oneononejoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerHospital {
    public static void main(String[] args) {

        Specialist specialist1 = new Specialist(10,"Neurology",8);
        Specialist specialist2 = new Specialist(11,"Cardiology",8);
        Specialist specialist3 = new Specialist(12,"Neurology",8);

        Hospital hospital1 = new Hospital(101,"NorthWestern",specialist1);
        Hospital hospital2 = new Hospital(102,"Weiss",specialist2);
        Hospital hospital3 = new Hospital(103,"St. Francis",specialist3);

        specialist1.setHospital(hospital1);
        specialist2.setHospital(hospital2);
        specialist3.setHospital(hospital3);


        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Specialist.class)
                .addAnnotatedClass(Hospital.class);

        SessionFactory sf = con.buildSessionFactory();
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();

        s1.save(specialist1);
        s1.save(specialist2);
        s1.save(specialist3);
        s1.save(hospital1);
        s1.save(hospital2);
        s1.save(hospital3);



        tx.commit();
    }
}
