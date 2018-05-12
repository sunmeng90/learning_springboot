package org.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(value = {AuditListener.class})
public class Course extends BaseEntity {

    @Basic
    private String name;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<StudentCourses> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentCourses> getStudents() {
        return students;
    }

    public void setStudents(List<StudentCourses> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
