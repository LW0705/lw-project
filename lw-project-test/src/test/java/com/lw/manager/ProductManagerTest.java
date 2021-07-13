package com.lw.manager;

import com.lw.AppConfig;
import com.lw.entity.ProductDO;
import com.lw.manager.ProductManager;
import com.lw.query.ProductQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.lw
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class})
public class ProductManagerTest {

    @Autowired
    private ProductManager productManager;

    @Test
    public void insert(){
        ProductDO productDO=new ProductDO();
        productDO.setProductName("测试002");
        productDO.setProductGuid("002");
        productDO.setProductBarCode("002");
        productDO.setProductFullName("测试002");
        productDO.setAssembleStatus(0);
        productManager.insert(productDO);
    }

    @Test
    public void checkExists(){
        ProductQuery productQuery = new ProductQuery();
        productQuery.setProductBarCode("001");
        ProductDO productDO = productManager.checkExists(productQuery);
        System.err.println(productDO);
    }
}
