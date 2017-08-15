package com.fekpal.domain;

import javax.persistence.*;

@Entity
@Table(name = "major")
public class Major extends BasePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private int majorId;

    @Column(name = "major_name")
    private String majorName;

    @ManyToOne(optional = false)
    private Department department;

    @Column(name = "major_available")
    private int majorAvailable;

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getMajorAvailable() {
        return majorAvailable;
    }

    public void setMajorAvailable(int majorAvailable) {
        this.majorAvailable = majorAvailable;
    }
}
