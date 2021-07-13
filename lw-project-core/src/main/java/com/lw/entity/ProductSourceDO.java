package com.lw.entity;

import com.common.entity.BaseDO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.lw.entity
 * @version: 1.0
 */
@Data
public class ProductSourceDO extends BaseDO {

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
