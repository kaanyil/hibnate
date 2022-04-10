package h03.oneononejoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetchHospital {


    public static void main(String[] args) {
        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();



        tx.commit();

//        String sqlQuery="SELECT h.department_id, h.hospital_name, s.id, s.specialty, s.grade " +
//                "FROM Hospital h INNER JOIN Specialist s ON h.department_id = s.department_id";
//
//        List<Object []> list = s1.createSQLQuery(sqlQuery).getResultList();
//        list.forEach(n -> System.out.println(Arrays.toString(n)));

        String hqlQuery = "SELECT h.id, h.name, s.id, s.specialty, s.grade FROM Hospital h INNER JOIN Specialist s ON h.id = s.hospital";
        List<Object []> list = s1.createQuery(hqlQuery).getResultList();
        list.forEach(n -> System.out.println(Arrays.toString(n)));
    }
}
