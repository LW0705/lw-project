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
public class ProductSourceDTO extends BaseDTO {

    private static final long serialVersionUID = 2124575525550025754L;

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

    /*************额外字段**************/

    /**
     * 名称
     */
    private String name;
}
