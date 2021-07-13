package com.lw.dao;

import com.common.dao.BaseDAO;
import com.lw.entity.ProductAssembleLogDO;
import com.lw.query.ProductAssembleLogQuery;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.dao
 * @version: 1.0
 */
public interface ProductAssembleLogDAO extends BaseDAO<ProductAssembleLogDO, ProductAssembleLogQuery> {

    /**
     * 批量新增
     *
     * @param list
     * @return
     */
    Integer batchInsert(List<ProductAssembleLogDO> list);
}
