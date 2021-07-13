package com.lw.dao;

import com.common.dao.BaseDAO;
import com.lw.entity.ProductDO;
import com.lw.query.ProductQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/24
 * @Description: com.lw.dao
 * @version: 1.0
 */
public interface ProductDAO extends BaseDAO<ProductDO, ProductQuery> {

    ProductDO checkExists(ProductQuery query);

}

