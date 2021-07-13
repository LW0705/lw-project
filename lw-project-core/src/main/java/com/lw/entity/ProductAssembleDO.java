package com.lw.entity;

import com.common.entity.BaseDO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.entity
 * @version: 1.0
 *
 * 组合礼包表
 */
@Data
public class ProductAssembleDO extends BaseDO {
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


    /**********额外字段***************/
    /**
     * 销售价格(含税)
     */
    private BigDecimal salesPrice;

    /**
     * 69条形码
     */
    private String productBarCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品规格
     */
    private String productSpec;

    /**
     * 净含量(kg)
     */
    private BigDecimal netWeight;

    /**
     * 毛重(kg)
     */
    private BigDecimal grossWeight;

    /**
     * 大单位
     */
    private String bigUnit;

    /**
     * 小单位
     */
    private String smallUnit;

    /**
     * 产品guid列表
     */
    private List<String> productGuidList = new ArrayList<>();
}
