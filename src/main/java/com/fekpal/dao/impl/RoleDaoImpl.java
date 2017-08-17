package com.fekpal.dao.impl;

import com.fekpal.domain.Role;

/**
 * Created by APone on 2017/8/17.
 * RoleDao层接口,暂时不存在权限和资源的接口
 * 现在只获取结果集，还未有增删改功能
 */
public interface RoleDaoImpl {

    Role getRoleByAuthorityId(int authorityId);
}
