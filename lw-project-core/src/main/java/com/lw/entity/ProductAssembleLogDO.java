package com.lw.entity;

import com.common.entity.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.entity
 * @version: 1.0
 */
@Data
public class ProductAssembleLogDO extends BaseDO {

    /**
     * 数据版本号
     */
    private String dataVersion;

    /**
     * 父产品内部编码
     */
    private String pProductGuid;

    /**
     * 子产品内部编码
     */
    private String sProductGuid;

    /**
     * 基本数量
     */
    private BigDecimal basicNum;

    /**
     * 组合类型[单品|礼包]
     */
    private String assembleType;

    /**
     * 产品类型[不同产品|相同产品]
     */
    private String productType;
}
