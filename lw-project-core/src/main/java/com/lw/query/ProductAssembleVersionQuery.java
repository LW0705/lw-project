package com.lw.query;

import com.common.query.BaseQuery;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.query
 * @version: 1.0
 */
@Data
public class ProductAssembleVersionQuery extends BaseQuery {

    private static final long serialVersionUID = -1477706606372337323L;

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

    /**
     * 查询模型[list查询明细|max获取当前版本]
     */
    private String mode = "list";

    /**
     * productGuid列表
     */
    private List<String> productGuidList = new ArrayList<>();
}
