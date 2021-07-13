package com.common.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/25
 * @Description: com.common.dao
 * @version: 1.0
 */
public interface BaseDAO<D,Q> {

    /**
     * 新增
     * @param d
     * @return
     */
    Integer insert(D d);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    Integer delete(@Param("id") Long id);

    /**
     * 更新
     * @param d
     * @return
     */
    Integer update(D d);

    /**
     * 查询
     * @param q
     * @return
     */
    List<D> query(Q q);

    /**
     * 查询条数
     * @param q
     * @return
     */
    Integer queryCount(Q q);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    D queryById(@Param("id") Long id);

}
