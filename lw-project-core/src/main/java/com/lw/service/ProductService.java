package com.lw.service;

import com.common.service.BaseService;
import com.lw.dao.ProductDAO;
import com.lw.dto.ProductDTO;
import com.lw.entity.ProductDO;
import com.lw.manager.ProductManager;
import com.lw.query.ProductQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/22
 * @Description: com.lw.service
 * @version: 1.0
 */
public interface ProductService extends BaseService<ProductManager,ProductDTO, ProductDO, ProductQuery, ProductDAO> {

    Integer save(ProductDTO dto);

    Integer update(ProductDTO dto);

    Integer insert(ProductDTO dto);
}
