package com.barret.ncu.bbs.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "report", schema = "bbs", catalog = "")
public class ReportEntity {
    private int id;
    private int fromUserId;
    private int toTargetId;
    private int targetType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "from_user_id", nullable = false)
    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Basic
    @Column(name = "to_target_id", nullable = false)
    public int getToTargetId() {
        return toTargetId;
    }

    public void setToTargetId(int toTargetId) {
        this.toTargetId = toTargetId;
    }

    @Basic
    @Column(name = "target_type", nullable = false)
    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportEntity that = (ReportEntity) o;
        return id == that.id &&
                fromUserId == that.fromUserId &&
                toTargetId == that.toTargetId &&
                targetType == that.targetType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromUserId, toTargetId, targetType);
    }
}
