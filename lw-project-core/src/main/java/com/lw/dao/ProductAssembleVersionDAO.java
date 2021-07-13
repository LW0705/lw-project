package com.lw.dao;

import com.common.dao.BaseDAO;
import com.lw.entity.ProductAssembleVersionDO;
import com.lw.query.ProductAssembleVersionQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.dao
 * @version: 1.0
 */
public interface ProductAssembleVersionDAO extends BaseDAO<ProductAssembleVersionDO, ProductAssembleVersionQuery> {

    /**
     * 查询guid对应最大的版本号
     * @param productGuid
     * @return
     */
    String getMaxDataVersion(String productGuid);
}
