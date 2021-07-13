package com.lw.dao;

import com.lw.entity.ProductCodeDO;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.dao
 * @version: 1.0
 *
 * 产品编码表
 */
public interface ProductCodeDAO {

    /**
     * 获取当前可用编码
     *
     * @return
     */
    ProductCodeDO getCode();

    /**
     * 更新产品编码
     * @param productCodeDO
     * @return
     */
    Integer update(ProductCodeDO productCodeDO);
}
