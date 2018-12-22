package com.nediiii.ncu.bbs.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post", schema = "bbs", catalog = "")
public class PostEntity {
    private int id;
    private int userId;
    private int sectionId;
    private String title;
    private String content;
    private Timestamp createTime;
    private Timestamp modifiedTime;
    private Byte isRemarkable;
    private Byte isPin;
    private Byte isDeleted;
    private Byte isBlocked;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "section_id", nullable = false)
    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, columnDefinition = "TEXT" ,length = 16777216)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "modified_time", nullable = false)
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Basic
    @Column(name = "is_remarkable", nullable = true)
    public Byte getIsRemarkable() {
        return isRemarkable;
    }

    public void setIsRemarkable(Byte isRemarkable) {
        this.isRemarkable = isRemarkable;
    }

    @Basic
    @Column(name = "is_pin", nullable = true)
    public Byte getIsPin() {
        return isPin;
    }

    public void setIsPin(Byte isPin) {
        this.isPin = isPin;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Basic
    @Column(name = "is_blocked", nullable = true)
    public Byte getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Byte isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return id == that.id &&
                userId == that.userId &&
                sectionId == that.sectionId &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(modifiedTime, that.modifiedTime) &&
                Objects.equals(isRemarkable, that.isRemarkable) &&
                Objects.equals(isPin, that.isPin) &&
                Objects.equals(isDeleted, that.isDeleted) &&
                Objects.equals(isBlocked, that.isBlocked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, sectionId, title, content, createTime, modifiedTime, isRemarkable, isPin, isDeleted, isBlocked);
    }
}
