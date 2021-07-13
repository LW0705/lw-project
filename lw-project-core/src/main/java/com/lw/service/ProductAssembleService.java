package com.lw.service;

import com.common.service.BaseService;
import com.lw.dao.ProductAssembleDAO;
import com.lw.dto.ProductAssembleDTO;
import com.lw.entity.ProductAssembleDO;
import com.lw.manager.ProductAssembleManager;
import com.lw.query.ProductAssembleQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.service
 * @version: 1.0
 */
public interface ProductAssembleService extends BaseService<ProductAssembleManager, ProductAssembleDTO, ProductAssembleDO, ProductAssembleQuery, ProductAssembleDAO> {
}
