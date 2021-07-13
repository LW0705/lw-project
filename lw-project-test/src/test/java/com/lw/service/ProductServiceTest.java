package com.lw.service;

import com.lw.AppConfig;
import com.lw.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.lw.service
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void insert(){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setProductName("测试003");
        productDTO.setProductGuid("003");
        productDTO.setProductBarCode("003");
        productDTO.setProductFullName("测试003");
        productDTO.setAssembleStatus(0);
        productService.insert(productDTO);
    }
}
