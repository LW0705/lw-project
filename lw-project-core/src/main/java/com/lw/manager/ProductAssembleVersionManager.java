package com.lw.manager;

import com.common.manager.BaseManager;
import com.lw.dao.ProductAssembleVersionDAO;
import com.lw.dto.ProductAssembleVersionDTO;
import com.lw.entity.ProductAssembleVersionDO;
import com.lw.query.ProductAssembleVersionQuery;
import org.springframework.stereotype.Component;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.manager
 * @version: 1.0
 */
@Component
public class ProductAssembleVersionManager extends BaseManager<ProductAssembleVersionDAO, ProductAssembleVersionDTO,ProductAssembleVersionDO, ProductAssembleVersionQuery> {

    public ProductAssembleVersionManager(ProductAssembleVersionDAO dao) {
        super(dao, ProductAssembleVersionDTO.class, ProductAssembleVersionDO.class);
    }

    public String getMaxDataVersion(String productGuid){
        return dao.getMaxDataVersion(productGuid);
    }
}
