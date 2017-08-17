package com.fekpal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by APone on 2017/8/15.
 * Dao层基类
 */
public class BaseDao<T> {

    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class<T>) params[0];
    }

    public T load(Serializable id) {
        return getHibernateTemplate().load(entityClass, id);
    }

    public T get(Serializable id) {
        return getHibernateTemplate().get(entityClass, id);
    }

    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    public void add(T entity) {
        getHibernateTemplate().save(entity);
    }

    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    public List<T> find(String hql) {
        return (List<T>) this.getHibernateTemplate().find(hql);
    }

    public List<T> find(String hql, Object... params) {
        return (List<T>) this.getHibernateTemplate().find(hql, params);
    }

    public void initialize(Object entity) {
        this.getHibernateTemplate().initialize(entity);
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
