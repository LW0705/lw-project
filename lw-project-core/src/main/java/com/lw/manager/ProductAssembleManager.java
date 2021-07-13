package com.lw.manager;

import com.common.manager.BaseManager;
import com.lw.dao.ProductAssembleDAO;
import com.lw.dto.ProductAssembleDTO;
import com.lw.entity.ProductAssembleDO;
import com.lw.query.ProductAssembleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.manager
 * @version: 1.0
 */
@Component
public class ProductAssembleManager extends BaseManager<ProductAssembleDAO, ProductAssembleDTO, ProductAssembleDO, ProductAssembleQuery> {

    @Autowired
    public ProductAssembleManager(ProductAssembleDAO dao) {
        super(dao, ProductAssembleDTO.class, ProductAssembleDO.class);
    }

    public Integer batchInsert(List<ProductAssembleDO> list){
        return dao.batchInsert(list);
    }
}
