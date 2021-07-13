package com.lw.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.entity
 * @version: 1.0
 *
 * 产品编码表
 */
@Data
public class ProductCodeDO implements Serializable {

    private Long id;

    private String code;

    private Integer status;
}
