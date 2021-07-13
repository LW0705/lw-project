package com.lw.dto;

import com.common.dto.BaseDTO;
import lombok.Data;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/31
 * @Description: com.lw.dto
 * @version: 1.0
 */
@Data
public class ProductClassifyDTO extends BaseDTO {

    private static final long serialVersionUID = -7056423331384222324L;

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

    /**************额外字段*****************/
}
