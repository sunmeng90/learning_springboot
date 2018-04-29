package org.springboot.demo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Audit {

    @Column(name = "effective_from_date")
    private LocalDateTime effectiveFromDate;

    @Column(name = "update_batch_id")
    private int updateBatchId;

    @Column(name = "effective_end_date")
    private LocalDateTime effectiveEndDate;

    @Column(name = "create_batch_id")
    private int createBatchId;

    public LocalDateTime getEffectiveFromDate() {
        return effectiveFromDate;
    }

    public void setEffectiveFromDate(LocalDateTime effectiveFromDate) {
        this.effectiveFromDate = effectiveFromDate;
    }

    public int getUpdateBatchId() {
        return updateBatchId;
    }

    public void setUpdateBatchId(int updateBatchId) {
        this.updateBatchId = updateBatchId;
    }

    public LocalDateTime getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(LocalDateTime effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public int getCreateBatchId() {
        return createBatchId;
    }

    public void setCreateBatchId(int createBatchId) {
        this.createBatchId = createBatchId;
    }
}
