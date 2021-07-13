package com.lw.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/5/31
 * @Description: com.lw.query
 * @version: 1.0
 */
@Data
public class CodeNumberQuery implements Serializable {

    private static final long serialVersionUID = -2452252549783073150L;
    /**
     * 编码类型[1财务编码|2条形码]
     */
    private Integer codeType;

    /**
     * 产品全称
     */
    private String fullName;

}
