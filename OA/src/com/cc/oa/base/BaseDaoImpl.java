package com.cc.oa.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

/**
 * Created by 滴水藏海 on 2016/12/6.
 */
@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource
    private SessionFactory sessionFactory;

    private Class<T> clazz;

	public BaseDaoImpl() {
        // 通过反射得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class) pt.getActualTypeArguments()[0];

    }

    @Override
    public void save(T t) {

        getSession().save(t);
    }

    @Override
    public void delete(Long id) {

        Object o = getSession().get(clazz, id);
        getSession().delete(o);
    }

    @Override
    public void update(T t) {

        getSession().update(t);
    }

    @Override
    public T getById(Long id) {
        return (T) getSession().get(clazz, id);
    }

    @Override
    public List<T> getByIds(Long[] ids) {

        if (ids == null || ids.length == 0) {
            return Collections.emptyList();
        }
        String sql = "FROM " + clazz.getSimpleName() + " WHERE ID IN (:IDS)";
        return getSession().createQuery(sql).setParameterList("IDS", ids).list();
    }

    @Override
    public List<T> findAll() {
        String sql = "FROM " + clazz.getSimpleName();
        return getSession().createQuery(sql).list();
    }

    /**
     * 获取当前线程的session
     *
     * @return 当前线程的session
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
