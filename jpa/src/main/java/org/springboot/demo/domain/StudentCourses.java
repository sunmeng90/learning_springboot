package org.springboot.demo.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@EntityListeners(value = {AuditListener.class})
public class StudentCourses implements Auditable {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column
    private String credits;

    @OneToMany(mappedBy = "studentCourse", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    @Embedded
    private Audit audit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (book != null) {
            this.getBooks().add(book);
            if (book.getStudentCourse() != this) {
                book.setStudentCourse(this);
            }
        }
    }

    public void removeBook(Book book) {
        for (Iterator<Book> iterator = books.iterator(); iterator.hasNext(); ) {
            Book curBook = iterator.next();
            if (curBook.equals(book) && book.getStudentCourse().equals(this)) {
//                book.setStudentCourse(null);
                iterator.remove();
            }
        }
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourses that = (StudentCourses) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course) &&
                Objects.equals(credits, that.credits);
    }

    @Override
    public int hashCode() {

        return Objects.hash(student, course, credits);
    }
}