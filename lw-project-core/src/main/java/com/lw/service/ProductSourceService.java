package com.lw.service;

import com.common.service.BaseService;
import com.lw.dao.ProductSourceDAO;
import com.lw.dto.ProductSourceDTO;
import com.lw.entity.ProductSourceDO;
import com.lw.manager.ProductSourceManager;
import com.lw.query.ProductSourceQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.service
 * @version: 1.0
 */
public interface ProductSourceService extends BaseService<ProductSourceManager, ProductSourceDTO, ProductSourceDO, ProductSourceQuery,ProductSourceDAO> {
}
