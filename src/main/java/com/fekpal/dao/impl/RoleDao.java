package com.fekpal.dao.impl;

import com.fekpal.dao.BaseDao;
import com.fekpal.domain.Role;

import java.util.List;

/**
 * Created by APone on 2017/8/17.
 */
public class RoleDao extends BaseDao<Role> implements RoleDaoImpl {

    /**
     * 根据用户角色id获得相应的权限资源
     *
     * @param roleId int
     * @return Role
     */
    @Override
    public Role getRoleByAuthorityId(int roleId) {
        String hql = "from Role r where r.roleId = ?";
        List<Role> roleList = find(hql, roleId);
        return roleList.get(0);
    }
}
