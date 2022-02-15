package ru.afilyukov.task7spring.conrollers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.afilyukov.task7spring.models.Student;
import ru.afilyukov.task7spring.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")  //just for example
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> showAll() {
        return studentService.showAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveNewStudent(@RequestBody Student student) {
        student.setId(null);
        return studentService.saveOrUpdate(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

}