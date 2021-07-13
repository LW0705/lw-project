package com.lw.manager;

import com.common.manager.BaseManager;
import com.lw.dao.ProductDAO;
import com.lw.dto.ProductDTO;
import com.lw.entity.ProductDO;
import com.lw.query.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/28
 * @Description: com.lw.manager
 * @version: 1.0
 */
@Component
public class ProductManager extends BaseManager<ProductDAO, ProductDTO, ProductDO, ProductQuery> {

//    @Autowired
    public ProductManager(ProductDAO dao) {
        super(dao, ProductDTO.class,ProductDO.class);
    }

    public ProductDO checkExists(ProductQuery query){
        return dao.checkExists(query);
    }




}
