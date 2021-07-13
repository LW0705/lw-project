package com.lw.dao;

import com.common.dao.BaseDAO;
import com.lw.entity.ProductSourceDO;
import com.lw.query.ProductSourceQuery;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.dao
 * @version: 1.0
 */
public interface ProductSourceDAO extends BaseDAO<ProductSourceDO, ProductSourceQuery> {

    /**
     * 批量新增
     *
     * @param list
     * @return
     */
    Integer batchInsert(List<ProductSourceDO> list);
}
