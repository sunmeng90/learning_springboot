package org.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book extends BaseEntity {
    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_course_id")
    @JsonBackReference
    private StudentCourses studentCourse;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentCourses getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentCourses studentCourse) {
        this.studentCourse = studentCourse;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}