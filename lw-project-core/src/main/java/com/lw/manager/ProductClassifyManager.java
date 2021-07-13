package com.lw.manager;

import com.common.manager.BaseManager;
import com.lw.dao.ProductClassifyDAO;
import com.lw.dto.ProductClassifyDTO;
import com.lw.entity.ProductClassifyDO;
import com.lw.query.ProductClassifyQuery;
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
public class ProductClassifyManager extends BaseManager<ProductClassifyDAO, ProductClassifyDTO, ProductClassifyDO, ProductClassifyQuery> {

    @Autowired
    public ProductClassifyManager(ProductClassifyDAO dao) {
        super(dao, ProductClassifyDTO.class, ProductClassifyDO.class);
    }

    public Integer batchInsert(List<ProductClassifyDO> list){
        return dao.batchInsert(list);
    }
}
