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
public class ProductSourceQuery extends BaseQuery {

    private static final long serialVersionUID = -7233700010981843015L;

    /**
     * 产品内部编码
     */
    private String productGuid;

    /**
     * 产品来源[1OEM|2自产产品|3分装]
     */
    private Integer productSource;

    /**
     * 停用状态[0启用|1停用]
     */
    private Integer stopStatus;
}
