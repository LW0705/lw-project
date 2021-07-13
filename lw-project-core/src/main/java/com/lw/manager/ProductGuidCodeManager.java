package com.lw.manager;

import com.lw.dao.ProductGuidCodeDAO;
import com.lw.entity.ProductGuidCodeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.lw.manager
 * @version: 1.0
 */
@Component
public class ProductGuidCodeManager {

    @Autowired
    private ProductGuidCodeDAO dao;

    public Integer insert(ProductGuidCodeDO productGuidCodeDO){
        return dao.insert(productGuidCodeDO);
    }
}
