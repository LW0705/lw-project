package com.lw.manager;

import com.lw.dao.ProductCodeDAO;
import com.lw.entity.ProductCodeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.manager
 * @version: 1.0
 */
@Component
public class ProductCodeManager {

    @Autowired
    private ProductCodeDAO productCodeDAO;

    public ProductCodeDO getCode(){
        return productCodeDAO.getCode();
    }

    public Integer update(ProductCodeDO productCodeDO){
        return productCodeDAO.update(productCodeDO);
    }
}
