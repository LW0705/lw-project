package com.lw.dao;

import com.common.dao.BaseDAO;
import com.lw.entity.ProductAssembleDO;
import com.lw.query.ProductAssembleQuery;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.dao
 * @version: 1.0
 */
public interface ProductAssembleDAO extends BaseDAO<ProductAssembleDO, ProductAssembleQuery> {

    /**
     * 批量新增
     *
     * @param list
     * @return
     */
    Integer batchInsert(List<ProductAssembleDO> list);

}
