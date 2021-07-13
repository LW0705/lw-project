package com.lw.controller;

import com.common.result.SntResult;
import com.common.util.RpcExceptionUtils;
import com.lw.dto.ProductDTO;
import com.lw.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/3
 * @Description: com.lw.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public SntResult save(@RequestBody ProductDTO dto){
        try {
            productService.save(dto);
            return SntResult.ok(dto);
        } catch (Exception e) {
            log.error("ProductController save exception! error:{}",e.getMessage());
            return RpcExceptionUtils.getSntResult(e);
        }
    }

}
