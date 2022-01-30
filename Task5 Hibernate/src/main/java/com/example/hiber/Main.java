package com.example.hiber;

import com.example.hiber.model.entity.Student;
import com.example.hiber.service.StudentService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "hiber_demo" );
        EntityManager entityManager = emf.createEntityManager();
        StudentService ss = new StudentService(entityManager);
        prepare(ss);

        ss.printTotalCount();

        System.out.println("Удаляем запись 345");
        ss.deleteStudentById(345);
        ss.printTotalCount();

        System.out.println("Добавляем запись my student");
        ss.addStudent(new Student("My Student", 5));
        ss.printTotalCount();

        System.out.println("Выводим студента 1001");
        System.out.println(ss.findStudentById(1001));
    }

    public static void prepare(StudentService ss) {
        for (int i = 1; i <= 1000; i++) {
            ss.addStudent(new Student("Student_" + "0".repeat(4 - Integer.toString(i).length()) + i, (int) (Math.random() * 10)));
        }
    }
}
