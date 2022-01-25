package com.example.hiber.service;

import com.example.hiber.model.entity.Student;
import com.example.hiber.model.repository.AbstractRepository;
import com.example.hiber.model.repository.StudentRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService {

    private final AbstractRepository<Student, Integer> studentRepository;
    private final EntityManager entityManager;

    public StudentService(EntityManager entityManager) {
        this.studentRepository = new StudentRepository(entityManager, Student.class);
        this.entityManager = entityManager;
    }

    public void printTotalCount() {
        System.out.println("Количество записей в БД: " + studentRepository.findAll().size());
    }

    public Student findStudentById(Integer id){
        return studentRepository.findById(id);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public void printAllStudents(){
        System.out.println("Полный список студентов:");
        studentRepository.findAll().forEach(System.out::println);
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudentById(Integer id){
        studentRepository.remove(id);
    }

}