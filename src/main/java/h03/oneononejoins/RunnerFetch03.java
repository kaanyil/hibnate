package h03.oneononejoins;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {

    public static void main(String[]args) {

        Diary dRead  =new Diary();
        Students03 stdRead = new Students03();


        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students03.class)
                .addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session s = sf.openSession();

        Transaction tx  = s.beginTransaction();

        // get method works with primary key
		//dRead = s.get(Diary.class, 11);
		//stdRead = s.get(Students03.class, 101);
        //dRead = s.get(Diary.class, 102);





		//System.out.println(dRead);
        //Get student name, dairy, grade and id from both tables
        //Note: When we use SQL query, we need to use table column names
//		String sqlQuery = "SELECT s.student_name, d.diary, s.grade ,s.student_id "
//				+ "FROM Students03 s INNER "
//				+ "JOIN Diary d "
//				+ "ON s.student_id = d.student_id";
//
//		List<Object[]> list = s.createSQLQuery(sqlQuery).getResultList();
//
//        list.forEach(l -> System.out.println(Arrays.toString(l)));

        //2. way with HQL Query
        //When we work with HQL queries, we need to specify Object(Class names and variables) names rather than table column names
//		String hqlQuery = "SELECT s.name, d.diary, s.grade ,s.id "
//				        + "FROM Students03 s INNER "
//                        + "JOIN Diary d "
//                        + "ON s.id = d.student";
//
//		List<Object[]> list2 = s.createQuery(hqlQuery).getResultList();
//        list2.forEach(l -> System.out.println(Arrays.toString(l)));





        //Fetch all the records getting name, id, grade, dairy, we need to use sql query and HQL query
//		String sqlQuery2 = "SELECT s.student_name, s.student_id, s.grade, d.diary FROM Students03 s FULL "
//				+ "JOIN Diary d "
//				+ "ON s.student_id = d.student_id";

//        String sqlQuery2 = "SELECT s.student_name, s.student_id, s.grade, d.diary FROM Students03 s LEFT "
//                + "JOIN Diary d "
//                + "ON s.student_id = d.student_id";
//
//
//        List< Object[]> lista = s.createSQLQuery(sqlQuery2).getResultList();
//        lista.forEach(l -> System.out.println(Arrays.toString(l)));




//
//		String hqlQuery ="SELECT s.name, s.id, s.grade, d.dairy FROM Student03 s FULL JOIN Dairy d ON s.id = d.student";
//		String hqlQuery ="SELECT s.name, s.id, s.grade, d.diary FROM Students03 s LEFT JOIN Diary d ON s.id = d.student";
//
//		List<Object[]> listb = s.createQuery(hqlQuery).getResultList();
//
//        listb.forEach(l -> System.out.println(Arrays.toString(l)));

        //Fetch student name, diary name and student grade of records from Diary table

//        String sqlQuery = "SELECT s.student_name, d.diary, s.grade FROM Students03 s RIGHT JOIN Diary d ON  s.student_id = d.student_id ";
//        String hqlQuery = "SELECT   s.name, d.diary,s.grade FROM Students03 s RIGHT JOIN Diary d ON  s.id= d.student";
//        List<Object[]> listc = s.createSQLQuery(sqlQuery).getResultList();
//        List<Object[]> listd = s.createQuery(hqlQuery).getResultList();

//        listd.forEach(l -> System.out.println(Arrays.toString(l)));

//      Fetch student name, diary name and student grade of all records from Student03 and Diary table
//        String sqlQuery = "SELECT s.student_name, d.diary, s.grade FROM Students03 s FULL JOIN Diary d ON  s.student_id = d.student_id ";
//        String hqlQuery = "SELECT   s.name, d.diary,s.grade FROM Students03 s FULL JOIN Diary d ON  s.id= d.student";
//        List<Object[]> listc = s.createSQLQuery(sqlQuery).getResultList();
//        List<Object[]> listd = s.createQuery(hqlQuery).getResultList();
//
//        listc.forEach(l -> System.out.println(Arrays.toString(l)));
//        listd.forEach(l -> System.out.println(Arrays.toString(l)));


        //Fetch All the records for Students and Dairy Table (first use SQL Then use HQL)
        //When you are trying fetch all data with SQL, you cannot use * because it will get confused
        //But you need to specify all column names
//		String sqlQueryc = "SELECT * FROM Students03 s INNER JOIN Diary d ON s.student_id = d.student_id";
//
//		List<Object[]> listc = s.createSQLQuery(sqlQueryc).getResultList();
//        listc.forEach(l -> System.out.println(Arrays.toString(l)));


// In HQL, if you wanna get all data about records you can't use "SELECT *", you need to start with "FROM"
//        String hqlQuery ="FROM Students03 s INNER JOIN Diary d ON s.id = d.student";
//
//        List<Object[]> listd = s.createQuery(hqlQuery).getResultList();
//
//        listd.forEach(l -> System.out.println(Arrays.toString(l)));

        String hqlQuery ="FROM Students03 s FULL JOIN Diary d ON s.id = d.student";

        List<Object[]> listd = s.createQuery(hqlQuery).getResultList();

        listd.forEach(l -> System.out.println(Arrays.toString(l)));


        tx.commit();

    }
        }



