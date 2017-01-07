package com.cc.oa.base;

import java.util.List;

/**
 * Created by 滴水藏海 on 2016/12/6.
 */
public interface BaseDao<T> {

    /**
     * 保存
     *
     * @param t
     */
    void save(T t);

    /**
     * 根据id删除实体
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新实体
     *
     * @param t
     */
    void update(T t);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 根据id查询多个
     *
     * @param ids
     * @return
     */
    List<T> getByIds(Long[] ids);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();
}
