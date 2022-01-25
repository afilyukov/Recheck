package com.example.hiber.model.repository;
import com.example.hiber.model.entity.Student;

import javax.persistence.EntityManager;

public class StudentRepository extends AbstractRepository<Student, Integer>{

    public StudentRepository(EntityManager entityManager, Class<Student> type) {
        super(entityManager, type);
    }
}
