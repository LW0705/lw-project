package com.lw.query;

import com.common.query.BaseQuery;
import lombok.Data;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/2
 * @Description: com.lw.query
 * @version: 1.0
 *
 * 礼包组合历史记录表
 */
@Data
public class ProductAssembleLogQuery extends BaseQuery {

    private static final long serialVersionUID = -7640852152262704801L;
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
     * 组合类型[单品|礼包]
     */
    private String assembleType;

    /**
     * 产品类型[不同产品|相同产品]
     */
    private String productType;
}
