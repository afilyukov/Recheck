package com.example.hiber.model.entity;
import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "student_id")
        private Integer id;

        @Column(name = "student_name")
        private String name;

        @Column(name = "student_mark")
        private int mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }


    public Student() {}

    public Student(Integer id, String name, int mark) {
            this.id = id;
            this.name = name;
            this.mark = mark;
        }

    public Student(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }

        @Override
        public String toString() {
            return "Student {id= " + id + ", name= " + name + ", mark= " + mark + "}";
        }
    }
