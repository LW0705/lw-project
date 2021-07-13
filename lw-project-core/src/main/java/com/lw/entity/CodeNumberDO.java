package com.lw.entity;

import com.common.entity.BaseDO;
import lombok.Data;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/31
 * @Description: com.lw.entity
 * @version: 1.0
 */
@Data
public class CodeNumberDO extends BaseDO {

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 位数
     */
    private Integer size;

    /**
     * 数字
     */
    private Integer codeNumber;

    /**
     * 编码类型
     */
    private Integer codeType;
}
