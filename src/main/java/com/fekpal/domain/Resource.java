package com.fekpal.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resource")
public class Resource extends BasePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private int resourceId;

    private String resource;

    private String description;

    @Column(name = "resource_available")
    private int resourceAvailable;

    @ManyToMany
    private List<Authority> authorityList;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResourceAvailable() {
        return resourceAvailable;
    }

    public void setResourceAvailable(int resourceAvailable) {
        this.resourceAvailable = resourceAvailable;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
