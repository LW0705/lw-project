package com.lw.dao;

import com.common.dao.BaseDAO;
import com.lw.entity.ProductClassifyDO;
import com.lw.query.ProductClassifyQuery;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.dao
 * @version: 1.0
 */
public interface ProductClassifyDAO extends BaseDAO<ProductClassifyDO, ProductClassifyQuery> {

    /**
     * 批量新增
     *
     * @param list
     * @return
     */
    Integer batchInsert(List<ProductClassifyDO> list);
}
