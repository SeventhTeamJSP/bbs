package com.barret.ncu.bbs.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "bbs", catalog = "")
public class UserEntity {
    private int id;
    private String name;
    private String password;
    private String nickname;
    private String avatar;
    private String email;
    private String mobile;
    private String profession;
    private String workAddress;
    private Integer gender;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 30)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 255)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "profession", nullable = true, length = 255)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Basic
    @Column(name = "work_address", nullable = true, length = 255)
    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(email, that.email) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(profession, that.profession) &&
                Objects.equals(workAddress, that.workAddress) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, nickname, avatar, email, mobile, profession, workAddress, gender);
    }
}
