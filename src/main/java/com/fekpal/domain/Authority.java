package com.fekpal.domain;

import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority extends BasePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private int authorityId;

    @Column(name = "authority_name")
    private String authorityName;

    @Column(name = "authority_available")
    private int authorityAvailable;

    private String description;

    @ManyToMany
    private List<Role> roleList;

    @ManyToMany
    @JoinTable(name = "authority_resource",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "resource_id"))
    private List<Resource> resourceList;

    public int getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public int getAuthorityAvailable() {
        return authorityAvailable;
    }

    public void setAuthorityAvailable(int authorityAvailable) {
        this.authorityAvailable = authorityAvailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
