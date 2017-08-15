package com.fekpal.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department extends BasePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_available")
    private int departmentAvailable;

    @OneToMany(mappedBy = "department")
    private List<Major> majorList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentAvailable() {
        return departmentAvailable;
    }

    public void setDepartmentAvailable(int departmentAvailable) {
        this.departmentAvailable = departmentAvailable;
    }

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<Major> majorList) {
        this.majorList = majorList;
    }
}
