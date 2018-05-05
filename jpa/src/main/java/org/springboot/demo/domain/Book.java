package org.springboot.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@EntityListeners(value = {AuditListener.class})
public class Book implements Auditable {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_course_id")
    private StudentCourses studentCourse;

    @Embedded
    private Audit audit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
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