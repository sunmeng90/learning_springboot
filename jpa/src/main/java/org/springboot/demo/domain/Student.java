package org.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@EntityListeners(value = {AuditListener.class})
public class Student extends BaseEntity {

    @Column
    private String name;

    @Column
    @Convert(converter = LocalDateConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;


    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<StudentCourses> courses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<StudentCourses> getCourses() {
        return courses;
    }

    public void addCourse(Course course, String credit, Set<Book> books) {
        StudentCourses studentCourses = new StudentCourses();
        studentCourses.setStudent(this);
        studentCourses.setCourse(course);
        studentCourses.setCredits(credit);
        studentCourses.setBooks(books);
        this.getCourses().add(studentCourses);
    }

    public void removeCourse(Course course) {
        for (Iterator<StudentCourses> studentCoursesIterator = courses.iterator(); studentCoursesIterator.hasNext(); ) {
            StudentCourses studentCourse = studentCoursesIterator.next();
            if (studentCourse.getStudent().equals(this) && studentCourse.getCourse().equals(course)) {
                studentCoursesIterator.remove();
                studentCourse.getCourse().getStudents().remove(studentCourse);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, birthday);
    }
}


