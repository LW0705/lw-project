package com.lw.entity;

import com.common.entity.BaseDO;
import lombok.Data;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.dto
 * @version: 1.0
 *
 * 礼包组合变更版本表
 */
@Data
public class ProductAssembleVersionDO extends BaseDO {

    /**
     * 数据版本号
     */
    private String dataVersion;

    /**
     * 数据类型[1常规|2替换]
     */
    private Integer dataType;

    /**
     * 组合类型[0单品|1组合|2礼包]
     */
    private Integer assembleStatus;

    /**
     * 产品类型[不同产品|相同产品]
     */
    private String productType;

    /**
     * 产品内部编码
     */
    private String productGuid;

    /**
     * 产品名称(简称)
     */
    private String productName;

    /**
     * 69条形码
     */
    private String productBarCode;

    /**
     * 财务编码
     */
    private String financialCode;
}
