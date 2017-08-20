package com.fekpal.domain;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Role extends BasePOJO {

    private int roleId;

    private String roleName;

    private int roleAvailable;

    private List<Authority> authorityList;

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleAvailable() {
        return roleAvailable;
    }

    public void setRoleAvailable(int roleAvailable) {
        this.roleAvailable = roleAvailable;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
