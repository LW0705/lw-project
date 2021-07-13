package com.lw.service;

import com.common.service.BaseService;
import com.lw.dao.ProductAssembleVersionDAO;
import com.lw.dto.ProductAssembleVersionDTO;
import com.lw.entity.ProductAssembleVersionDO;
import com.lw.manager.ProductAssembleVersionManager;
import com.lw.query.ProductAssembleVersionQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.service
 * @version: 1.0
 */
public interface ProductAssembleVersionService extends BaseService<ProductAssembleVersionManager, ProductAssembleVersionDTO, ProductAssembleVersionDO, ProductAssembleVersionQuery, ProductAssembleVersionDAO> {
}
