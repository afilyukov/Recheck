package ru.afilyukov.task7spring.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.afilyukov.task7spring.model.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}