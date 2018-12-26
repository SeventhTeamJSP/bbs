package com.nediiii.ncu.bbs.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "favorite", schema = "bbs")
public class FavoriteEntity {
    private int id;
    private int fromUserId;
    private int toPostId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "to_post_id", nullable = false)
    public int getToPostId() {
        return toPostId;
    }

    public void setToPostId(int toPostId) {
        this.toPostId = toPostId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteEntity that = (FavoriteEntity) o;
        return id == that.id &&
                fromUserId == that.fromUserId &&
                toPostId == that.toPostId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromUserId, toPostId);
    }
}
