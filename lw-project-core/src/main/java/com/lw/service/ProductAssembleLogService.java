package com.lw.service;

import com.common.service.BaseService;
import com.lw.dao.ProductAssembleLogDAO;
import com.lw.dto.ProductAssembleLogDTO;
import com.lw.entity.ProductAssembleLogDO;
import com.lw.manager.ProductAssembleLogManager;
import com.lw.query.ProductAssembleLogQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.service
 * @version: 1.0
 */
public interface ProductAssembleLogService extends BaseService<ProductAssembleLogManager, ProductAssembleLogDTO, ProductAssembleLogDO, ProductAssembleLogQuery, ProductAssembleLogDAO> {
}
