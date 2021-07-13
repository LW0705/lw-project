package com.lw.manager;

import com.common.manager.BaseManager;
import com.lw.dao.ProductAssembleLogDAO;
import com.lw.dto.ProductAssembleLogDTO;
import com.lw.entity.ProductAssembleLogDO;
import com.lw.query.ProductAssembleLogQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.manager
 * @version: 1.0
 */
@Component
public class ProductAssembleLogManager extends BaseManager<ProductAssembleLogDAO, ProductAssembleLogDTO, ProductAssembleLogDO, ProductAssembleLogQuery> {

    public ProductAssembleLogManager(ProductAssembleLogDAO dao) {
        super(dao, ProductAssembleLogDTO.class, ProductAssembleLogDO.class);
    }

    public Integer batchInsert(List<ProductAssembleLogDO> list){
        return dao.batchInsert(list);
    }


}
