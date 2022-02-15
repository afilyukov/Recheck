package ru.afilyukov.task7spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.afilyukov.task7spring.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}