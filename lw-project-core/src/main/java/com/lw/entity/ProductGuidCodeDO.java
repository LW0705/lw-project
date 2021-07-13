package com.lw.entity;

import com.common.entity.BaseDO;
import lombok.Data;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.entity
 * @version: 1.0
 *
 * 产品编码映射表
 */
@Data
public class ProductGuidCodeDO extends BaseDO {

    private Long id;

    private String code;

    private String productGuid;

}
