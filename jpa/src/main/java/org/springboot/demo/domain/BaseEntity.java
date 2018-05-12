package org.springboot.demo.domain;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(value = {AuditListener.class})
public class BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "hibernate_sequence", allocationSize = 50)
    private int id;

    @Embedded
    private Audit audit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
