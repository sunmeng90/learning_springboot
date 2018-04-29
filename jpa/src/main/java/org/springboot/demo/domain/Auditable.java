package org.springboot.demo.domain;

public interface Auditable {
    Audit getAudit();

    void setAudit(Audit audit);
}
