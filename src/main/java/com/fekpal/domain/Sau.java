package com.fekpal.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sau_info")
public class Sau extends BasePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sau_id")
    private int sauId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "sau_name")
    private String sauName;

    @Column(name = "found_time")
    private Timestamp foundTime;

    private String description;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "sau_logo")
    private String sauLogo;

    private int members;

    public int getSauId() {
        return sauId;
    }

    public void setSauId(int sauId) {
        this.sauId = sauId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSauName() {
        return sauName;
    }

    public void setSauName(String sauName) {
        this.sauName = sauName;
    }

    public Timestamp getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Timestamp foundTime) {
        this.foundTime = foundTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getSauLogo() {
        return sauLogo;
    }

    public void setSauLogo(String sauLogo) {
        this.sauLogo = sauLogo;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }
}
