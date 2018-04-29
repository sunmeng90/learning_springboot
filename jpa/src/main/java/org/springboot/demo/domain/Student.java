package org.springboot.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(value = {AuditListener.class})
public class Student implements Auditable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    @Convert(converter = LocalDateConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;


    @OneToMany(mappedBy = "student")
    private List<StudentCourses> courses = new ArrayList<>();

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<StudentCourses> getCourses() {
        return courses;
    }

    public void setCourses(List<StudentCourses> courses) {
        this.courses = courses;
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}
