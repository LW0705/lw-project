package com.lw.service;

import com.common.service.BaseService;
import com.lw.dao.ProductClassifyDAO;
import com.lw.dto.ProductClassifyDTO;
import com.lw.entity.ProductClassifyDO;
import com.lw.manager.ProductClassifyManager;
import com.lw.query.ProductClassifyQuery;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.service
 * @version: 1.0
 */
public interface ProductClassifyService extends BaseService<ProductClassifyManager, ProductClassifyDTO, ProductClassifyDO, ProductClassifyQuery, ProductClassifyDAO> {
}
