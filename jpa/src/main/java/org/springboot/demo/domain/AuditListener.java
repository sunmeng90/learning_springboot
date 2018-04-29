package org.springboot.demo.domain;


import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {
    private static LocalDateTime YEAR_9999 = LocalDateTime.of(9999, 12, 31, 0, 0);

    @PrePersist
    public void setupOnCreate(Auditable auditable) {
        Audit audit = auditable.getAudit();
        if (audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }
        audit.setEffectiveFromDate(LocalDateTime.now());
        audit.setEffectiveEndDate(YEAR_9999);
    }

    @PreUpdate
    public void setupOnUpdate(Auditable auditable) {
        Audit audit = auditable.getAudit();
        if (audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }
        audit.setEffectiveEndDate(LocalDateTime.now());
    }


}
