package com.lw.query;

import com.common.query.BaseQuery;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.query
 * @version: 1.0
 * <p>
 * 组合礼包表
 */
@Data
public class ProductAssembleQuery extends BaseQuery {

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

    /***************额外字段*********************/
    /**
     * 组合状态[0.单品、1.组合、2.礼包]
     */
    private Integer assembleStatus;
    /**
     * 父产品ID列表
     */
    private List<String> productGuidList = new ArrayList<>();
}
