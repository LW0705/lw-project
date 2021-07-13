package com.lw.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.dto
 * @version: 1.0
 */
@Data
public class ProductGuidCodeDTO implements Serializable {

    private Long id;

    private String code;

    private String productGuid;

}
