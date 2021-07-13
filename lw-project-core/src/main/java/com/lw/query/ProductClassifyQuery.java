package com.lw.query;

import com.common.query.BaseQuery;
import lombok.Data;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.query
 * @version: 1.0
 */
@Data
public class ProductClassifyQuery extends BaseQuery {

    private static final long serialVersionUID = -1596015460866563015L;

    /**
     * 分类类型[product产品分类|sale销售分类|brand品牌分类|quality质量分类|market超市分类|groupbuy团购分类]
     */
    private String classifyType;

    /**
     * 分类ID
     */
    private Long classifyId;

    /**
     * 产品内部编码
     */
    private String productGuid;
}
