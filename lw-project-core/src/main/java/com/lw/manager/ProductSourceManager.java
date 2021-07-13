package com.lw.manager;

import com.common.manager.BaseManager;
import com.lw.dao.ProductSourceDAO;
import com.lw.dto.ProductSourceDTO;
import com.lw.entity.ProductSourceDO;
import com.lw.query.ProductSourceQuery;
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
public class ProductSourceManager extends BaseManager<ProductSourceDAO, ProductSourceDTO, ProductSourceDO, ProductSourceQuery> {

    @Autowired
    public ProductSourceManager(ProductSourceDAO dao) {
        super(dao, ProductSourceDTO.class, ProductSourceDO.class);
    }

    public Integer batchInsert(List<ProductSourceDO> list){
        return dao.batchInsert(list);
    }
}
