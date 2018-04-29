package org.springboot.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(value = {AuditListener.class})
public class Course implements Auditable {
    @Id
    @GeneratedValue
    private int id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "course")
    private List<StudentCourses> students;

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

    public List<StudentCourses> getStudents() {
        return students;
    }

    public void setStudents(List<StudentCourses> students) {
        this.students = students;
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
